package Users;

import Tweets.Tweet;

public interface Observer {
    public void pushTweet(Tweet t);
    public void pushFollow(User u);
}
