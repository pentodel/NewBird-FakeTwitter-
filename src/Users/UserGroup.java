package Users;// Composite

import Visitor.Visitor;

import java.util.ArrayList;

public class UserGroup extends UserInterface implements Visitable {
    private String id;
    private long creationTime;
    private UserGroup parent;
    private static int groupCount = 0;

    private ArrayList<UserInterface> children = new ArrayList<UserInterface>();

    public UserGroup() {
        // Visitors only!!!
    }

    public UserGroup(String id) { // For root purposes only ?? Root should not count as group.
        this.id = id;
        parent = null;
        creationTime = System.currentTimeMillis();
    }

    public UserGroup(String id, UserGroup parent) {
        this.id = id;
        this.parent = parent;
        groupCount++;
        creationTime = System.currentTimeMillis();
    }

    public int getGroupCount() {
       return groupCount;
    }

    public long getCreationTime() { return creationTime; }

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

    @Override
    public String toString() {
        return id;
    }
}
