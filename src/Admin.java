
import java.util.ArrayList;

public class Admin {
    // Eager instantiation
    // Since an instance of this class must necessarily be created when the program is run
    // it is fine just to create the instance of it right off the bat.
    private static Admin instance = new Admin();

    private Admin(){}

    public static Admin getInstance() {
        return instance;
    }

    private UserGroup rootList = new UserGroup("Root");
    private ArrayList<User> allUsers = new ArrayList<User>();

    public void createUser(String id, UserGroup group) {
        // Presumably, group is selected and then passed on into here
        // Who knows how lol. Not me.
        User newUser = new User(id, group);
        group.addChild(newUser);
        allUsers.add(newUser);
    }

    public void createGroup(String id, UserGroup parent) {
        // Presumably, group is selected and then passed on into here
        // Who knows how lol. Not me.
        User newUser = new User(id, parent);
        parent.addChild(newUser);
    }

    public void addTweet(String msg, User user) {
        user.sendTweet(msg);
    }

    public void followUser(User follower, User followee) {
        follower.followUser(followee);
        followee.addFollower(follower);
    }


}
