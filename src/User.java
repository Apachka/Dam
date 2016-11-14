/**
 * Created by student on 15.10.16.
 */

/**
 * Created by student on 14.11.2016.
 */
public class User {
    private int id;
    private String name;
    private String login;
    private String password;
    private String salt;

    public User(int id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}