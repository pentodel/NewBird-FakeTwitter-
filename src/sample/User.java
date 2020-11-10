// Leaf

package sample;

import java.util.ArrayList;

public class User implements UserInterface {
    private String id;
    private ArrayList<User> followers;
    private ArrayList<User> followings;
    private UserGroup group;
    private ArrayList<Tweet> tweets;

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
}
