
package programming.bootcamp;

import java.util.Scanner;

/**
 *
 * @author Eng. Mutaz Makhatreh
 */
public class NameSearchLab {
     public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1. Create String array to store 9 names
        String[] names = new String[9];

        System.out.println("Enter 9 names:");
        for (int i = 0; i < names.length; i++) {
            System.out.print("Name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }

        // 2. Ask user to enter a name to search for
        System.out.print("\nEnter a name to search for: ");
        String searchName = scanner.nextLine();

        // 3. Linear search
        int foundIndex = -1;

        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(searchName)) {
                foundIndex = i;
                break;
            }
        }

        // 4. If found, copy name and process it
        if (foundIndex != -1) {
            System.out.println("Name found at index: " + foundIndex);

            // Copy found name
            String copiedName = names[foundIndex];

            // 5. Count spaces
            int spaceCount = 0;
            for (int i = 0; i < copiedName.length(); i++) {
                if (copiedName.charAt(i) == ' ') {
                    spaceCount++;
                }
            }
            System.out.println("Number of spaces in the name: " + spaceCount);

            // 6. Replace spaces with underscore
            String updatedName = copiedName.replace(' ', '_');

            // 7. Display results
            System.out.println("Updated string length: " + updatedName.length());
            System.out.println("Updated string value: " + updatedName);

        } else {
            System.out.println("Name not found in the array.");
        }

    }
}
