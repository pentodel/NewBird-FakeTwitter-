// Composite

import java.util.ArrayList;

public class UserGroup implements UserInterface {
    private String id;
    private UserGroup parent;
    private ArrayList<UserInterface> children = new ArrayList<UserInterface>();

    public UserGroup(String id) {
        parent = null;
    }

    public UserGroup(String id, UserGroup parent) {
        this.parent = parent;
    }

    public void addChild(UserInterface u) {
        children.add(u);
    }

    @Override
    public String getId() {
        return id;
    }

}
