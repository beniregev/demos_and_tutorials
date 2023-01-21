package com.beniregev.demos_and_tutorials.demos.java_test;

import java.util.Arrays;
import java.util.List;

public class JavaSyntaxConversion {
    public static void main(String[] args) {
        List<Integer> listCards = Arrays.asList(1,2,4,5,6);
        for (Integer card: listCards) {
            int xCard = card * card;
            System.out.println(xCard);
        }
        System.out.println("-------------------------------------------------");
        /* A) An Error --> listCards.stream(xCard).map(xCard * xCard).forEach(System.out::println); */
        /* B) An error (my selection) --> listCards.stream((xCard) -> xCard * xCard).forEach(System.out::println); */
        /* C) Error --> listCards.map().stream((xCard) -> xCard * xCard).forEach(System.out::println); */
        /* D) Correct */ listCards.stream().map((xCard) -> xCard * xCard).forEach(System.out::println);

    }
}
