package Users;

import Tweets.Tweet;

import java.util.ArrayList;

public abstract class Subject extends UserInterface {
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detatch(Observer o) {
        observers.remove(o);
    }

    public void notifyObserversTweet(Tweet t) {
        for (Observer o : observers) {
            User user = (User) o;
            user.receiveTweet(t);
        }
    }

    public void notifyObserverFollow(User u) {
        u.addFollower((User) this);
    }
}
