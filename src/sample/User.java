// Leaf

package sample;

import java.util.ArrayList;

public class User implements UserInterface {
    private String id;
    private ArrayList<User> followers;
    private ArrayList<User> followings;
    private UserGroup group;

    @Override
    public String getId() {
        return id;
    }
}
