# Data Safety Notes

These notes are a preparation aid. Store answers must always match the exact production build and the current behavior of every included SDK.

## Current source-code behavior

The current version keeps demo school communication state locally in memory. It does not currently upload student names, class information, family codes, teacher passcodes, messages, monthly counters, or unlock status to a developer-operated server.

The current version includes Google AdMob and Google User Messaging Platform (UMP). Advertising providers may process data needed for advertising, measurement, diagnostics, security, and fraud prevention, depending on device, region, settings, and consent choices.

## Data types to review for AdMob

Confirm the current Google Mobile Ads SDK disclosure guidance when completing the store form. Relevant categories may include:

- Device or other identifiers
- Approximate location derived from IP address
- App interactions related to advertising
- Advertising data
- Diagnostics
- Security and fraud-prevention data

Do not copy these notes blindly into a store form. Verify the actual release behavior and the store's current definitions.

## Current app data to review

- Student names included in or entered into the app
- Class information
- Private family access codes
- Teacher passcode
- Teacher messages
- Message unlock status
- Monthly access counters

For the current local-only implementation, determine whether the store form treats locally processed, non-transmitted data as collected under its current rules.

## Future Firebase review

Firebase is not currently active in the Android source. If Firestore, Authentication, Cloud Messaging, Analytics, Crashlytics, or another Firebase service is added later, reassess:

- What data leaves the device
- Why each data type is collected
- Whether data is shared with service providers
- Encryption in transit
- Retention periods
- User deletion or school-administrator deletion procedures
- Firestore security rules and role-based access
- Notification tokens
- Account identifiers and authentication data

## Required before release

- Confirm exactly what data is collected or shared by the final APK/AAB.
- Confirm the purpose of every data type.
- Confirm whether collection is required or optional.
- Make the Data Safety answers match the public Privacy Policy.
- Declare that the app contains ads.
- Add the Privacy Policy and developer website URLs to the store listing.
- Update these notes whenever SDKs or backend behavior change.
