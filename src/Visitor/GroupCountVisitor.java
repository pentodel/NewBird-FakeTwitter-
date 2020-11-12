package Visitor;

import Users.UserGroup;
import Users.Visitable;

public class GroupCountVisitor implements Visitor {
    @Override
    public int getCount(Visitable v) {
        UserGroup group = (UserGroup) v;
        return group.getGroupCount();
    }
}
