Welcome to _Bapcoin Wallet_, a standalone digitalcoin payment app for your Android device!

This project contains several sub-projects:

 * __wallet__:
     The Android app itself. This is probably what you're searching for.
 * __market__:
     App description and promo material for the Google Play app store.
 * __integration-android__:
     A tiny library for integrating digitial payments into your own Android app
     (e.g. donations, in-app purchases).
 * __sample-integration-android__:
     A minimal example app to demonstrate integration of digital payments into
     your Android app.

Build lib:

`./_make_libs.sh`

Setup lib to local repository

`./setup.sh`

Buill all sub-project

`mvn clean install -Dmaven.test.skip=true` 

or

`./make.sh`

Install apk

`./install.sh`
