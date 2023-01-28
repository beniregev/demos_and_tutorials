package com.beniregev.demos_and_tutorials.examples.java8_stream_api;

import java.util.*;

public class Java8StreamOnMapExample {
    public void mapToMapTransfer() {
        List<String> listString1 = Arrays.asList(new String[]{"11"});
        List<String> listString2 = Arrays.asList(new String[]{"22"});
        List<String> listString3 = Arrays.asList(new String[]{"33"});
        List<String> listString4 = Arrays.asList(new String[]{"44"});
        Map<String, List<String>> sourceMap = new HashMap<>();
        sourceMap.put("List<String> 1", listString1);
        sourceMap.put("List<String> 2", listString2);
        sourceMap.put("List<String> 3", listString3);
        sourceMap.put("List<String> 4", listString4);

        Map<String, String> targetMap = new HashMap<>();
        System.out.println("------- Source Map -------");
        sourceMap.forEach((k,v) -> {
            targetMap.put(k,v.get(0));
            System.out.println("key=" + k + "; value=" + v);
        });

        System.out.println("------- Target Map -------");
        targetMap.forEach((k,v) -> System.out.println("key=" + k + "; value=" + v));
    }

    public static void main(String[] args) {
        Java8StreamOnMapExample example = new Java8StreamOnMapExample();
        example.mapToMapTransfer();
    }
}
