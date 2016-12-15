# Protocol AAA (Authentication, Authorization, Accounting)

###- Build
```
+$ ./build.sh
```
###- Run
```
+$ ./run.sh
```
###- Command Help(FAQ):
```
-h     Help and Information:
-login Login:
-pass  Password:
-role  Role:
-res   Resource:
-sd    Start Date:
-fd    Finally Date:
-val   Volume:
```
**Authentication:**
```
-login -pass
```
**Authorization:**
```
-login -pass -role -res
```
**Accounting:**
```
-login -pass -role -res -sd -fd -vol
```
