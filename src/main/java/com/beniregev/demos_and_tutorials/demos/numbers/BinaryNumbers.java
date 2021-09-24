package com.beniregev.demos_and_tutorials.demos.numbers;

import java.util.Scanner;

/**
 * <div>
 *     Binary number is a number expressed or represented in 0 and 1.
 *     Hence binary numbers consists of 0’s and 1’s.
 * </div>
 * @author binyamin.regev
 * @since 1.8
 */
public class BinaryNumbers {
    private static int NUMBER_OF_BITS = 16;

    /**
     * <div>
     *     <div>Add two binary numbers received as arguments and return the result as {@link String}.</div>
     *     <div>The maximum number of bits in the result is NUMBER_OF_BITS.</div>
     *     <div>
     *         Using while loop to add two binary numbers bit-by-bit, right-to-left and
     *         storing the result in “summary” array of integers.
     *     </div>
     *     <div>
     *         finally, reversing back the "summary" array into a {@link StringBuilder}
     *         class and returning the result as {@link String}
     *     </div>
     * </div>
     * @param binary1 the 1st binary number to add to binary2.
     * @param binary2 the 2nd binary number to add to binary1.
     * @return the result of adding binary1 and binary2.
     */
    public String addBinaryNumbers(long binary1, long binary2) {
        //System.out.println("\tFirst binary number: " + binary1);
        //System.out.println("\tSecond binary number: " + binary2);

        //  Temporary storage variables
        int a = 0, carryOver = 0;
        // to store the result
        int[] summary = new int[NUMBER_OF_BITS];

        /* Using {@link Scanner} class to get the binary numbers from the user as input */
        //Scanner sc = new Scanner(System.in);
        //System.out.print("Please enter first binary number: ");
        //binary1 = sc.nextLong();
        //System.out.print("Please enter second binary number: ");
        //binary2 = sc.nextLong();
        //sc.close();

        while(binary1 != 0 || binary2 != 0) {
            summary[a++] = (int)((binary1 % 10 + binary2 % 10 + carryOver) % 2);
            carryOver = (int)((binary1 % 10 + binary2 % 10 + carryOver) / 2);
            binary1 = binary1 / 10;
            binary2 = binary2 / 10;
        }
        if(carryOver != 0) {
            summary[a++] = carryOver;
        }
        --a;
        StringBuilder result = new StringBuilder();
        while(a >= 0) {
            result.append(summary[a--]);
        }
        //System.out.println("\tSummary of the two binary numbers: " + result.toString());
        return result.toString();
    }

    public static void main(String[] args) {
        BinaryNumbers binaryNumbers = new BinaryNumbers();
        long binary1 = 110110L, binary2 = 100011L;
        System.out.println("{main}\t addBinaryNumbers(" + binary1 + ", "+ binary2 + ") = " +
                binaryNumbers.addBinaryNumbers(binary1, binary2));
        binary1 = 110110110L; binary2 = 100011011L;
        System.out.println("{main}\t addBinaryNumbers(" + binary1 + ", "+ binary2 + ") = " +
                binaryNumbers.addBinaryNumbers(binary1, binary2));
    }
}

/*
write a java program to add two binary numbers


Output:
Please enter first binary number: 110110
Please enter second binary number: 100011
add two binary numbers: 1011001
 */