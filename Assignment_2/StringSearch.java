// Tara Greene
//PA 2

import java.util.Scanner;

public class StringSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String text = scanner.nextLine().toUpperCase();

        //starts an array to store the alphabet count
        int[] letterCounter = new int[26];

        //loop for the whole alphabet
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            int count = 0; //starts the count
            //using indexOf to find each occurrence of the letter in the text, looping till the letter isn't found, going through whole alphabet
            for (int startSearch = text.indexOf(letter); startSearch != -1; startSearch = text.indexOf(letter, startSearch + 1)) {
                count++; //adds the to the count total each time one is found
            }
            letterCounter[letter - 'A'] = count; //stores the count of the current letter the loop is going through
        }

        //displays the length of the text string
        System.out.println("Length of the text String: " + text.length());
        System.out.printf("%nCharacters\tOccurrences%n");

        //for-loop for the alphabet to display them and the amount of times they appear
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            System.out.printf("%c\t\t%d%n", letter, letterCounter[letter - 'A']);
        }

        scanner.close();
    }
}



