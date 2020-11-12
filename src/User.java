// Leaf
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class User extends Subject implements Observer, Visitable {
    private String id;
    private ArrayList<User> followers;
    private ArrayList<User> followings;
    private UserGroup group;
    private ArrayList<Tweet> tweets;
    private static int userCount = 0;

    public User(String id, UserGroup group) {
        this.id = id;
        this.group = group;
        userCount++;
    }

    public User() {
        // for visitor purposes only
    }

    @Override
    public String getId() {
        return id;
    }

    public int getUserCount() {
        return userCount;
    }

    public void addToGroup(UserGroup group) {
        this.group = group;
    }

    public void sendTweet(String content) throws FileNotFoundException {
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
    public int accept(Visitor v) {
        return v.getCount(this);
    }

    @Override
    public String toString() {
        return id;
    }
}
