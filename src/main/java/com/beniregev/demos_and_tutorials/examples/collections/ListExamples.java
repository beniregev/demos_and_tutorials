package com.beniregev.demos_and_tutorials.examples.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListExamples {
    private void substringsInList() {
        List<String> list = Arrays.asList("filename1.txt", "filename2.txt", "filename2.xml", "filename2.csv", "filename3.txt");
        List<String> list2 = list.stream()
                .filter(x -> x.indexOf("filename2") >= 0)
                .collect(Collectors.toList());
        list2.forEach(str -> System.out.println(str + "  "));
        System.out.println("\nfound " + list2.size() + " occurrences");
    }
    public static void main(String[] args) {
        ListExamples examples = new ListExamples();
        examples.substringsInList();

    }
}
