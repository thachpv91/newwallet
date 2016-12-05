export FULL_PATH=/home/bapvn/Downloads/ZIPFiles/core-1.54.0.0.jar
export GROUP_ID=com.madgag.spongycastle
export ARTIFACT_ID=core
export VERSION=1.54.0.0

mvn install:install-file  -Dfile=$FULL_PATH -DgroupId=$GROUP_ID -DartifactId=$ARTIFACT_ID -Dversion=VERSION -Dpackaging=jar