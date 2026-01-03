package programming.bootcamp;

/**
 *
 * @author Eng. Mutaz Makhatreh
 */
public class DataTypesLab {

    public static void main(String[] args) {

        // 1. byte
        byte byteValue = 100;

        // 2. short
        short shortValue = 32000;

        // 3. int
        int intValue = 100000;

        // 4. long
        long longValue = 1000000000L;

        // 5. float
        float floatValue = 10.5f;

        // 6. double
        double doubleValue = 99.99;

        // 7. char
        char charValue = 'A';

        // 8. boolean
        boolean booleanValue = true;

        // 9. String
        String stringValue = "Java Data Types Lab";

        // 10. Integer (Wrapper class)
        Integer integerWrapper = 500;

        // 11. Double (Wrapper class)
        Double doubleWrapper = 45.67;

        // 12. int[] (Array)
        int[] intArray = {10, 20, 30, 40, 50};

        // Display values
        System.out.println("byte value: " + byteValue);
        System.out.println("short value: " + shortValue);
        System.out.println("int value: " + intValue);
        System.out.println("long value: " + longValue);
        System.out.println("float value: " + floatValue);
        System.out.println("double value: " + doubleValue);
        System.out.println("char value: " + charValue);
        System.out.println("boolean value: " + booleanValue);
        System.out.println("String value: " + stringValue);
        System.out.println("Integer wrapper value: " + integerWrapper);
        System.out.println("Double wrapper value: " + doubleWrapper);

        System.out.println("Array values:");
        for (int num : intArray) {
            System.out.println(num);
        }
    }
}
