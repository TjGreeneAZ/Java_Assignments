
// Tara Greene
// PA 2

import java.util.Scanner;

public class FindED {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        //asking for user input
        System.out.print("Enter a line of text: ");
        String sentence = scanner.nextLine();

        // splits or tokenizes the input into words based on spaces between words
        String[] words = sentence.split(" ");

        //counts the matches found starting from the beginning
        int edFound = 0;

        //looks through each word to see it matches any of the variations and outputs the words matched
        for (String token : words) {
            if (token.endsWith("ed") || token.endsWith("ED") || token.endsWith("Ed") || token.endsWith("eD")) {
                System.out.println(token);
                edFound++;
            }
        }

        //outputs the total count of matches found
        System.out.println("Number of word that ended with ed: " + edFound );

        scanner.close();
    }
}
