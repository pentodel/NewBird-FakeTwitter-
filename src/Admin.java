import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Admin {
    // Eager instantiation
    // Since an instance of this class must necessarily be created when the program is run
    // it is fine just to create the instance of it right off the bat.
    private static Admin instance = new Admin();

    private Admin(){}

    public static Admin getInstance() {
        return instance;
    }

    private int userCount = 0;
    private int messageCount = 0;
    private int groupCount = 0;
    private int positiveWords = 0;
    private int allWords = 0;
    File file = new File("positive-words.txt");

    private UserGroup rootList = new UserGroup("Root");

    public void createUser(String id, UserGroup group) {
        // Presumably, group is selected and then passed on into here
        // Who knows how lol. Not me.
        User newUser = new User(id, group);
        group.addChild(newUser);
        userCount++;
    }

    public void addTweet(String msg, User user) throws FileNotFoundException {
        user.sendTweet(msg);
        messageCount++;
        allWords += countWords(msg);
        positiveWords += countPosWords(msg);
    }

    public void followUser(User follower, User followee) {
        follower.followUser(followee);
        followee.addFollower(follower);
    }





    private int countWords(String msg) {
        return msg.replaceAll("[^ ]", "").length();
    }

    private int countPosWords(String msg) throws FileNotFoundException {
        int posWords = 0;
        msg.replaceAll("\\p{Punct}", "");


        StringTokenizer st = new StringTokenizer(msg);
        while(st.hasMoreTokens()) {
            if (dictContains(st.nextToken().toLowerCase())) {
                posWords++;
            }
        }
        return posWords;
    }

    private boolean dictContains(String s) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            if (scanner.nextLine().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
