# diary_app
Diary app

Android app made in Android Studio to record diary entries from the user.

App uses weak encryption and password protection to protect entries against prying eyes.

The encryption is weak so that in the event of the user losing their password, entires can be recovered. This app is not designed to be hacker-proof, just enough to stop nosey friends/siblings, etc.

The app stores the sha1 hash of the chosen password which must be entered to read entries or add a new one.

Entries are encrypted with a vigenere cipher, using the password as the key and then converted into base64 before being stored.
