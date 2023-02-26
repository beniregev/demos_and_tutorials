package com.beniregev.demos_and_tutorials.examples.algorithms_and_problems.nestedloops;

public class NestedForLoopsExample {
    private int numberRows = 500;
    private int numberCols = 200;

    public void generateUniqueListOfNumbers() {
        System.out.println("generateUniqueListOfNumbers():");
        for (int r=1 ; r <= numberRows; r++) {
            for (int c=1 ; c <= numberCols ; c++ ) {
                System.out.println("row x col = " + r*c);
            }
        }
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) {
        NestedForLoopsExample example = new NestedForLoopsExample();
        example.generateUniqueListOfNumbers();

    }
}
