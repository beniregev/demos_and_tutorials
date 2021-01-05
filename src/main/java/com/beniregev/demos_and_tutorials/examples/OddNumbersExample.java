package com.beniregev.demos_and_tutorials.examples;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExample {
    public List<Integer> oddNumber(int l, int r) {
        List<Integer> arr = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (i % 2 != 0 && !arr.contains(i)) {
                arr.add(i);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        OddNumbersExample example = new OddNumbersExample();
        List<Integer> arr = example.oddNumber(2, 11);
        for (Integer i : arr) {
            System.out.println("odd Number: " + i);
        }
    }
}
