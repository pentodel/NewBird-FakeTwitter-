import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PosTweets implements Visitable {
    private static int posTweets = 0;
    private static int tweetCount = 0;
    private static File file = new File("positive-words.txt");
    private static PosTweets instance = new PosTweets();

    private PosTweets(){}

    public static PosTweets getInstance() {
        return instance;
    }

    public void add(String m) throws FileNotFoundException {
        tweetCount++;
        if (isPos(m)) posTweets++;
    }

    public int posProportion() {
        if (tweetCount == 0) return 0;
        return (posTweets * 100) / tweetCount;
    }


    private boolean isPos(String msg) throws FileNotFoundException {
        int posWords = 0;
        msg.replaceAll("\\p{Punct}", "");

        StringTokenizer st = new StringTokenizer(msg);
        while(st.hasMoreTokens()) {
            if (dictContains(st.nextToken().toLowerCase())) {
                return true;
            }
        }
        return false;
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

    @Override
    public int accept(Visitor v) {
        return v.getCount(this);
    }
}
