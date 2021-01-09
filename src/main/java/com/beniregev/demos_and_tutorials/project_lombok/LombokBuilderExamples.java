package com.beniregev.demos_and_tutorials.project_lombok;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LombokBuilderExamples {
    private List<PersonAdvanced> persons;

    public List<PersonAdvanced> getPersons() {
        return this.persons;
    }

    public void addPerson(PersonAdvanced person) {
        if (this.persons == null) {
            this.persons = new ArrayList<>();
        }
        this.persons.add(person);
    }

    public static void main(String[] args) {
        LombokBuilderExamples example = new LombokBuilderExamples();
        PersonAdvanced person = null;

        //  TODO - What will happen if I uncomment the following 2 lines
/*
        person = PersonAdvanced.builder().build();
        example.addPerson(person);
*/

        person = PersonAdvanced.builder().id(1)
                .firstName("John").lastName("Doe")
                .email("john.doe@domain.com")
                .dateOfBirth(LocalDate.now().minusDays(10).plusMonths(5).minusYears(52))
                .gender(GenderType.MALE)
                .build();
        example.addPerson(person);

        person = PersonAdvanced.builder().id(2)
                .firstName("Jane")
                .email("jane.doe@domain.com")
                .dateOfBirth(LocalDate.now().plusDays(1).minusMonths(2).minusYears(37))
                .gender(GenderType.FEMALE)
                .build();
        example.addPerson(person);

        example.getPersons().stream().forEach(
                p -> System.out.println(
                        String.format("id %s is a %s full name %s, %s DOB = %s e-mail: %s",
                                p.getId(),
                                p.getGender().name(),
                                p.getLastName(),
                                p.getFirstName(),
                                p.getDateOfBirth().format(DateTimeFormatter.ISO_LOCAL_DATE),
                                p.getEmail()
                        )));

    }
}
