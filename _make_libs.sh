#!/bin/sh

PROJECT_PATH=$PWD
LIBS_PATH=$PWD/libs
LIB_BAPCOIN_PATH=$LIBS_PATH/bapcoinj/


# make bapcoin lib

cd $LIB_BAPCOIN_PATH
# 1. make lib
mvn clean install -Dmaven.test.skip=true
# 2. copy libs
cp core/target/bapcoinj*.jar  $LIBS_PATH/
echo "Build && copy lib done!"


cd $PROJECT_PATH


