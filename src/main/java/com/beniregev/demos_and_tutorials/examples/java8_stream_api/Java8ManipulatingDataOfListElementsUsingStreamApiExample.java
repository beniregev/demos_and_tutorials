package com.beniregev.demos_and_tutorials.examples.java8_stream_api;

import com.github.javafaker.Faker;
import lombok.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8ManipulatingDataOfListElementsUsingStreamApiExample {
    @Setter
    @Getter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    class User {
        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private LocalDate dateOfBirth;
    }

    private Faker faker = Faker.instance();

    //  Stream.generate(() -> faker.hobbit().quote())
    private List<User> listUsers = Arrays.asList(
            new User(1, faker.name().firstName(), faker.name().lastName(), "", LocalDate.now()),
            new User(2, faker.name().firstName(), faker.name().lastName(), "", LocalDate.now()),
            new User(3, faker.name().firstName(), faker.name().lastName(), "", LocalDate.now()),
            new User(4, faker.name().firstName(), faker.name().lastName(), "", LocalDate.now()),
            new User(5, faker.name().firstName(), faker.name().lastName(), "", LocalDate.now()),
            new User(6, faker.name().firstName(), faker.name().lastName(), "", LocalDate.now()),
            new User(7, faker.name().firstName(), faker.name().lastName(), "", LocalDate.now()),
            new User(8, faker.name().firstName(), faker.name().lastName(), "", LocalDate.now()),
            new User(9, faker.name().firstName(), faker.name().lastName(), "", LocalDate.now())
    );

    public void updateUserEmailByNamesUsingStreamAPI1() {
        System.out.println("-------------------------------------------------");
        System.out.println("updateUserEmailByNamesUsingStreamAPI1(): ");
        List<User> newListUsers = listUsers.stream()
                .map(u -> new User(u.getId(), u.getFirstName(), u.getLastName(),
                        u.getFirstName() + "." + u.getLastName() + "@domain.com",
                        u.getDateOfBirth()))
                .collect(Collectors.toList());
        newListUsers.stream().forEach(u -> System.out.println("\t*  " + u.getId() + ", "
                + u.getFirstName() + ", " + u.getLastName() + ", " + u.getEmail() + ", "
                + u.getDateOfBirth()));

    }

    public void updateUserEmailByNamesUsingStreamAPI2() {
        System.out.println("\n-------------------------------------------------");
        System.out.println("updateUserEmailByNamesUsingStreamAPI2(): ");
        List<User> modified = listUsers.stream()
                .map(s -> new User(s.getId(), s.getFirstName(), s.getLastName(), s.getEmail(), s.getDateOfBirth())) // '.map(SampleDTO::new)' with copy constructor
                .peek(s -> s.setEmail(s.getFirstName() + "." + s.getLastName() + "@domain.com"))
                .collect(Collectors.toList());
        modified.stream().forEach(u -> System.out.println("\t*  " + u.getId() + ", "
                + u.getFirstName() + ", " + u.getLastName() + ", " + u.getEmail() + ", "
                + u.getDateOfBirth()));
    }

    public static void main(String[] args) {
        Java8ManipulatingDataOfListElementsUsingStreamApiExample example = new Java8ManipulatingDataOfListElementsUsingStreamApiExample();
        System.out.println("The original Users List: ");
        example.getListUsers().stream().forEach(u -> System.out.println("*  " + u.getId() + ", "
                + u.getFirstName() + ", " + u.getLastName() + ", " + u.getEmail() + ", "
                + u.getDateOfBirth()));
        example.updateUserEmailByNamesUsingStreamAPI1();
        example.updateUserEmailByNamesUsingStreamAPI2();
    }

    public List<User> getListUsers() {
        return listUsers;
    }
}
