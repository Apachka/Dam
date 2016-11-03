/**
 * Created by student on 15.10.16.
 */

import com.sun.org.apache.xpath.internal.Arg;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Args parsel = new Parser(args).parse();

        System.out.println(parsel.password);

        List<User> users = new ArrayList<>();
        users.add(new User(1, "John Doe", "jdoe", "sup3rpaZZ"));
        users.add(new User(2, "Jane Row", "jrow", "Qweqrty12"));

        //передача параметров в приложение
        //String login1 = args[0], pass1 = args[1], login2 = args[2], pass2 = args[3];
        //System.out.printf("users1: login=%s, pass=%s \n", login1, pass1);
        //System.out.printf("users2: login=%s, pass=%s \n", login2, pass2);

        //System.exit(1);


        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1, users.get(0), "READ", "a"));//юзер 1
        roles.add(new Role(2, users.get(0), "WRITE", "a.b"));//юзер 1
        //юзеру под номером 2(список с 0) присваиваютс€ прва доступа "EXECUTE", "a.b.c"
        roles.add(new Role(3, users.get(1), "EXECUTE", "a.b.c"));
        roles.add(new Role(4, users.get(0), "EXECUTE", "a.bc"));//юзер 1
        System.out.println("Example 2 - End");


        //проверка по списку пользователей,код ошибки если пользователь не найден
        //Parser allusers = new Parser(args);
        //если все юзеры прошли аутентификацию(метод в Dataofuser со значени€ми 0),
        // тогда запуск метода authentication(проверки)
        /*        if(allusers)
        {
            checkAuthentication(users, allusers);
            if (!allusers)
            {
                System.exit(0);}
            else{
                checkAuthorization(roles, allusers);
            }
        }
        }
        */
    }




    //сопоставление персоны (запроса) сущ учетки в системе безопасности
//осущ по логину, паролю
    public static void checkAuthentication(List<User> users)
    {

    }


    //проверка уровн€ доступа - сопоставление учетки записи в системе
//(и персоны, прошедшей аутентификацию) и определЄнных полномочий
    public static void checkAuthorization(List<Role> roles)
    {

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