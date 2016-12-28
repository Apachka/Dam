#!/usr/bin/env bash
result=0 # number of failed tests

test () {
    arr=($1)
    ./run.sh ${arr[*]}
    status=$?
    if [[ $status -ne $2 ]]; then
        echo TESTING FAIL $1 $status "!=" $2
        ((result+=1))
    else
        echo TESTING OK $1 $status "==" $2
    fi
    return $status
}

./build.sh

echo 1.0
test " " 0
test "-h" 0

echo 2.0
test "-login QQQQ -pass QQQQ" 1
test "-login jdoe -pass QQQQ" 2
test "-login jdoe -pass sup3rpaZZ" 0

echo 3.0
test "-login jdoe -pass sup3rpaZZ -role READ -res a" 0
test "-login jdoe -pass sup3rpaZZ -role READ -res a.b" 0
test "-login jdoe -pass sup3rpaZZ -role QQQQ -res a.b" 3
test "-login jdoe -pass sup3rpaZZ -role READ -res QQQQ" 4
test "-login jdoe -pass sup3rpaZZ -role WRITE -res a" 4
test "-login jdoe -pass sup3rpaZZ -role WRITE -res a.bc" 4

echo 4.0
test "-login jdoe -pass sup3rpaZZ -role READ -res a.b -sd 2015.01.01 -fd 2015.12.31 -vol 100" 0
test "-login jdoe -pass sup3rpaZZ -role READ -res a.b -sd 01.01.2015 -fd 2015.12.31 -vol 100" 5
test "-login jdoe -pass sup3rpaZZ -role READ -res a.b -sd 2015.01.01 -fd 2015.12.31 -vol QQQQ" 5

echo 5.0
test "-login QQQQ -pass QQQQ -role READ -res QQQQ -sd 2015.01.01 -fd 2015.12.31 -vol QQQQ" 1
test "-login QQQQ -pass QQQQ -role READ -res QQQQ" 1

echo
if [[ $result -gt 0 ]]; then
    echo $result tests failed
else
    echo ALL TESTS PASSED
fi
exit ${result}