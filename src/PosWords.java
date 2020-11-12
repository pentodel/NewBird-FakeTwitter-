import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PosWords {
    private static int posWords = 0;
    private static int wordCount = 0;
    private static File file = new File("positive-words.txt");
    private static PosWords instance = new PosWords();

    private PosWords(){}

    public static PosWords getInstance() {
        return instance;
    }

    public void add(String m) throws FileNotFoundException {
        wordCount += countWords(m);
        posWords += countPosWords(m);
    }

    public int posProportion() {
        return (posWords * 100) / wordCount;
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
