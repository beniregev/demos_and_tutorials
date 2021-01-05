package com.beniregev.demos_and_tutorials.collections;

import java.util.*;
import java.util.stream.Stream;

public class HashMapPrintExamples {

    public static void main(String[] args) {
        HashMap<String, Integer> scores = new HashMap<>();

        scores.put("KING", 100);
        int h = ("KING".hashCode() ^ ("KING".hashCode() >>> 16));
        System.out.println("n = " + scores.size());
        System.out.println("index of KING is " + h + " ; index = " + (h & 15));

        System.out.println("\n------- 1. Using Iterator -------");
        //  1. Using Iterator
        Iterator<String> itr = scores.keySet().iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        scores.put("CLARK", 90);
        h = ("CLARK".hashCode() ^ ("CLARK".hashCode() >>> 16));
        System.out.println("n = " + scores.size());
        System.out.println("index of CLARK is " + h + " ; index = " + (h & 15));

        System.out.println("\n------- 2. for-each loop -------");
        //  2. for-each loop
        for(String key : scores.keySet()) {
            System.out.println(key);
        }
        scores.put("BLAKE", 10);

        System.out.println("\n------- 3. Java 8 - Collection.iterator() + Iterator.forEachRemaining() -------");
        //  3. Java 8 - Collection.iterator() + Iterator.forEachRemaining()
        scores.keySet().iterator().forEachRemaining(System.out::println);
        scores.put("FORD", 110);

        System.out.println("\n------- 4. Java 8 - Collection.stream() + Stream.forEach() -------");
        //  4. Java 8 - Collection.stream() + Stream.forEach()
        scores.keySet().stream().forEach(System.out::println);
        scores.put("SMITH", 10);

        System.out.println("-------    Java 8 - Stream.of() + Collection.toArray() + Stream.forEach() -------");
        //  Java 8 - Stream.of() + Collection.toArray() + Stream.forEach()
        Stream.of(scores.keySet().toArray()).forEach(System.out::println);
        scores.put("WARD", 99);

        System.out.println("\n------- 5. Java 8 - Convert to String -------");
        //  5. Java 8 - Convert to String
        System.out.println(scores.keySet().toString());
        scores.put("JONES", 99);

        System.out.println("-------    Java 8 -------");
        //  Java 8
        Stream.of(scores.keySet().toString()).forEach(System.out::println);
        List<String> indexes = new ArrayList<String>(scores.keySet()); // <== Parse

        System.out.println("indexOf (\"KING\") = " +  - indexes.indexOf("KING"));     // ==> 0

        System.out.println("\n------- 6. Java 8 - Using Map.entrySet() + Stream.forEach() -------");
        //  6. Java 8 - Using Map.entrySet() + Stream.forEach()
        scores.entrySet().stream().forEach(e-> System.out.println(e));

        System.out.println("\n------- 7. Java 8 - Using Map.Entry<K, V> + Map.entrySet() -------");
        //  7. Java 8 - Using Map.Entry<K k, V v> + Map.entrySet()
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            int hash = (entry.getKey().hashCode() ^ (entry.getKey().hashCode() >>> 16));
            System.out.println("hash(\"" + entry.getKey() + "\") = " + hash
                    + " ; index = " + (hash & 15)
                    + " ; Entry = (" + entry.getKey()
                    + ":" + entry.getValue() + ")");
        }

        System.out.println("\n------- 8. Java 8 - Using Iterator + Map.Entry + Map.entrySet() -------");
        //  8. Java 8 - Using Iterator + Map.Entry + Map.entrySet()
        Iterator<Map.Entry<String, Integer>> iterator = scores.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("\n------- 9. Java 8 - With Lambdas -------");
        //  9. Java 8 - With Lambdas
        scores.forEach((k, v) -> System.out.println((k + ":" + v)));

        System.out.println("\n------- 10. Using Streams API -------");
        //  10. Using Streams API
        scores.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));

        System.out.println("-------------------------------------------------");
        String string = "KING";
        int hashNum = 2306996;
        int n = 16;
        //index = 4
        //index = 2306967 & (16 - 1) = 7
        System.out.println("index = " + hashNum + " & (" + n + " - 1) = " + (hashNum & (n -1)));
    }
}
