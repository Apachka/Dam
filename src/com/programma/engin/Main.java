package com.programma.engin;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.security.NoSuchAlgorithmException;
import static com.programma.engin.Secure.getHash;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

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
        thisAccounting(parsel);

    }

    private static void thisAuthentication(Args args1, List<User> users) throws NoSuchAlgorithmException {
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

    private static void thisAccounting(Args args1) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate sDate = null;
        LocalDate fDate = null;
        int vol = 0;
        try {
            System.out.println(args1.getsDate());
            System.out.println(args1.getfDate());
            sDate = LocalDate.parse(args1.getsDate(),dateFormat);
            fDate = LocalDate.parse(args1.getfDate(),dateFormat);
        } catch (java.time.format.DateTimeParseException e) {
            System.out.println("Period: " + args1.getsDate() + " - " + args1.getfDate() + " is invalid activity");
            System.exit(5);
        }
        try {
            Integer.parseInt(args1.getVol());
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Wrong vol!");
            System.exit(5);
        }
        System.out.println("Successfully Accounting");

        //Acc acc = new Acc(1, args1.getfDate(), args1.getsDate(), args1.getVol());
        //dataBase.putIntoAccounting(acc);
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
        for (Role role : roles) {
            if (args1.getRole().equals(role.name)
                    && thisCheking(role.resource, args1.getResource())
                    && (args1.getLogin().equals(role.getUser().getLogin()))) {
                return true;
            }
        }
        return false;
    }


    private static boolean thisCheking(String Resource, String division) {
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

    private static boolean thisPassword(Args args1, List<User> users) throws NoSuchAlgorithmException {
        for (User user : users) {
            String hashpass = getHash(getHash(args1.getPassword()) + user.getSalt());
            if (hashpass.equals(user.getPassword()))
            {
                    return true;
                }
                   }
            return false;
    }

}

