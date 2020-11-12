import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Tweet {
    private String content;
    private User poster;
    private static int messageCount = 0;
    private static int wordCount = 0;
    private static int posWordCount = 0;
    private static File file = new File("positive-words.txt");

    public Tweet(String content, User poster) throws FileNotFoundException {
        this.content = content;
        this.poster = poster;
        messageCount++;
        wordCount += countWords(content);
        posWordCount += countPosWords(content);
    }

    public String getContent() {
        return content;
    }

    public User getPoster() {
        return poster;
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
