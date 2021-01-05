package com.beniregev.demos_and_tutorials.examples.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapFilterExamples {
    public void runExample(String[] args) {
        Map<String, Student> mapStudents = new HashMap<>();
        mapStudents.put("A", new Student(1, "Moshe", "Ranenu", 98));
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

        //  Filter HashMap by grage and put in a List
        //List<SortStudent> listStudentSorted = new
    }

    public static void main(String[] args) {
        (new HashMapFilterExamples()).runExample(args);
    }
}

class Student {
    private int id;
    private String fname;
    private String lname;
    private int grade;

    public Student(int id, String fname, String lname, int grade) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
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

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", grade=" + grade +
                '}';
    }
}
