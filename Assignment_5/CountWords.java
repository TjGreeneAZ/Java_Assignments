import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class CountWords {
    public static void main(String[] args) {
        String filename = "test1.txt";

        try (Scanner in = new Scanner(new File(filename))) {
            TreeSet<String> uniqueWords = new TreeSet<>();

            int numWords = 0;
            while (in.hasNext()) {
                // Clean method removed all non letters
                String word = clean(in.next());
                numWords++;
                // Add the word to the set, if it is a duplicate it will not be added
                uniqueWords.add(word);
            }

            Iterator<String> iter = uniqueWords.iterator();
            while (iter.hasNext()) {
                System.out.println(iter.next());
            }

            System.out.println("Number of words: " + numWords);
            System.out.println("Unique words: " + uniqueWords.size());
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + filename);
        }
    }


    public static String clean(String s) {
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                r += c;
            }
        }
        return r.toLowerCase();
    }
}

