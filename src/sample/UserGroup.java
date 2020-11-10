// Composite

package sample;

import java.util.ArrayList;

public class UserGroup implements UserInterface {
    private String id;
    private UserGroup parent;
    private ArrayList<UserInterface> children = new ArrayList<UserInterface>();


    @Override
    public String getId() {
        return id;
    }
}
