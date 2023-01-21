package com.beniregev.demos_and_tutorials.examples.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <div></div>
 * @author binyamin.regev
 * @since sdk-1.8.0_162
 */
public class MapExamples1 {
    /**
     * Java 8 initialize Map examples
     */
    public void initializeMapExample() {
        Map<String, String> myMap1 = Stream.of(new String[][]{
                {"USA", "Washington"},
                {"United Kingdom", "London"},
                {"India", "New Delhi"}
        }).collect(Collectors.toMap(p -> p[0], p -> p[1]));

        Map<String, String> myMap2 = new HashMap<String, String>() {{
            put("key1", "value1");
            put("key2", "value2");
            put("key3", "value3");
        }};
        myMap1.forEach((k,v) -> System.out.println("k=" + k + ", v=" + v));
        System.out.println("-------------------------------------------------");

        myMap2.forEach((k,v) -> System.out.println("key=" + k + "; value=" + v));
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) {
        MapExamples1 example = new MapExamples1();
        example.initializeMapExample();
    }
}
