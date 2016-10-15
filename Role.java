/**
 * Created by student on 15.10.16.
 */
public class Role {
    private int id;
    private User user;
    private String name;
    private String resource;


    public Role(Role r) {
        this.id = r.id;
        this.user = r.user;
        this.name = r.name;
        this.resource = r.resource;
    }


    public Role(int id, User user, String name, String resource) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.resource = resource;
    }
}