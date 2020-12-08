package Users;// Leaf

import Tweets.Tweet;
import Visitor.Visitor;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class User extends Subject implements Observer, Visitable {
    private String id;
    private long creationTime = System.currentTimeMillis();
    private long lastPostTime = 0;
    private long lastUpdateTime = System.currentTimeMillis();
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

    public long getCreationTime() { return creationTime; }

    public long getLastUpdateTime() { return lastUpdateTime; }

    public long getLastPostTime() { return lastPostTime; }

    public int followerCount() {
        return followers.size();
    }

    public int followingCount() {
        return followings.size();
    }

    public void addToGroup(UserGroup group) {
        this.group = group;
    }

    public void updateLastUpdateTime() {
        lastUpdateTime = System.currentTimeMillis();
    }

    public void updateLastPostTime() {
        lastPostTime = System.currentTimeMillis();
    }

    public void sendTweet(String content) {
        Tweet newTweet = new Tweet(content, this);
        tweets.add(newTweet);
        pushTweet(newTweet);
        updateLastPostTime();
    }

    public boolean followUser(User user) {
        if (followings.contains(user)) {
            JOptionPane.showMessageDialog(null, "You are already following this user!");
            return false;
        }
        followings.add(user);
        pushFollow(user);
        return true;
    }

    public void addFollower(User user) {
        followers.add(user);
        attach(user);
    }

    public void receiveTweet(Tweet t) {
        tweetFeed.add(t);
    }

    public String followingsInText() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        if (followings.size() == 0) return "";
        String result = "";
        result += followings.get(0).getId() + " (Last Post: ";
        result += (followings.get(0).getLastPostTime() != 0) ? sdf.format(followings.get(0).getLastPostTime()) : "Never";
        result += ")";
        for (int i = 1; i < followings.size(); i++) {
            result += ", ";

            result += followings.get(i).getId() + " (Last Post: ";
            result += (followings.get(i).getLastPostTime() != 0) ? sdf.format(followings.get(i).getLastPostTime()) : "Never";
            result += ")";
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
