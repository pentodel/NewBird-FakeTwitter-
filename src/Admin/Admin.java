package Admin;
import Users.*;

import javax.swing.*;
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
    private ArrayList<UserGroup> allGroups = new ArrayList<UserGroup>();

    public User createUser(String id, UserGroup group) {
        // For A3#1
        // I already had ID validation, with the exception of the no-space requirement
        // So I simply added the no-space requirement

        if (id.contains(" ")) {
            JOptionPane.showMessageDialog(null, "User Name cannot contain a space.");
            return null;
        }
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getId().equals(id)) {
                JOptionPane.showMessageDialog(null, "User Name already taken.");
                return null;
            }
        }

        User newUser = new User(id, group);
        group.addChild(newUser);
        allUsers.add(newUser);
        return newUser;
    }

    public UserGroup createGroup(String id, UserGroup parent) {
        for (int i = 0; i < allGroups.size(); i++) {
            if (allGroups.get(i).getId().equals(id)) {
                JOptionPane.showMessageDialog(null, "Group Name already taken.");
                return null;
            }
        }

        UserGroup newGroup = new UserGroup(id, parent);
        parent.addChild(newGroup);
        allGroups.add(newGroup);
        return newGroup;
    }

    public void addTweet(String msg, User user) {
        user.sendTweet(msg);
    }

    public boolean followUser(User follower, User followee) {
        return follower.followUser(followee);
    }

    public User findUser(String id) {
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getId().equals(id)) {
                return allUsers.get(i);
            }
        }
        return null;
    }

    public ArrayList<User> findUsersWithLatestActivity() {
        ArrayList<User> results = new ArrayList<User>();
        long latestUpdate = 0;

        for (User user : allUsers) {
            if (user.getLastUpdateTime() > latestUpdate) {
                latestUpdate = user.getLastUpdateTime();
            }
        }
        for (User user : allUsers) {
            if (user.getLastUpdateTime() == latestUpdate) {
                results.add(user);
            }
        }

        return results;
    }

    public ArrayList<User> findUsersWithLatestPosts() {
        ArrayList<User> results = new ArrayList<User>();
        long latestPost = 0;

        for (User user : allUsers) {
            if (user.getLastPostTime() > latestPost) {
                latestPost = user.getLastPostTime();
            }
        }
        if (latestPost == 0) return results;
        for (User user : allUsers) {
            if (user.getLastPostTime() == latestPost) {
                results.add(user);
            }
        }

        return results;
    }

}
