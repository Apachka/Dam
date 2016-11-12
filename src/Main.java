/**
 * Created by student on 15.10.16.
 */

import java.security.Permission;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Args parsel = new Parser(args).parse();


        List<User> users = new ArrayList<>();
        users.add(new User(1, "John Doe", "jdoe", "sup3rpaZZ"));
        users.add(new User(2, "Jane Row", "jrow", "Qweqrty12"));

        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1, users.get(0), "READ", "a"));//юзер 1
        roles.add(new Role(2, users.get(0), "WRITE", "a.b"));//юзер 1
        //юзеру под номером 2(список с 0) присваиваются прва доступа "EXECUTE", "a.b.c"
        roles.add(new Role(3, users.get(1), "EXECUTE", "a.b.c"));
        roles.add(new Role(4, users.get(0), "EXECUTE", "a.bc"));//юзер 1

        boolean l1 = thisLogin(parsel, users);
        boolean p1 = thisPassword(parsel, users);
        System.out.println("Check try login: "+l1+" and password: "+p1);
        thisAuthentication(parsel, users);
        boolean r1 = thisRole(parsel);
        boolean r2 = thisResource(parsel, roles);
        System.out.println("Check try role: "+r1+" and resource: "+r2);
        thisAuthorization(roles, parsel);


    }





    // сопоставление персоны (запроса) сущ учетки в системе безопасности
    //осущ по логину и паролю
    private static void thisAuthentication(Args args1, List<User> users) {
        if (thisLogin(args1, users)) {
            if (thisPassword(args1, users)) {
                System.out.println("Successfully Authentication");

            } else {
                System.out.println("Wrong password");
                System.exit(2);
            }
        } else {
            System.out.println("Unknown user");
            System.exit(1);
        }
    }

private static void thisAuthorization(List<Role> roles, Args args1) {
        if (thisRole(args1)) {
            if (thisResource(args1, roles)) {
                System.out.println("Successfully Authorization");
            } else {
                System.out.println("Doesn't exist");
                System.exit(4);
            }
        } else {
            System.out.println("Unknown Role");
            System.exit(3);
        }
}

    private static boolean thisRole(Args args1) {return true;}

    private static boolean thisResource(Args args1, List<Role> roles) {return true;}


    private static boolean thisLogin(Args args1, List<User> users) {
        for (User user : users) {
            if (user.getLogin().equals(args1.login)) {
                return true;
            }
        }
        return false;
    }

    private static boolean thisPassword(Args args1, List<User> users) {
        for (User user : users) {
            if (user.getPassword().equals(args1.password) && user.getLogin().equals(args1.login)) {

                return true;
            }


        }
        return false;
    }


}




/*
Тестовые данные по правам
1, jdoe, Role.READ, "a"
2, jdoe, Role.WRITE, "a.b"
3, jrow, Role.EXECUTE, "a.b.c"
4, jdoe, Role.EXECUTE, "a.bc"
*/