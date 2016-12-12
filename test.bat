@echo off
echo 1.0
java -cp "out\artifacts\Eng_jar\Eng.jar" com.programma.engin.Main > NUL
echo !!! 0 %errorlevel%
java -cp "out\artifacts\Eng_jar\Eng.jar" com.programma.engin.Main -h > NUL
echo !!! 0 %errorlevel%

echo 2.0
java -cp "out\artifacts\Eng_jar\Eng.jar" com.programma.engin.Main -login QQQQ -pass QQQQ > NUL
echo !!! 1 %errorlevel%
java -cp "out\artifacts\Eng_jar\Eng.jar" com.programma.engin.Main -login jdoe -pass QQQQ > NUL
echo !!! 2 %errorlevel%
java -cp "out\artifacts\Eng_jar\Eng.jar" com.programma.engin.Main -login jdoe -pass sup3rpaZZ > NUL
echo !!! 0 %errorlevel%

echo 3.0
java -cp "out\artifacts\Eng_jar\Eng.jar" com.programma.engin.Main -login jdoe -pass sup3rpaZZ -role READ -res a > NUL
echo !!! 0 %errorlevel%
java -cp "out\artifacts\Eng_jar\Eng.jar" com.programma.engin.Main -login jdoe -pass sup3rpaZZ -role READ -res a.b > NUL
echo !!! 0 %errorlevel%
java -cp "out\artifacts\Eng_jar\Eng.jar" com.programma.engin.Main -login jdoe -pass sup3rpaZZ -role QQQQ -res a.b > NUL
echo !!! 3 %errorlevel%
java -cp "out\artifacts\Eng_jar\Eng.jar" com.programma.engin.Main -login jdoe -pass sup3rpaZZ -role READ -res QQQQ > NUL
echo !!! 4 %errorlevel%
java -cp "out\artifacts\Eng_jar\Eng.jar" com.programma.engin.Main -login jdoe -pass sup3rpaZZ -role WRITE -res a > NUL
echo !!! 4 %errorlevel%
java -cp "out\artifacts\Eng_jar\Eng.jar" com.programma.engin.Main -login jdoe -pass sup3rpaZZ -role WRITE -res a.bc > NUL
echo !!! 4 %errorlevel%

echo 4.0
java -cp "out\artifacts\Eng_jar\Eng.jar" com.programma.engin.Main -login jdoe -pass sup3rpaZZ -role READ -res a.b -sd 2015.01.01 -fd 2015.12.31 -vol 100 > NUL
echo !!! 0 %errorlevel%
java -cp "out\artifacts\Eng_jar\Eng.jar" com.programma.engin.Main -login jdoe -pass sup3rpaZZ -role READ -res a.b -sd 01.01.2015 -fd 2015.12.31 -vol 100 > NUL
echo !!! 5 %errorlevel%
java -cp "out\artifacts\Eng_jar\Eng.jar" com.programma.engin.Main -login jdoe -pass sup3rpaZZ -role READ -res a.b -sd 2015.01.01 -fd 2015.12.31 -vol QQQQ > NUL
echo !!! 5 %errorlevel%

echo 5.0
java -cp "out\artifacts\Eng_jar\Eng.jar" com.programma.engin.Main -login QQQQ -pass QQQQ -role READ -res QQQQ -sd 2015.01.01 -fd 2015.12.31 -vol QQQQ > NUL
echo !!! 1 %errorlevel%
java -cp "out\artifacts\Eng_jar\Eng.jar" com.programma.engin.Main -login QQQQ -pass QQQQ -role READ -res QQQQ > NUL
echo !!! 1 %errorlevel%