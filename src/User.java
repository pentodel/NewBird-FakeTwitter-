// Leaf
import java.util.ArrayList;

public class User extends Subject implements Observer, Visitable {
    private String id;
    private ArrayList<User> followers;
    private ArrayList<User> followings;
    private UserGroup group;
    private ArrayList<Tweet> tweets;
    private static int usercount = 0;

    public User(String id, UserGroup group) {
        this.id = id;
        this.group = group;
        usercount++;
    }

    @Override
    public String getId() {
        return id;
    }

    public void addToGroup(UserGroup group) {
        this.group = group;
    }

    public void sendTweet(String content) {
        Tweet newTweet = new Tweet(content, this);
        tweets.add(newTweet);

        // pretty sure stuff goes here
    }

    public void followUser(User user) {
        followings.add(user);
    }

    public void addFollower(User user) {
        followers.add(user);
    }

    @Override
    public void accept(Visitor v) {

    }
}
