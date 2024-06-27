// Tara Greene
// PA 10

/*
 21.10 (Printing a Sentence in Reverse Using a Stack)
 Write a program that inputs a line of text and uses a stack to display
 the words of the line in reverse order.

 Name the class StringStack. You must use the pop method to remove and display the stack of words in reverse order.
 You can not use the stack print method.
 You must download and add the following .jar file to your classpath: com.deitel.datastructures.jar
 */

import java.util.Scanner;
import com.deitel.datastructures.Stack;

public class StringStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a string:");
        String sentence = scanner.nextLine();

        // Initialize a Stack to hold String type elements
        Stack<String> wordStack = new Stack<>();
        // Split the input sentence into words based on spaces
        String[] words = sentence.split(" ");

        // Push each word from the sentence into the Stack
        for (String word : words) {
            wordStack.push(word);
        }

        scanner.close();

        // Pop words from the stack to print them in reverse order
        System.out.println("Input string in reverse order:");
        while (!wordStack.isEmpty()) {
            String word = wordStack.pop();
            System.out.printf("%s ", word);
        }
    }
}

