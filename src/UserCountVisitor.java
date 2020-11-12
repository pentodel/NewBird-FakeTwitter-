public class UserCountVisitor implements Visitor {
    @Override
    public int getCount(Visitable v) {
        User user = (User) v;
        return user.getUserCount();
    }
}
