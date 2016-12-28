#!/usr/bin/env bash
source ./config.sh
# Это в BUILD.sh

rm -rf $OUT
# Компиляция всех *.java файлов
mkdir -p $OUT_CLS
cp $LIB $OUT_LIB

find . -name "*.java" | xargs javac -cp "$CP" -d $OUT_CLS -sourcepath $SRC -verbose



# Архивация всех классов в $OUT_JAR в jar файл, где $MAIN – класс с main()
jar -cfe $OUT_JAR $MAIN -C $OUT_CLS .