/**
 * Created by student on 15.10.16.
 */

import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) {

        Args parsel = new Parser(args).parse();

        List<User> users = new ArrayList<>();
        users.add(new User(1, "John Doe", "jdoe", "sup3rpaZZ"));
        users.add(new User(2, "Jane Row", "jrow", "Qweqrty12"));

        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1, users.get(0), "READ", "a"));
        roles.add(new Role(2, users.get(0), "WRITE", "a.b"));
        roles.add(new Role(3, users.get(1), "EXECUTE", "a.b.c"));
        roles.add(new Role(4, users.get(0), "EXECUTE", "a.bc"));


        boolean l1 = thisLogin(parsel, users);
        boolean p1 = thisPassword(parsel, users);
        System.out.println("Check try login: " + l1 + " and password: " + p1);
        thisAuthentication(parsel, users);
        boolean r1 = thisRole(parsel);
        boolean r2 = thisResource(parsel, roles);
        System.out.println("Check try role: " + r1 + " and resource: " + r2);
        thisAuthorization(roles, parsel);
    }

    // ������������� ������� (�������) ��� ������ � ������� ������������
    //���� �� ������ � ������
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

    private static void thisAccounting(Args args1){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate sDate = null;
        LocalDate fDate = null;
        int vol = 0;

    }

    private static boolean thisRole(Args args1) {
        try {
            for (Permission perm : Permission.values()) {
                if (args1.role.equals(perm.toString())) {
                    return true;
                }
            }
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }



    private static boolean thisResource(Args args1, List<Role> roles) {
        for (Role role : roles){
            if (args1.getRole().equals(role.name)
                    && thisCheking(role.resource, args1.getResource())
                    && (args1.getLogin().equals(role.getUser().getLogin()))){return true;}}return false;}


    private static boolean thisCheking(String Resource, String division)
    {
        String[] res;
        String[] div;
        res = Resource.split("\\.");
        div = division.split("\\.");
        if (div.length < res.length) {
            return false;
        } else {
            for (int i = 0; i < res.length; i++) {
                if (!res[i].equals(div[i])) {
                    return false;
                }
            }
        }
        return true;
    }

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
�������� ������ �� ������
1, jdoe, Role.READ, "a"
2, jdoe, Role.WRITE, "a.b"
3, jrow, Role.EXECUTE, "a.b.c"
4, jdoe, Role.EXECUTE, "a.bc"

*/
