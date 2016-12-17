#!/usr/bin/env bash
#Главный класс
MAIN="Main"
#Папка с результатами
OUT="out"
#Путь к библиотеке
LIB="lib/*"
#Исходники
SRC="src/"

# Временная папка в которой собирается приложение
OUT="out"
# Итоговое имя jar файла
OUT_JAR="$OUT/aaa.jar"
# Папка в которой находятся откомпилированные классы
OUT_CLS="$OUT/classes/"
# Папка в которую копируются библиотеки
OUT_LIB="$OUT/lib/"

# Подстановка : или ; в зависимости от операционной системы
LIB="lib/*"
OUT_JAR="out/aaa.jar"
if [ "$(uname)" == "Darwin" ]; then
    # Do something under Mac OS X platform
    CP="$LIB:$OUT_JAR"
elif [ "$(expr substr $(uname -s) 1 5)" == "Linux" ]; then
    # Do something under GNU/Linux platform
    CP="$LIB:$OUT_JAR"
elif [ "$(expr substr $(uname -s) 1 10)" == "MINGW32_NT" ]; then
    # Do something under Windows NT platform
    CP="$LIB;$OUT_JAR"
elif [ "$(expr substr $(uname -s) 1 10)" == "MINGW64_NT" ]; then
    # Do something under Windows NT platform
    CP="$LIB;$OUT_JAR"
fi
echo !!! $CP
