package Tweets;

import Users.User;
import Users.Visitable;
import Visitor.Visitor;

public class Tweet implements Visitable {
    private String content;
    private User poster;
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
        // Visitor.Visitor purposes only.
    }

    @Override
    public String toString() {
        return poster.getId() + ":\n" + content + "\n\n";
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
