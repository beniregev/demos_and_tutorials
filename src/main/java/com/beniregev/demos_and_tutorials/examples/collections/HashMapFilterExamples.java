package com.beniregev.demos_and_tutorials.examples.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapFilterExamples {
    public void runExample(String[] args) {

        Map<String, Student> mapStudents = new HashMap<>();
        mapStudents.put("A", new Student(1, "Moshe", "Rabenu", 98));
        mapStudents.put("F", new Student(2, "Itshak", "Avinu", 28));
        mapStudents.put("B", new Student(9, "Jakob", "Avinu", 18));
        mapStudents.put("E", new Student(6, "Aaron", "Hacohen", 38));
        mapStudents.put("C", new Student(8, "Sarah", "Imenu", 58));
        mapStudents.put("G", new Student(3, "Rivka", "imenu", 48));
        mapStudents.put("D", new Student(5, "Lea", "Imenu", 68));
        mapStudents.put("I", new Student(4, "Avraham", "Avinu", 78));
        mapStudents.put("H", new Student(7, "Rachel", "Imenu", 88));

        System.out.println("Original Map: ");
        mapStudents.forEach((key, value) -> System.out.println(key + " : " + value));

        //  Filter HashMap by grade and put in a list:
        //  <code>
        //      List<SortStudent> listStudentSorted = new List<SortStudent>();
        //  </code>
    }

    public static void main(String[] args) {
        (new HashMapFilterExamples()).runExample(args);
    }
}

class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int grade;

    public Student(int id, String firstName, String lastName, int grade) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public Student getInstance() {
        return this;
    }

    public String getKey() {
        return String.valueOf(this.grade);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "SortStudent{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grade=" + grade +
                '}';
    }
}
