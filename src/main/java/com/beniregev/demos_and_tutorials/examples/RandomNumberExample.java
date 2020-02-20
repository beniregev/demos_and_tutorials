package com.beniregev.demos_and_tutorials.examples;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class RandomNumberExample {
    private Random random = new Random();

    public static void main(String[] args) {
        RandomNumberExample example = new RandomNumberExample();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Print 10 random generated Integers: ");
        for (int i=1; i<=10; i++) {
            System.out.println("\tRandom Integer #" + i + " = " + example.generateRandomInteger());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
    }

    private int generateRandomInteger() {
        return random.nextInt();
    }

    private long generateRandomLong() {
        return 0;
    }
    private double generateRandomDouble() {
        return 0;
    }

    private int generateRandomIntegerWithinRange(int min, int max) {
        return 0;
    }

    private IntStream generateStreamOfRandomIntegers() {
        return random.ints();
    }

    private IntStream generateStreamOfRandomIntegers(long streamSize) {
        return random.ints(streamSize);
    }

    private IntStream generateStreamOfRandomIntegers(int randomNumberOrigin, int randomNumberBound) {
        return random.ints(randomNumberOrigin, randomNumberBound);
    }

    private IntStream generateStreamOfRandomIntegers(long streamSize, int randomNumberOrigin, int randomNumberBound) {
        return random.ints(streamSize, randomNumberOrigin, randomNumberBound);
    }

    private LongStream generateStreamOfRandomLongs() {
        return random.longs();
    }

    private LongStream generateStreamOfRandomLongs(long streamSize) {
        return random.longs(streamSize);
    }

    private LongStream generateStreamOfRandomLongs(long randomNumberOrigin, long randomNumberBound) {
        return random.longs(randomNumberOrigin, randomNumberBound);
    }

    private LongStream generateStreamOfRandomLongs(long streamSize, long randomNumberOrigin, long randomNumberBound) {
        return random.longs(streamSize, randomNumberOrigin, randomNumberBound);
    }

    private DoubleStream generateStreamOfRandomDoubles() {
        return random.doubles();
    }

    private DoubleStream generateStreamOfRandomDoubles(long streamSize) {
        return random.doubles(streamSize);
    }

    private DoubleStream generateStreamOfRandomDoubles(double randomNumberOrigin, double randomNumberBound) {
        return random.doubles(randomNumberOrigin, randomNumberBound);
    }

    private DoubleStream generateStreamOfRandomDoubles(long streamSize, double randomNumberOrigin, double randomNumberBound) {
        return random.doubles(streamSize, randomNumberOrigin, randomNumberBound);
    }

}
