package com.beniregev.demos_and_tutorials.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Various examples of sorting a HashMap using Java 8 features, Streams, Lambdas, Iterators, Comparators, etc. 
 * @author binyamin.regev 
 */
public class HashMapSortExamples implements Comparator<SortStudent> {
    /**
     * Using {@code sortedStudentList} for debugging purposes.
     * @param mapStudents map of students, key is first-name and value is {@link SortStudent}
     * @return Sorted students {@link List}
     */
    private List sortStudentMapByGrade(Map<String, SortStudent> mapStudents) {
        return mapStudents.entrySet().stream()
                .map(e -> new ElementWithIntegerKey(e.getValue().getGrade(), e.getValue()))
                .sorted(Comparator.comparing(ElementWithIntegerKey::getKey))
                .collect(Collectors.toList());
    }

    /**
     * Using {@code sortedStudentList} for debugging purposes.
     * @param mapStudents map of students, key is first-name and value is {@link SortStudent} 
     * @return Sorted students {@link List}
     */
    private List sortStudentMapById(Map<String, SortStudent> mapStudents) {
        return mapStudents.entrySet().stream()
                .map(e -> new ElementWithIntegerKey(e.getValue().getId(), e.getValue()))
                .sorted(Comparator.comparing(ElementWithIntegerKey::getKey))
                .collect(Collectors.toList());
    }

