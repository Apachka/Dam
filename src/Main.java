/**
 * Created by student on 15.10.16.
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        System.out.println("Example 2 - Start");
        users.add(new User(1, "John Doe", "jdoe", "sup3rpaZZ"));
        users.add(new User(2, "Jane Row", "jrow", "Qweqrty12"));

        //передача параметров в приложение
        String login1=args[0];
        String pass1=args[1];
        //вывод параметров в консоль
        System.out.printf("users1: login=%s, pass=%s \n", login1, pass1);
        //System.out.println(pass);
        //String pass=args[1];
        //System.out.println(pass);
        String login2=args[2];
        String pass2=args[3];
        System.out.printf("users2: login=%s, pass=%s \n", login2, pass2);
/*ѕроверка на логин jrow у всех пользователей
        for (int i = 0; i < users.size(); i++)
        {
            if (users.get(i).equals("jdoe"))
            {
                System.out.println("Bingo!");
            }
            else System.out.println("ftgft!");
                break;
        }
*/



        /*List<Role> roles = new ArrayList<>();
        roles.add(new Role(1, users.get(0), "READ", "a"));//юзер 1
        roles.add(new Role(2, users.get(0), "WRITE", "a.b"));//юзер 1
        //юзеру под номером 2(список с 0) присваиваютс€ прва доступа "EXECUTE", "a.b.c"
        roles.add(new Role(3, users.get(1), "EXECUTE", "a.b.c"));
        roles.add(new Role(4, users.get(0), "EXECUTE", "a.bc"));//юзер 1
        System.out.println("Example 2 - End");
*/
        //код возврата
        System.exit(1);

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
“естовые данные по правам
1, jdoe, Role.READ, "a"
2, jdoe, Role.WRITE, "a.b"
3, jrow, Role.EXECUTE, "a.b.c"
4, jdoe, Role.EXECUTE, "a.bc"

*/