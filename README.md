# My Teacher

Premium Android app for secure parent-teacher communication, student message delivery, monthly free message access, and rewarded-ad unlocks.

## Purpose

My Teacher helps teachers communicate with parents through a simple, secure, and mobile-first Android experience. Teachers can manage students, send messages, and parents can access child-specific messages using a private family code.

## Core Features

- Teacher login and passcode change
- Student list and private family access code per student
- Parent message inbox
- Five free message openings per month
- Rewarded-ad unlock after the free monthly limit
- Google AdMob SDK integration
- Google UMP consent flow before ad requests
- Privacy choices entry point when required
- Public Privacy Policy and app-ads.txt support
- Firebase-ready documentation for future cloud storage

## Parent Message Access Logic

Parents can open 5 messages for free each month. Starting from the 6th message, a message remains locked until a rewarded ad is completed. The app unlocks the message only from the earned-reward callback; loading, opening, failing, or dismissing an ad does not unlock it.

## Android Package

```text
com.walhero.myteacher
```

## Store Name

```text
My Teacher
```

## AdMob Development Status

The technical AdMob and UMP integration is present. Google sample IDs are intentionally configured during development:

```text
Sample App ID: ca-app-pub-3940256099942544~3347511713
Rewarded test ID: ca-app-pub-3940256099942544/5224354917
```

Before production, create My Teacher as a separate app in AdMob and replace both sample IDs in `app/build.gradle.kts`. Never reuse the Walhero Live Wallpaper App ID or ad-unit ID.

## Privacy and Developer Website

- Privacy Policy: `https://princejour.github.io/my-teacher-privacy.html`
- Developer website: `https://princejour.github.io/`
- app-ads.txt: `https://princejour.github.io/app-ads.txt`

## Documentation

- [FAQ](FAQ.md)
- [Privacy Policy](PRIVACY_POLICY.md)
- [Terms of Use](TERMS_OF_USE.md)
- [Support](SUPPORT.md)
- [Security](SECURITY.md)
- [Changelog](CHANGELOG.md)
- [Store Listing](docs/store-listing.md)
- [Data Safety Notes](docs/data-safety-notes.md)
- [Screenshots Guide](docs/screenshots-guide.md)
- [Release Checklist](docs/release-checklist.md)
- [Firebase Setup](docs/firebase-setup.md)
- [AdMob, UMP, and Rewarded Ads](docs/admob-rewarded-ads.md)

## Important Notice

The current app keeps demo school communication state locally. If Firebase or another backend is added, production release must use secure authentication and database rules, and the Privacy Policy and store Data Safety declarations must be updated to match the released behavior.

## License

MIT License. See [LICENSE](LICENSE).
