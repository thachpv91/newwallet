
#	<groupId>org.bitcoinj</groupId>
#	<artifactId>digitalcoinj-core</artifactId>
#	<version>0.12.3</version>

export FULL_PATH=/home/bapvn/Downloads/digitalcoinj-core-0.12.3
export GROUP_ID=org.bitcoinj
export ARTIFACT_ID=digitalcoinj-core
export VERSION=0.12.3
export PACKAGING=jar

mvn install:install-file  -Dfile=$FULL_PATH -DgroupId=$GROUP_ID -DartifactId=$ARTIFACT_ID -Dversion=VERSION -Dpackaging=$PACKAGING
