// Leaf
import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class User extends Subject implements Observer, Visitable {
    private String id;
    private ArrayList<User> followers = new ArrayList<User>();
    private ArrayList<User> followings = new ArrayList<User>();
    private UserGroup group;
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
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

    public int followerCount() {
        return followers.size();
    }

    public int followingCount() {
        return followings.size();
    }

    public void addToGroup(UserGroup group) {
        this.group = group;
    }

    public void sendTweet(String content) {
        Tweet newTweet = new Tweet(content, this);
        tweets.add(newTweet);
        pushTweet(newTweet);
    }

    public void followUser(User user) {
        if (followings.contains(user)) {
            JOptionPane.showMessageDialog(null, "You are already following this user!");
            return;
        }
        followings.add(user);
        pushFollow(user);
    }

    public void addFollower(User user) {
        followers.add(user);
        attach(user);
    }

    public void receiveTweet(Tweet t) {
        tweetFeed.add(t);
    }

    public String followingsInText() {
        if (followings.size() == 0) return "";
        String result = "";
        result += followings.get(0).getId();
        for (int i = 1; i < followings.size(); i++) {
            result += ", ";
            result += followings.get(i).getId();
        }
        return result;
    }

    public String tweetFeedInText() {
        if (tweetFeed.size() == 0) return "";
        String result = "";
        for (int i = 0; i < tweetFeed.size(); i++) {
            result = tweetFeed.get(i).toString() + result;
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
