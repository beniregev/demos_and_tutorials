package com.beniregev.demos_and_tutorials.demos.java_test;

public class CheckValue {
    int val;
    CheckValue(int v) {
        val = v;
    }
    void compare(CheckValue cv) {
        System.out.println(" " + (cv.val == this.val));
    }
}

/**
 * Given the above {@code CheckValue} class, what would be the result of running the following code?
 * A) false true (Correct)
 * B) true false
 * C) false false
 * D) true true
 */
class TestValue {
    public static void main(String[] args) {
        CheckValue cv1 = new CheckValue(10);
        CheckValue cv2 = new CheckValue(10);
        System.out.print(cv1==cv2); //  false --> cv1 and cv2 have DIFFERENT addresses
        cv2.compare(cv1);           //  true --> the values are equal
    }
}