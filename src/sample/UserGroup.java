// Composite

package sample;

import java.util.ArrayList;

public class UserGroup implements UserInterface {
    private String id;
    private UserGroup parent;
    private ArrayList<UserGroup> subgroups = new ArrayList<UserGroup>();
    private ArrayList<User> users = new ArrayList<User>();


    @Override
    public String getId() {
        return id;
    }
}
