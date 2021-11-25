package com.beniregev.demos_and_tutorials.examples;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * <div>
 *     <h1>Array Examples</h1>
 *     <p>
 *         <ul>
 *             <li>Use { } to Populate an Array in Java</li>
 *             <li>Use the for Loop to Populate an Array in Java</li>
 *             <li>Use the Arrays.copyOf() Method to Fill Element in a Java Array</li>
 *             <li>Use the Arrays.fill() Method to Fill Elements in a Java Array</li>
 *         </ul>
 *     </p>
 * </div>
 * @author binyamin.regev
 * @since jdk 1.8.0_162
 */
public class ArrayExamples {

    /**
     * <div>
     *     It is the basic and one of the
     *     simplest methods to populate an
     *     array. Curly Braces {} are used
     *     you define the elements of an
     *     array.
     * </div>
     */
    public void useCurlyBracketsToPopulateAnArray() {
        int[] arr = { 1, 3, 5, 7, 11 }; // Declaration of elements using { }

        System.out.println("useCurlyBracketsToPopulateAnArray: ");
        System.out.print("\t");
        for (int i : arr) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    public void useForLoopToPopulateAnArray(int numberOfElements) {
        int[] array = new int[20];
        System.out.println("\nuseForLoopToPopulateAnArray(" + numberOfElements +"): ");
        Random random = new Random();
        System.out.println("\tEnter the " + numberOfElements + " elements of the array. ");
        for(int i=0; i<numberOfElements; i++) {
            //  Receive random number from nextInt(int) method of Random class
            array[i] = random.nextInt(20)+1;
        }
        System.out.println("\tArray elements you entered are: ");
        System.out.print("\t");
        for (int i : array) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    public void useIntStreamMethodOfStreamApiToPopulateAnArray(int numberOfElements) {
        int[] array = new int[20];
        Random random = new Random();
        IntStream.range(0, numberOfElements).forEach(i -> array[i] = random.nextInt(20) + 1);
        System.out.println("\nuseIntStreamMethodOfStreamApiToPopulateAnArray(" + numberOfElements +"): ");
        System.out.print("\t");
        Arrays.stream(array, 0, numberOfElements).forEach(x -> System.out.print(x + " "));
        System.out.println();

    }
    public void UseArraysCopyOfMethodToFillElementInAnArray() {
        int[] array1 = new int[] { 8, 9, 10, 11, 12 };

        System.out.println("\nUseArraysCopyOfMethodToFillElementInAnArray: ");
        System.out.println("\tFirst array is:");
        System.out.print("\t");
        for (int i : array1) {
            System.out.print(i + "  ");
        }

        int[] array2 = Arrays.copyOf(array1, 7);
        array2[5] = 6;
        array2[6] = 7;

        System.out.println("\n\tNew array after copying elements is:");
        System.out.print("\t");
        for (int i : array2) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    public void useArraysFillMethodToFillElementsInAnArray1() {
        int[] array = { 6, 7, 8, 9, 10 };
        Arrays.fill(array, 5);  //  All array elements will be 5
        System.out.println("\nuseArraysFillMethodToFillElementsInAnArray1: ");
        System.out.println(Arrays.toString(array));
    }

    public void useArraysFillMethodToFillElementsInAnArray2() {
        int[] array = { 7, 8, 9, 10, 11 };
        // Replace elements from index 2 to index 4 by 0
        Arrays.fill(array, 2, 5, 0);
        System.out.println("\nuseArraysFillMethodToFillElementsInAnArray2: ");
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        ArrayExamples examples = new ArrayExamples();
        examples.useCurlyBracketsToPopulateAnArray();
        examples.useForLoopToPopulateAnArray(10);
        examples.useIntStreamMethodOfStreamApiToPopulateAnArray(10);
        examples.UseArraysCopyOfMethodToFillElementInAnArray();
        examples.useArraysFillMethodToFillElementsInAnArray1();
        examples.useArraysFillMethodToFillElementsInAnArray2();
    }
}