    private void runExample(String[] args) {
        //  region Declare and fill mapStudents Map
        Map<String, SortStudent> mapStudents = new HashMap<>();
        mapStudents.put("Moshe", new SortStudent(1, "Moshe", "Ranenu", 98));
        mapStudents.put("Itshak", new SortStudent(2, "Itshak", "Avinu", 28));
        mapStudents.put("Jakob", new SortStudent(9, "Jakob", "Avinu", 18));
        mapStudents.put("Aaron", new SortStudent(6, "Aaron", "Hacohen", 38));
        mapStudents.put("Sarah", new SortStudent(8, "Sarah", "Imenu", 58));
        mapStudents.put("Rivka", new SortStudent(3, "Rivka", "imenu", 48));
        mapStudents.put("Lea", new SortStudent(5, "Lea", "Imenu", 68));
        mapStudents.put("Avraham", new SortStudent(4, "Avraham", "Avinu", 78));
        mapStudents.put("Rachel", new SortStudent(7, "Rachel", "Imenu", 88));
        //  endregion

        //  region Original Map (Map.forEach())
        System.out.println("\nOriginal Map (Map.forEach()): ");
        mapStudents.forEach((key, value) -> System.out.println(key + " : " + value));
        //  endregion

        //  region Original Map including hash(k) + index in the Map using Map.Entry
        System.out.println("\nOriginal Map including hash(k) + index in the Map using Map.Entry: ");
        for (Map.Entry<String, SortStudent> entry : mapStudents.entrySet()) {
            int hash = (entry.getKey().hashCode() ^ (entry.getKey().hashCode() >>> 16));
            System.out.println("hash(\"" + entry.getKey() + "\") = " + hash
                    + " ; index = " + (hash & 15)
                    + " ; Entry = (" + entry.getKey()
                    + ":" + entry.getValue() + ")");
        }
        //  endregion

        //  region Sorted List of Students by key using Stream.sorted(Map.Entry.comparingByKey()) + Stream.collect(Collectors.toMap(..))
        System.out.println("\nSorted List of Students by key using Stream.sorted(Map.Entry.comparingByKey()) + Stream.collect(Collectors.toMap(..)): ");
        mapStudents.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,   //  key is the Map.Entry key, value is the Map.Entry value
                                                    (oldValue, newValue) -> oldValue,       //  When oldValue == newValue then take the oldValue
                                                    LinkedHashMap::new                  //  returns a LinkedHashMap to keep the order
                                ))
                        .forEach((key, value) -> System.out.println(key + " : " + value));
        //  endregion

        //  region Unsorted List of Students by grade using Map.values() + Stream.collect() + Iterator
        System.out.println("\nUnsorted List of Students by grade using Map.values() + Stream.collect() + Iterator: ");
        List<SortStudent> unsortedStudentsList = mapStudents.values().stream()
                .collect(Collectors.toList());
        for (Iterator it = unsortedStudentsList.iterator(); it.hasNext(); ) {
            SortStudent sortStudent = (SortStudent) it.next();
            System.out.println(sortStudent);
        }
        //  endregion
        
        //  region Sorted List of Students by grade using Map.values() + Stream.sorted() + Stream.collect() + sort() + Iterator
        System.out.println("\nSorted List of Students by grade using Map.values() + Stream.sorted() + Stream.collect() + sort() + Iterator: ");
        List<SortStudent> sortedStudentsListByGrade = mapStudents.values().stream()
                .collect(Collectors.toList());
        //  lambda, valid, parameter type is optional
        sortedStudentsListByGrade.sort((o1, o2) -> o1.getGrade() - o2.getGrade());
        for (Iterator it = sortedStudentsListByGrade.iterator(); it.hasNext(); ) {
            SortStudent sortStudent = (SortStudent) it.next();
            System.out.println(sortStudent);
        }
        //  endregion
        
        //  region Sorted List of Students by grade using Map.values() + Stream.sorted() + Stream.collect() + sort() + Iterator
        System.out.println("\nSorted List of Students by last-name using Map.values() + Stream.sorted() + Stream.collect() + sort() + Iterator: ");
        List<SortStudent> sortedStudentsListByLastName = mapStudents.values().stream()
                .collect(Collectors.toList());
        sortedStudentsListByLastName.sort((o1, o2) -> o1.getLname().compareTo(o2.getLname()));
        for (Iterator it = sortedStudentsListByLastName.iterator(); it.hasNext(); ) {
            SortStudent sortStudent = (SortStudent) it.next();
            System.out.println(sortStudent);
        }
        //  endregion
        
        //  region Sorted Stream<Map.Entry<String, SortStudent>> by Student.grade
        System.out.println("\nSorted Stream<Map.Entry<String, SortStudent>> by Student.grade: ");
        Stream<Map.Entry<String, SortStudent>> streamSortedByGrade = mapStudents.entrySet()
                .stream()
                .sorted((s1, s2) -> s1.getValue().getGrade() - s2.getValue().getGrade());
        streamSortedByGrade.forEach(System.out::println);
        //  endregion

        //  region Sorted Stream<Map.Entry<String, SortStudent>> by Student.id
        System.out.println("\nSorted Stream<Map.Entry<String, SortStudent>> by Student.id: ");
        Stream<Map.Entry<String, SortStudent>> streamSortedById = mapStudents.entrySet()
                .stream()
                .sorted((s1, s2) -> s1.getValue().getId() - s2.getValue().getId());
        streamSortedById.forEach(System.out::println);
        //  endregion

        //  region Sorted List of Students by student.grade
        System.out.println("\nSorted List of Students by student.grade: ");
        List listStudentsSorted2 = sortStudentMapByGrade(mapStudents);
        for (Iterator it = listStudentsSorted2.iterator(); it.hasNext(); ) {
            SortStudent sortStudent = ((ElementWithIntegerKey) it.next()).getSortStudent();
            System.out.println(sortStudent);
        }
        //  endregion

        //  region Sorted List of Students by student.id
        System.out.println("\nSorted List of Students by student.id: ");
        List listStudentsSorted3 = sortStudentMapById(mapStudents);
        for (Iterator it = listStudentsSorted3.iterator(); it.hasNext(); ) {
            SortStudent sortStudent = ((ElementWithIntegerKey) it.next()).getSortStudent();
            System.out.println(sortStudent);
        }
        //  endregion
    }

    public static void main(String[] args) {
        (new HashMapSortExamples()).runExample(args);
    }

    @Override
    public int compare(SortStudent s1, SortStudent s2) {
        //return s1.getFname().compareTo(s2.getFname());
        return s1.getGrade() - s2.getGrade();
    }
}

class SortStudent {
    private int id;
    private String fname;
    private String lname;
    private int grade;

    public SortStudent(int id, String fname, String lname, int grade) {
        this.setId(id);
        this.setFname(fname);
        this.setLname(lname);
        this.setGrade(grade);
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

class ElementWithIntegerKey {
    private Integer key;
    private SortStudent sortStudent;

    public ElementWithIntegerKey(Integer key, SortStudent sortStudent) {
        this.key = key;
        this.sortStudent = sortStudent;
    }

    public Integer getKey() {
        return key;
    }

    public SortStudent getSortStudent() {
        return sortStudent;
    }
}
