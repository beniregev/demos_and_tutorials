package com.beniregev.demos_and_tutorials.algorithms.recursion;

import java.io.File;
import java.util.Arrays;

/**
 *  <div>
 *  <p>
 *  Fibonacci series number.
 *  Pring Fibonacci series.
 *  Compute the Factorial of an integer.
 *  Compute the n power of 10.
 *  Print a {@link String} in the reverse order.
 *  Delete Files Larger Than 100kb.
 *  Convert a decimal integer to Binary format.
 *  Find the Greatest Common Divisor of a given integer.
 *  Calculate the first n elements of an arithmetic series (sigma).
 *  Reverse the order of the elements in a given {@code Array} of integers.
 *  Find the highest integer in an {@code Array} of integers.
 *  Bubble Sort.
 *  Solve the Towers-of-Hanoi challenge with n disks,
 *  </p>
 *  </div>
 */
public class RecursionExamples {

    int num1 = 1, num2 = 1, num3 = 0;

    /**
     * Java program for Fibonacci number using recursion.
     * This program uses tail recursion to calculate Fibonacci number for a given number
     * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144,
     * @return Fibonacci number
     */
    public int fibonacci(int seriesItemNumber){
        if(seriesItemNumber == 1 || seriesItemNumber == 2){
            return 1;
        }

        return fibonacci(seriesItemNumber-1) + fibonacci(seriesItemNumber-2);
    }

    public void exampleFibonacci(int elementCount) {
        int count = elementCount - 2;

        System.out.print("Print first " + elementCount + " element(s) of the Fibonacci series: ");

        if (elementCount > 0) {
            if (elementCount == 1) {
                System.out.println("1");
            }
            //  printing 1st and 2nd items in the Fibonacci series: " 1 1"
            System.out.print("1 1");
            if (elementCount == 2) {
                return;
            }
        }
        //  Activate recursion, call recursive method with first 2 items of Fibonacci series
        this.printFibbonacci(1, 1, count);
        System.out.println("");
    }

    public void printFibbonacci(int num1, int num2, int count) {
        if (count > 0) {
            int num = num1 + num2;
            System.out.print(" " + num);
            num1 = num2;
            num2 = num;
            printFibbonacci(num1, num2, count - 1);
        }
    }

