package Visitor;

import Tweets.Tweet;
import Users.Visitable;

public class TweetCountVisitor implements Visitor {
    @Override
    public int getCount(Visitable v) {
        Tweet tweet = (Tweet) v;
        return tweet.getMessageCount();
    }
}
