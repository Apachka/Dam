/**
 * Created by student on 15.10.16.
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "John Doe", "jdoe", "sup3rpaZZ"));
        users.add(new User(2, "Jane Row", "jrow", "Qweqrty12"));
        System.out.println("New Users: " + users);

        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1, users.get(0), "READ", "a"));
        roles.add(new Role(2, users.get(0), "WRITE", "a.b"));
        roles.add(new Role(3, users.get(1), "EXECUTE", "a.b.c"));
        roles.add(new Role(4, users.get(0), "EXECUTE", "a.bc"));

    }
}


/*
public class Main
{
    public static void main(String ...args) {
        ArrayList <User> users = new ArrayList<>();
        //users.add(1,"John Doe", "jdoe", "sup3rpaZZ");
        //users.add(new User("John Doe"));
        users.add(("John Doe"));
        //users.add(2,"Jane Row", "jrow", "Qweqrty12");
        System.out.println("New Users: " + users);


1, "John Doe", "jdoe", "sup3rpaZZ"
2, "Jane Row", "jrow", "Qweqrty12"
Тестовые данные по правам
1, jdoe, Role.READ, "a"
2, jdoe, Role.WRITE, "a.b"
3, jrow, Role.EXECUTE, "a.b.c"
4, jdoe, Role.EXECUTE, "a.bc"

*/