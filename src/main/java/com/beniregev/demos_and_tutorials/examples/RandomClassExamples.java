package com.beniregev.demos_and_tutorials.examples;

import java.util.Random;

public class RandomClassExamples {
    private Random random = new Random();

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
     * <p>
     *     <div>
     *         <h5>Output: (for example)</h5>
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

    public static void main(String[] args) {
        RandomClassExamples examples = new RandomClassExamples();
        examples.getNextXxxxxMethodsExample();
    }

    public Random getRandom() {
        return random;
    }
}
