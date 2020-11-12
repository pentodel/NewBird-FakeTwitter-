// Composite

import java.util.ArrayList;

public class UserGroup extends UserInterface {
    private String id;
    private UserGroup parent;
    private static int groupcount = 0;

    private ArrayList<UserInterface> children = new ArrayList<UserInterface>();

    public UserGroup(String id) { // For root purposes only ?? Root should not count as group.
        this.id = id;
        parent = null;
    }

    public UserGroup(String id, UserGroup parent) {
        this.id = id;
        this.parent = parent;
        groupcount++;
    }

    public void addChild(UserInterface u) {
        children.add(u);
    }

    public ArrayList<UserInterface> getChildren() {
        return children;
    }

    @Override
    public String getId() {
        return id;
    }

}