    /**
     * Factorial of 5 is 1 * 2 * 3 * 4 * 5 = 120
     * @param n
     * @return
     */
    public int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return(n * factorial(n-1));
        }

    }

    /**
     *
     * @param n
     * @return
     */
    public int powerOf10(int n) {
        if (n == 0) {
            return 1;
        }
        return powerOf10(n-1) * 10;
    }

    /**
     * Receive a {@link String} and return it reversing the order of the characters. <br/>
     * For example: "Hello World" --> "dlroW olleH"
     * @param myString The {@code String} to reverse.
     * @return The reversed {@code String}.
     */
    public String reverseString(final String myString) {
        if ((myString == null) || (myString.length() == 1)) {
            return myString;
        }
        return reverseString(myString.substring(1)) + myString.charAt(0);
    }

    public void deleteFilesLargerThan100kb(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory()) {
            File[] subdirectories = fileOrDirectory.listFiles();
            for (File file : subdirectories) {
                deleteFilesLargerThan100kb(file);
            }

        } else {
            double fileSizeKB = fileOrDirectory.length() / 1024;
            int lastIndex = fileOrDirectory.getName().lastIndexOf(".");
            String fileExt = null;
            if (lastIndex > 0) {
                fileExt = fileOrDirectory.getName().substring(lastIndex + 1);
            }
            if ((fileSizeKB > 100.0) && (fileExt.equalsIgnoreCase("docx"))) {
                //fileOrDirectory.delete();
                System.out.println("Delete \"" + fileOrDirectory.getAbsolutePath() + "\" --> \"" + fileOrDirectory.getName() + "\"");
            }
        }
    }

    /**
     * Converting from <i>Decimal</i> to <i>Binary</i>.
     * 69 = 1000101 (1 + 4 + 64)
     * 1969 = 11110110001 (1 + 16 + 32 + 128 +256 + 512 + 1024)
     * @param n
     * @return
     */
    public String toBinary(int n) {
        if (n <= 1 ) {
            return String.valueOf(n);
        }
        return toBinary(n / 2) + String.valueOf(n % 2);
    }

    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    public int  greatestCommonDivisor(int num1, int num2) {
        if (num2 == 0) return num1;
        else return greatestCommonDivisor(num2, num1 % num2);
    }

    /**
     * Calculation of an arithmetic series (sigma) recursive Sum
     * @param n
     * @return
     */
    public int sigma( int n) {
        if(n <= 1) {
            return n;
        } else {
            return n + sigma(n-1);
        }
    }

    /**
     *
     * @param arr
     * @param length
     * @return
     */
    public int[ ] reverseArray(int[ ] arr, int length) {
        if(length <= arr.length / 2 ) {
            return arr;
        } else {
            // swapping the values
            int tempVal = arr[length - 1];
            arr[length - 1] = arr[arr.length - length];
            arr[arr.length - length] = tempVal;
        }
        return reverseArray(arr, length - 1);
    }

    /**
     * Print an {@code Array} recursively.
     * @param arr The array to pring
     * @param index The array index to print
     */
    public void printArray(int[] arr, int index) {
        System.out.print(arr[index]);
        if (index < arr.length - 1 ) {
            System.out.print(", ");
            printArray(arr, index+1);
        } else {
            System.out.println();
        }
    }

    /**
     * Find max number in an {@code Array} recursively.
     * @param array
     * @param length
     * @return
     */
    public int findMaxNumberInArray(int array[], int length) {
        if (length == 1)
            return array[0]; // base case
        int result = findMaxNumberInArray(array, length - 1);
        if (array[length - 1] > result)
            return array[length - 1];
        else
            return result;
    }

    /**
     * Bubble Sort Recursively
     * @param arr
     * @param n
     * @return
     */
    public int[] sortBubble(int arr[ ], int n) {
        if(n < 2)
            return arr;
        for(int i = 0; i < n-1; i++) {
            if(arr[i] > arr[i + 1]) {
                int t = arr[ i ];
                arr[i] = arr[i + 1];
                arr[i + 1] = t;
            }
        }
        return sortBubble(arr,n-1);
    }

    /**
     *
     * -------------------------------------------------
     * Towers Of Hanoi - 3 disks
     * Move disk from a to b
     * Move disk from a to c
     * Move disk from b to c
     * Move disk from a to b
     * Move disk from c to a
     * Move disk from c to b
     * Move disk from a to b
     * -------------------------------------------------
     * @param x Number of disks
     * @param from The <b>peg</b> from which to take the disk
     * @param to The <b>peg</b> to which to put the disk
     * @param aux The Auxelary <b>peg</b>
     */
    public void towersOfHanoi(int x, char from, char to, char aux) {
        if (x == 1) {
            System.out.println("Move disk from " + from + " to " + to);
        } else {
            towersOfHanoi(x - 1, from, aux, to);
            System.out.println( "Move disk from " + from + " to " + to);
            towersOfHanoi(x - 1,aux,to,from);
        }
    }

    /**
     * Run all the Recursive examples in this class.
     * @param args
     */
    public static void main(String[] args) {
        RecursionExamples recursions = new RecursionExamples();

        String stringExample = "321benny1969";
        String stringReverse = recursions.reverseString(stringExample);
        System.out.println("Reversing a string using recursion, for example: The reverse string of \"" + stringExample + "\" is \"" + stringReverse + "\"");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");

        int seriesItemNumber = 12;
        int factorial = 5;
        int power = 5;
        int decimal = 69;
        int number1 = 40;
        int number2 = 500;
        int sigmaTo = 5;
        int disksNum = 3;
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("Finding n-th Element of Fibonacci Sequence: The " + seriesItemNumber + " Fibonacci series element is "  + recursions.fibonacci(seriesItemNumber));
        recursions.exampleFibonacci(20);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Factorial of " + factorial + " is: " + recursions.factorial(factorial));
        System.out.println("10 power by " + power + " is " + recursions.powerOf10(power));
        System.out.println("Binary number of " + decimal + " is " + recursions.toBinary(decimal) + " and " + (decimal+1900) + " is " + recursions.toBinary(decimal+1900));
        System.out.println("The Greatest Common Divisor  of " + number1 + " and " + number2 + " is " + recursions.greatestCommonDivisor(number1, number2) );
        System.out.println("The sum of arithmetic series from 1 to " + sigmaTo + " (sigma) is " + recursions.sigma(sigmaTo));
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Array \"" + Arrays.toString(arr) + "\" in reverse is \"" + Arrays.toString(recursions.reverseArray(arr, arr.length))+ "\"");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Towers Of Hanoi - " + disksNum + " disks");
        recursions.towersOfHanoi(disksNum, 'a', 'b', 'c');
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");

    }
}
