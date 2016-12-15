#!/usr/bin/env bash
source ./config.sh

echo !!!! $CP
java -classpath "$CP" $MAIN $*