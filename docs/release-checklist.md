# Release Checklist

Use this checklist before every release.

## App Identity

- [x] App name confirmed: My Teacher
- [x] Package name confirmed: `com.walhero.myteacher`
- [ ] App icon finalized
- [ ] Splash screen finalized
- [x] Version code increased for AdMob integration
- [x] Version name updated to 1.1

## AdMob Application

- [ ] Create My Teacher as a separate app in AdMob
- [ ] Copy the dedicated My Teacher AdMob App ID
- [ ] Create a dedicated Rewarded ad unit
- [ ] Replace the Google sample App ID in `app/build.gradle.kts`
- [ ] Replace the Google rewarded test ID in `app/build.gradle.kts`
- [x] Google Mobile Ads SDK integrated
- [x] Rewarded ad loading integrated
- [x] Message unlock occurs only after earned-reward callback
- [ ] Test production IDs only on registered test devices before release

## Consent and Privacy

- [x] UMP 4.0.0 integrated
- [x] Consent status requested at every app launch
- [x] Consent form shown when required
- [x] Ad requests blocked until UMP permits them
- [x] Privacy choices entry point shown when required
- [x] In-app Privacy Policy link added
- [x] Public Privacy Policy published
- [ ] Publish the My Teacher privacy message in AdMob Privacy & messaging
- [ ] Test EEA/UK/Switzerland consent behavior using UMP debug settings

## Developer Website and app-ads.txt

- [x] Developer website published: `https://princejour.github.io/`
- [x] Privacy Policy published: `https://princejour.github.io/my-teacher-privacy.html`
- [x] Root app-ads.txt published: `https://princejour.github.io/app-ads.txt`
- [x] Publisher ID line verified in repository
- [ ] Add the developer website URL to the public store listing
- [ ] Confirm AdMob detects and verifies app-ads.txt after publication

## Store Declarations

- [ ] Public store listing completed
- [ ] Declare that the app contains ads
- [ ] Add the Privacy Policy URL
- [ ] Add the developer website URL
- [ ] Complete Data Safety/privacy answers based on the released build
- [ ] Ensure the listing identifies teachers, parents, and guardians as the intended operators
- [ ] Link the public store listing to the My Teacher app in AdMob
- [ ] Request AdMob review only after the store page is public

## Firebase — Future Production Work

The current app does not yet transmit school messages to Firebase.

- [ ] Production Firebase project ready, if cloud features are added
- [ ] Android app registered in Firebase
- [ ] `google-services.json` supplied securely
- [ ] Firestore security rules reviewed
- [ ] Authentication and access-control model reviewed
- [ ] Cloud Messaging tested, if notifications are added
- [ ] Privacy Policy and Data Safety answers updated before release

## Build and Signing

- [ ] Signing key configured securely
- [ ] GitHub Secrets configured
- [ ] Release APK or AAB generated
- [ ] Installation tested
- [ ] Update over previous version tested

## Final Functional Review

- [ ] Teacher flow tested
- [ ] Family flow tested
- [ ] Five-free-message limit tested
- [ ] Rewarded unlock tested after full ad completion
- [ ] Early ad dismissal does not unlock a message
- [ ] Ad load/show failure does not unlock a message
- [ ] Privacy choices opens correctly when required
- [ ] Privacy Policy link opens correctly
- [ ] No test credentials or sample AdMob IDs remain in the production build
