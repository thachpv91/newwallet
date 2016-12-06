#!/bin/sh
PROJECT_PATH=$PWD
WALLET_APK_PATH=$PROJECT_PATH/wallet/target

adb install -r  $WALLET_APK_PATH/wallet-3.01.420.apk
