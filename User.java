/**
 * Created by student on 15.10.16.
 */
public class User {
    private int id;
    private String name;
    private String login;
    private String password;

    public User(User u) {
        this.id = u.id;
        this.name = u.name;
        this.login = u.login;
        this.password = u.password;
    }

    public User(int id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }
}