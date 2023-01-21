package com.beniregev.demos_and_tutorials.demos.numbers.keeping_scores;

import java.util.Scanner;

public class Main {
    //  region Do Not Change This Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ops = sc.nextLine().split(" ");
        System.out.println(Solution.calPoints(ops));
    }
    //  endregion Do Not Change This Code
}
