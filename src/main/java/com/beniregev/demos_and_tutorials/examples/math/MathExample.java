package com.beniregev.demos_and_tutorials.examples.math;



public class MathExample {
    private void floorOrCeiling() {
        System.out.println("floorOrCeiling():");
        double value = 9.0;
        double sqrt = Math.sqrt(value);
        System.out.println("Square Root of " + value + " = " + sqrt);
        System.out.println("Floor of " + value + " = " + Math.floor(sqrt));
        System.out.println("Ceiling of " + value + " = " + Math.ceil(sqrt));
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        MathExample example = new MathExample();
        example.floorOrCeiling();
    }
}
