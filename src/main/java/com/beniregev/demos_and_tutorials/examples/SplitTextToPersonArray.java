package com.beniregev.demos_and_tutorials.examples;

/**
 * <div>
 *     Populate {@link Person}[] array from a {@link String} containing all the data that needs to be split.
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class SplitTextToPersonArray {
    static class Person {
        private final String surname;
        private final String name;
        private final String city;

        public Person(String surname, String name, String city) {
            this.surname = surname;
            this.name = name;
            this.city = city;
        }
        @Override
        public String toString() {
            return "Surname = "+ surname + "; " +
                    "Name = " + name + "; " +
                    "City = " + city + " ";
        }
    }

    /**
     * <div>
     *     Receiving a {@link String} with values to populate array of class Person
     * </div>
     * @param personsText
     * @return
     */
    public Person[] populatePersonArray(String personsText) {
        String[] arrayTest = personsText.split("[./ ]+");
        Person[] arrayPerson = new Person[arrayTest.length / 3];
        for (int i = 0; i < arrayPerson.length; i++) {
            arrayPerson[i] = new Person(arrayTest[i * 3], arrayTest[i * 3 + 1], arrayTest[i * 3 + 2]);
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Person array elements: ");
        for (Person person : arrayPerson) {
            System.out.println(person);
        }

        return arrayPerson;
    }

    public static void main(String[] args) {
        SplitTextToPersonArray splitTextToPersonArray = new SplitTextToPersonArray();
        Person[] persons = splitTextToPersonArray.populatePersonArray(
                "John.Wick/Budapest Michael.Bolton/Manchester Ivan.Perisic/Zagreb Vladimir.Putin/Moscow");
    }
}
