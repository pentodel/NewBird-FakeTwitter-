// Composite

import java.util.ArrayList;

public class UserGroup extends UserInterface implements Visitable {
    private String id;
    private UserGroup parent;
    private static int groupCount = 0;

    private ArrayList<UserInterface> children = new ArrayList<UserInterface>();

    public UserGroup() {
        // Visitors only!!!
    }

    public UserGroup(String id) { // For root purposes only ?? Root should not count as group.
        this.id = id;
        parent = null;
    }

    public UserGroup(String id, UserGroup parent) {
        this.id = id;
        this.parent = parent;
        groupCount++;
    }

    public int getGroupCount() {
       return groupCount;
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

    @Override
    public int accept(Visitor v) {
        return v.getCount(this);
    }
}
