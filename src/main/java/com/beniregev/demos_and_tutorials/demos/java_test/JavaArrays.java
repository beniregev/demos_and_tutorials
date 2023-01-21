package com.beniregev.demos_and_tutorials.demos.java_test;

/**
 * Which statement is true with respect to the given code segment?
 * A) It will print "0" twenty times
 * B) It will generate an error because the array declaration is not correct in <i>Line A</i>.
 * C) [CORRECT] It will generate an error because the static reference to the non-static field <i>size</i> is not valid.
 * D) It will print {@code null} twenty times.
 */
public class JavaArrays {
    static int i;
//    int size = 20; // original code
    static int size = 20;

    public static void main(String[] args) {
        int[] arr = new int[size]; //   Line A
        /* Original code was: variable "i" is already defined in the scope
        for (int i = 0; i < size; i++) {
            System.out.println(arr[j]);
        }
        */
        for (int j = 0; j < size; j++) {
            System.out.println(arr[j]);
        }
    }
}
