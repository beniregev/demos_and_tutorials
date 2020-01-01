package com.beniregev.demos_and_tutorials.examples.javafaker;

import com.github.javafaker.Faker;

public class JavaFakerExample {
    private Faker faker = new Faker();

    public Faker getFaker() {
        return faker;
    }

    public static void main(String[] args) {
        JavaFakerExample fakerExample = new JavaFakerExample();

        String fact = fakerExample.getFaker().chuckNorris().fact();
        System.out.println("Chuck Norris fact: " + fact);

        System.out.println("Star Trek character: " + fakerExample.getFaker().starTrek().character());
        System.out.println("Star Trek location: " + fakerExample.getFaker().starTrek().location());
        System.out.println("Star Trek specie: " + fakerExample.getFaker().starTrek().specie());
        System.out.println("Star Trek villain: " + fakerExample.getFaker().starTrek().villain());

        System.out.println("GoT character: " + fakerExample.getFaker().gameOfThrones().character());
        System.out.println("GoT city: " + fakerExample.getFaker().gameOfThrones().city());
        System.out.println("GoT dragon: " + fakerExample.getFaker().gameOfThrones().dragon());
        System.out.println("GoT house: " + fakerExample.getFaker().gameOfThrones().house());
        System.out.println("GoT quote: " + fakerExample.getFaker().gameOfThrones().quote());

        System.out.println("Yoda quote: " + fakerExample.getFaker().yoda().quote());

    }
}
