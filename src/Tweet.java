import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Tweet implements Visitable {
    private String content;
    private User poster;
    private static int messageCount = 0;
    private static int wordCount = 0;
    private static PosTweets posInst = PosTweets.getInstance();


    public Tweet(String content, User poster) throws FileNotFoundException {
        this.content = content;
        this.poster = poster;
        messageCount++;
        posInst.add(content);
    }

    public Tweet() {
        // Visitor purposes only.
    }

    public String getContent() {
        return content;
    }

    public User getPoster() {
        return poster;
    }

    public int getMessageCount() {
        return messageCount;
    }

    @Override
    public int accept(Visitor v) {
        return v.getCount(this);
    }
}
