import java.util.ArrayList;

public interface Observer {
    public void pushTweet(Tweet t);
    public void pushFollow(User u);
}
