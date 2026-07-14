# AdMob, UMP, and Rewarded Ads Setup

## Current implementation

My Teacher now includes:

- Google Mobile Ads SDK `23.0.0`
- Google User Messaging Platform SDK `4.0.0`
- AdMob App ID metadata in `AndroidManifest.xml`
- Consent information update at every app launch
- Consent form display when required
- Ad requests gated behind `canRequestAds()`
- Visible **Privacy choices** entry point when required
- Rewarded-ad preloading and full-screen callbacks
- Message unlock only inside the earned-reward callback
- Public Privacy Policy link inside the app
- Public developer website and root-level `app-ads.txt`

## Monthly access logic

```text
Messages 1 to 5: free access
Message 6 and above: locked until rewarded ad completion
```

## Development IDs currently configured

The project intentionally uses Google's Android sample IDs while the app is being built and tested.

AdMob sample App ID:

```text
ca-app-pub-3940256099942544~3347511713
```

Rewarded test Ad Unit ID:

```text
ca-app-pub-3940256099942544/5224354917
```

These values are configured in `app/build.gradle.kts`.

## Required production replacement

Before publishing a monetized build:

1. Create **My Teacher** as a separate app in the user's AdMob account.
2. Create a Rewarded ad unit for the message-unlock placement.
3. Replace `adMobAppId` in `app/build.gradle.kts` with the My Teacher AdMob App ID.
4. Replace `ADMOB_REWARDED_AD_UNIT_ID` in the same file with the My Teacher Rewarded Ad Unit ID.
5. Publish the privacy message for the new My Teacher AdMob App ID under **Privacy & messaging**.
6. Build and test the consent flow and rewarded unlock.

Never use the Walhero Live Wallpaper App ID or ad-unit ID in My Teacher.

## Public privacy and app-ads.txt URLs

```text
https://princejour.github.io/my-teacher-privacy.html
https://princejour.github.io/app-ads.txt
```

The root `app-ads.txt` already contains the AdMob publisher account line:

```text
google.com, pub-2807969310197931, DIRECT, f08c47fec0942fa0
```

One publisher line can authorize the same AdMob account for multiple apps. The store listing must use `https://princejour.github.io/` as the developer website so AdMob can discover the root file.

## Store release declarations

Before store submission:

- Declare that the app contains ads.
- Add the public Privacy Policy URL.
- Add the developer website URL.
- Complete the store Data Safety or privacy questionnaire so it matches the released SDKs and actual app behavior.
- Link the public store listing to the My Teacher app in AdMob.
- Request AdMob app review only after the store page is publicly accessible.

## Unlock rule

The app must never unlock a paid message when the ad merely loads, opens, fails, or is dismissed early. Unlocking is permitted only when `OnUserEarnedRewardListener` is called.

## Future Firebase work

The current app keeps demo school communication state locally. If Firebase is added later, persist free-message counters and rewarded unlock status securely, update Firestore rules, and revise the Privacy Policy and store Data Safety answers before release.
