package com.beniregev.demos_and_tutorials.examples.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class InvertMap {
    private final Map<String, Integer> mapStringInteger = populateMapStringInteger();

    public Map<String, Integer> getMapStringInteger() {
        return mapStringInteger;
    }

    public <V, K> Map<V, K> beforeJava8UsingTraditionalLoop(Map<K, V> map) {
        Map<V, K> invertedMap = new HashMap<V, K>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            invertedMap.put(entry.getValue(), entry.getKey());
        }
        return invertedMap;
    }

    public <V, K> Map<V, K> withJava8UsingStreamApi(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }

    public static void main(String[] args) {
        InvertMap invertMap = new InvertMap();
        System.out.println("\n------- Print mapStringInteger using Java 8 Stream API -- Stream.forEach() -------");
        invertMap.getMapStringInteger().entrySet().stream()
                .forEach(x -> System.out.println("\t * " + x));

        Map<Integer, String> invertedMap1 = invertMap.beforeJava8UsingTraditionalLoop(invertMap.getMapStringInteger());
        System.out.println("\n------- Print invertedMap1 using Java 8 Stream API -- Stream.forEach() -------");
        invertedMap1.entrySet().stream().forEach(x -> System.out.println("\t * " + x));

        Map<Integer, String> invertedMap2 = invertMap.withJava8UsingStreamApi(invertMap.getMapStringInteger());
        System.out.println("\n------- Print invertedMap2 using Java 8 Stream API -- Stream.forEach() -------");
        invertedMap2.entrySet().stream().forEach(x -> System.out.println("\t * " + x.getKey() + ", " + x.getValue()));

    }
    private Map<String, Integer> populateMapStringInteger() {
        Map<String, Integer> result = new HashMap<>();
        result.put("first", 1);
        result.put("second", 2);
        result.put("third", 3);
        result.put("fourth", 4);
        result.put("fifth", 5);
        result.put("sixth", 6);
        result.put("seventh", 7);
        return result;
    }
}
