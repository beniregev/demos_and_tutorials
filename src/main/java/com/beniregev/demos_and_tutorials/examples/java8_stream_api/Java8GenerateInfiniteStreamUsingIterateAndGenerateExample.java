package com.beniregev.demos_and_tutorials.examples.java8_stream_api;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Infinite streams used to generate infinite stream of data
 * 1. iterate()
 *      static (T seed, UnaryOperator<T> f)
 *      return a stream --> Stream<T>
 *
 * 2. Stream.iterate() --> stateful, it will always give you the same results
 *      Stream.iterate(initial value, next value).limit(n)
 *      OR
 *      Stream.iterate(T seed, UnaryOperator<T> f).limit(n)
 *
 * 3. generate() --> stateless, because we're using a Supplier the result is unknown
 *      static generate(Supplier<T> s)
 *      return a stream --> Stream<T>
 */
public class Java8GenerateInfiniteStreamUsingIterateAndGenerateExample {
    public static void main(String[] args) {
        //  1. iterate()
        final List<Integer> collect = IntStream.iterate(0, n -> n + 2)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println(collect);

        //  2. Stream.iterate()
        final List<Integer> collect1 = Stream.iterate(0, n -> n + 1)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(collect1);

        //  3. generate().limit(n)
        final List<Integer> collect2 = Stream.generate(() -> (new Random()).nextInt(100))
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(collect1);

    }
}
