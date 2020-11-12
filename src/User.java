// Leaf
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class User extends Subject implements Observer, Visitable {
    private String id;
    private ArrayList<User> followers = new ArrayList<User>();
    private ArrayList<User> followings = new ArrayList<User>();
    private UserGroup group;
    private ArrayList<Tweet> tweets;
    private ArrayList<Tweet> tweetFeed = new ArrayList<Tweet>();
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
        pushTweet(newTweet);
    }

    public void followUser(User user) {
        followings.add(user);
        attach(user);
        pushFollow(user);
    }

    public void addFollower(User user) {
        followers.add(user);
    }

    public void receiveTweet(Tweet t) {
        tweetFeed.add(t);
    }

    public String followersInText() {
        if (followers.size() == 0) return "";
        String result = "";
        result += followers.get(0).getId();
        for (int i = 1; i < followers.size(); i++) {
            result += ", ";
            result += followers.get(i).getId();
        }
        return result;
    }

    public String tweetFeedInText() {
        if (tweetFeed.size() == 0) return "";
        String result = "";
        for (int i = 0; i < tweetFeed.size(); i++) {
            result += tweetFeed.get(i).toString();
        }
        return result;
    }

    @Override
    public int accept(Visitor v) {
        return v.getCount(this);
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public void pushTweet(Tweet t) {
        notifyObserversTweet(t);
    }

    @Override
    public void pushFollow(User u) {
        notifyObserverFollow(u);
    }
}
