#!/bin/sh

#	<groupId>org.bitcoinj</groupId>
#	<artifactId>digitalcoinj-core</artifactId>
#	<version>0.12.3</version>

FULL_PATH=$PWD/libs/bapcoinj-core-0.12.3.jar
GROUP_ID=org.bitcoinj
ARTIFACT_ID=bapcoinj-core
VERSION=0.12.3
PACKAGING=jar

mvn install:install-file  -Dfile=$FULL_PATH -DgroupId=$GROUP_ID -DartifactId=$ARTIFACT_ID -Dversion=$VERSION -Dpackaging=$PACKAGING
