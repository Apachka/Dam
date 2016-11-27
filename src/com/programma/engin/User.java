package com.programma.engin;

/**
 * Created by student on 14.11.2016.
 */
import static com.programma.engin.Secure.getHash;
import java.security.NoSuchAlgorithmException;
public class User {
     private int id;
    private String name;
    private String login;
    private String password;
    private String salt;

    public User(int id, String name, String login, String password)throws NoSuchAlgorithmException {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.salt = Secure.generateSalt();
        this.password = getHash(getHash(password) + salt);
    }

    public String getLogin()
    {
        return login;
    }

    public String getPassword() {
        return password;
    }
    public String getSalt() {
        return salt;
    }

}