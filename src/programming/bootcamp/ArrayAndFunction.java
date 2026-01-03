/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programming.bootcamp;

import java.util.Scanner;

/**
 *
 * @author Eng. Mutaz Makhatreh
 */
public class ArrayAndFunction {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[] array = new int[10];

        // 1. Read array elements using a function
        readArray(array, input);

        // 2. Calculate sum using a function
        int sum = calculateSum(array);

        // 3. Calculate average using a function
        double avg = calculateAverage(sum, array.length);

        // 4. Display average
        System.out.println("AVG = " + avg);

        input.close();
    }

    // Function to read array elements from the user
    public static void readArray(int[] arr, Scanner sc) {
        System.out.println("Enter " + arr.length + " integers:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    // Function to calculate the sum of array elements
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }

    // Function to calculate the average
    public static double calculateAverage(int sum, int count) {
        return (double) sum / count;
    }
}
