package com.beniregev.demos_and_tutorials.java8_functional_interface;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * Java 8 BiConsumer function interface represents an operation with two arguments and returns
 * no result.
 * Syntax - {@code accept(T t, U u);}
 *
 * <h1>Java 8 Functional Interface – BiConsumer Example</h1>
 * <p>In this tutorial, we will explain the BiConsumer functional interface introduced in java 8.
 * </p>
 * <h2>1. Introduction</h2>
 * <p>
 * Before diving deep into the practice stuff let us understand the {@link BiConsumer} functional
 * interface in Java 8 programming.
 * <p>
 *     <ul>
 *         <li>
 *             <code>void accept(T t, U u)</code> - It is an abstract method that accepts two input
 *             arguments, prints the operation based on the given input, and returns no result.
 *         </li>
 *         <li>
 *             <code>BiConsumer andThen(BiConsumer after)</code> - It is a {@code default} method
 *             in the functional interface that runs on two BiConsumer code one after another on
 *             the same input.
 *         </li>
 *     </ul>
 * </p>
 * </p>
 * <h2>2. Practice</h2>
 * <p>
 *     Let us dive into some practice stuff from here and I am assuming that you already have the
 *     Java 1.8 or greater installed in your local machine. I am using
 *     <a href="https://www.jetbrains.com/idea/" target="_blank" rel="noopener">JetBrains IntelliJ IDEA</a>
 *     as my preferred IDE. You’re free to choose the IDE of your choice.
 * </p>
 * <h3>2.1 Understanding BiConsumer interface</h3>
 * <p>
 *     Create a java file in the
 *     <code>com.beniregev.demos_and_tutorials.java8_functional_interface</code>
 *     package and add the following code to it.
 * </p>
 * <p>
 *     <span style="text-decoration: underline;"><em>BiConsumerDemo.java</em></span>
 * </p>
 * <p>
 *     Run the file and if everything goes well the following output will be logged
 *     in the IDE console.
 * </p>
 * <h2 id="h-3-summary">3. Summary</h2>
 * <p>
 *     In this tutorial, we learned the <code>BiConsumer</code> functional interface introduced in
 *     Java 8 programming along with the implementation. The functional interface consists of two
 *     methods that are widely used with the collection api.
 * </p>
 *
 */
public class BiConsumerDemo {
    // example method 1
    private static void basic() {
        // BiConsumer lambda expression
        final BiConsumer<String, String> concat =
                (val1, val2) -> System.out.println(val1+" "+val2);

        concat.accept("Hello", "world!");
    }

    // example method 2
    private static void printMap() {
        final Map<Integer, String> map = new HashMap<>();
        map.put(1, "Car");
        map.put(2, "Ship");
        map.put(3, "Bike");
        map.put(4, "Trolley");
        map.put(5, "Airplane");

        // BiConsumer lambda expression
        // print the key and value for a map
        final BiConsumer<Integer, String> print =
                (val1, val2) -> System.out.println(val1+" "+val2);

        // using forEach() as it can accept the BiConsumer lambda expression
        map.forEach(print);
    }

    // example method 3
    private static void andThen() {
        // BiConsumer lambda expression
        final BiConsumer<Integer, Integer> addition =
                (val1, val2) -> System.out.println("Sum of input is= "+(val1 + val2));

        final BiConsumer<Integer, Integer> subtraction =
                (val1, val2) -> System.out.println("Subtraction of input is= "+(val1 - val2));

        // using andThen()
        // run the 2 logic one after another on the same input
        // if passing null to andThen() method it will throw NullPointerException
        addition.andThen(subtraction).accept(10, 5);
    }

    // driver method
    public static void main(String[] args) {
        System.out.println("----- BiConsumer functional interface example -----\n");
        basic();
        System.out.println("\n");
        printMap();
        System.out.println("\n");
        andThen();
    }
}
