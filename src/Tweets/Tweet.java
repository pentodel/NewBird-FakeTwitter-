package Tweets;

import Users.User;
import Users.Visitable;
import Visitor.Visitor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tweet implements Visitable {
    private String content;
    private User poster;
    private long creationTime = System.currentTimeMillis(); // This was implemented for fun
    private static int messageCount = 0;
    private static int wordCount = 0;
    private static PosTweets posInst = PosTweets.getInstance();


    public Tweet(String content, User poster) {
        this.content = content;
        this.poster = poster;
        messageCount++;
        posInst.add(content);
    }

    public Tweet() {
        // Visitor purposes only.
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm");
        Date resultDate = new Date(creationTime);

        return poster.getId() + ": (Posted: " + sdf.format(resultDate) + ")\n" + content + "\n\n";
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

    public long getCreationTime() { return creationTime; }

    @Override
    public int accept(Visitor v) {
        return v.getCount(this);
    }
}
