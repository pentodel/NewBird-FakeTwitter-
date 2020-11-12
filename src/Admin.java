
import java.io.FileNotFoundException;
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

    public User createUser(String id, UserGroup group) {
        // Presumably, group is selected and then passed on into here
        // Who knows how lol. Not me.
        User newUser = new User(id, group);
        group.addChild(newUser);
        allUsers.add(newUser);
        return newUser;
    }

    public UserGroup createGroup(String id, UserGroup parent) {
        // Presumably, group is selected and then passed on into here
        // Who knows how lol. Not me.
        UserGroup newGroup = new UserGroup(id, parent);
        parent.addChild(newGroup);
        return newGroup;
    }

    public void addTweet(String msg, User user) throws FileNotFoundException {
        user.sendTweet(msg);
    }

    public void followUser(User follower, User followee) {
        follower.followUser(followee);
        followee.addFollower(follower);
    }


}
