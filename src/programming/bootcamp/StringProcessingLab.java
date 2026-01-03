package programming.bootcamp;

import java.util.Scanner;

/**
 *
 * @author Eng. Mutaz Makhatreh
 */
public class StringProcessingLab {
   public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1. Prompt user to enter a sentence
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // 2. Count characters excluding spaces
        int charCount = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) != ' ') {
                charCount++;
            }
        }
        System.out.println("Number of characters (excluding spaces): " + charCount);

        // 3. Identify vowels
        int vowelCount = 0;
        System.out.print("Vowels found: ");

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {

                vowelCount++;

                // Convert case
                if (Character.isLowerCase(ch)) {
                    System.out.print(Character.toUpperCase(ch) + " ");
                } else {
                    System.out.print(Character.toLowerCase(ch) + " ");
                }
            }
        }

        System.out.println("\nTotal number of vowels: " + vowelCount);

        // 4. Count occurrences of a specific character
        System.out.print("Enter a character to search for: ");
        char searchChar = scanner.next().charAt(0);

        int occurrenceCount = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == searchChar) {
                occurrenceCount++;
            }
        }

        System.out.println("The character '" + searchChar + "' appears "
                + occurrenceCount + " times.");

    }  
}
