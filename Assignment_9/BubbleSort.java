// Tara Greene
// PA9

import java.security.SecureRandom;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        // Using random generator to assemble a 20 count array of numbers between 1 and 200
        SecureRandom generator = new SecureRandom();
        int[] data = generator.ints(20, 1, 201).toArray();

        // Print out the unsorted array
        System.out.print("Unsorted Array: ");
       System.out.println(Arrays.toString(data));

        // Bubble Sort algorithm
        // boolean to start the loop
        boolean swappingIndexes = true;

        while (swappingIndexes) {
            swappingIndexes = false;
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i] > data[i + 1]) {
                    swappingIndexes = true;
                    // swaps to variables/int in the array
                    int temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                }
            }
        }

        // Print sorted array
        System.out.print("Sorted Array: ");
        System.out.print(Arrays.toString(data));

    }
}
