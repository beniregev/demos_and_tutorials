package com.beniregev.demos_and_tutorials.examples;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * <p>
 *     <h1>Random class in Java</h1>
 *     <div>
 *         An instance of {@link Random} class is used to generate a
 *         stream of pseudorandom numbers. Instances of {@code java.util.Random}
 *         are not cryptographically secure.
 *     </div>
 *     <div>
 *         Instances of {@code java.util.Random} are threadsafe. However,
 *         the concurrent use of the same {@code java.util.Random} instance
 *         across threads may encounter contention and consequent poor
 *         performance.
 *     </div>
 * </p>
 * <p>
 *     <h3>Random class declaration</h3>
 *     <div>public class Random extends Object implements Serializable</div>
 * </p>
 * <p>
 *     <h3>Random class constructors</h3>
 *     <ul>
 *         <li>{@code public Random()} — creates a new random number generator.</li>
 *         <li>{@code public Random(long seed)} — creates a new random number generator using a single long seed.</li>
 *     </ul>
 * </p>
 * <p>
 *     <h3>Random class methods</h3>
 *     <ul>
 *         <li>{@code doubles()} — returns an effectively unlimited stream of pseudorandom double values, each between zero (inclusive) and one (exclusive).</li>
 *         <li>{@code ints()} — returns an effectively unlimited stream of pseudorandom int values.</li>
 *         <li>{@code longs()} — returns an effectively unlimited stream of pseudorandom long values.</li>
 *         <li>{@code next(int bits)} — generates the next pseudorandom number.</li>
 *         <li>{@code nextBoolean()} — returns the next pseudorandom, uniformly distributed boolean value from this random number generator’s sequence.</li>
 *         <li>{@code nextBytes(byte[] bytes)} — generates random bytes and places them into a user-supplied byte array.</li>
 *         <li>{@code nextDouble()} — returns the next pseudorandom, uniformly distributed double value between 0.0 and 1.0 from this random number generator’s sequence.</li>
 *         <li>{@code nextFloat()} — returns the next pseudorandom, uniformly distributed float value between 0.0 and 1.0 from this random number generator’s sequence.</li>
 *         <li>{@code nextGaussian()} — returns the next pseudorandom, Gaussian (“normally”) distributed double value with mean 0.0 and standard deviation 1.0 from this random number generator’s sequence.</li>
 *         <li>{@code nextInt()} — returns the next pseudorandom, uniformly distributed int value from this random number generator’s sequence.</li>
 *         <li>{@code nextInt(int bound)} — Returns a pseudorandom, uniformly distributed int value between 0 (inclusive) and the specified value (exclusive), drawn from this random number generator’s sequence.</li>
 *         <li>{@code nextLong()} — returns the next pseudorandom, uniformly distributed long value from this random number generator’s sequence.</li>
 *         <li>{@code setSeed(long seed)} — Sets the seed of this random number generator using a single long seed.</li>
 *     </ul>
 * </p>
 */
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

    /**
     *
     * <p>
     *     <div>
     *         <h5>Example output for the code in this method: </h5>
     *         <code>
     * 6
     * true
     * 0.2805854768046321
     * 0.13993335
     * 0.32107779397797304
     * [-114 29 112 38 -67 -67 81 -58 -18 51 ]
     * 9211389898189124398
     * -1318125037
     *         </code>
     *     </div>
     * </p>
     */
    public void getNextXxxxxMethodsExample() {
        System.out.println(getRandom().nextInt(10));
        System.out.println(getRandom().nextBoolean());
        System.out.println(getRandom().nextDouble());
        System.out.println(getRandom().nextFloat());
        System.out.println(getRandom().nextGaussian());
        byte[] bytes = new byte[10];
        getRandom().nextBytes(bytes);
        System.out.printf("[");
        for(int a = 0; a < bytes.length; a++) {
            System.out.printf("%d ", bytes[a]);
        }
        System.out.printf("]\n");
        System.out.println(getRandom().nextLong());
        System.out.println(getRandom().nextInt());
        long seed = 55;
        getRandom().setSeed(seed);
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

    public Random getRandom() {
        return random;
    }

}
