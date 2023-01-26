package com.beniregev.demos_and_tutorials.demos.java_test;

import java.util.Arrays;
import java.util.stream.DoubleStream;

/**
 * Given a list of numbers as a string (no need to validate), write a
 * function that sums all even numbers, using Java 8+ code
 * conventions.
 */
public class SumAllEvenNumbersUsingJava8 {

    public static double sumAllEvenNumbers(String[] numbers) {
        /*
            To convert array to List in Java 8:
            List<String> listNumbers = Arrays.asList(numbers);
         */
        double[] arrDouble = Arrays.stream(numbers)
                .mapToDouble(Double::parseDouble)
                .toArray();
        return DoubleStream.of(arrDouble).filter(d -> d%2 == 0).sum();
    }

    public static double sumAllEvenNumbersInOnePass(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToDouble(Double::parseDouble)
                .filter(d -> d%2 == 0)
                .sum();
    }

    public static void main(String[] args) {
        //  I can get the list of numbers using a Scanner as well with the same
        //  result, I will get a string separated by comma, comma and space, or
        //  just space and split it to get an array of strings
        String stringOfNumbers = "4.5, -1, -4, 3.5, 2, 4";
        String[] arrNumbers = stringOfNumbers.split(", ");

        System.out.println("The sum of all even numbers in two passes = " +
                sumAllEvenNumbers(arrNumbers));
        System.out.println("The sum of all even numbers in one pass = " +
                sumAllEvenNumbersInOnePass(arrNumbers));
    }
}
