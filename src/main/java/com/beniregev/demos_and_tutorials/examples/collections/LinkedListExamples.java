package com.beniregev.demos_and_tutorials.examples.collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListExamples {
    public static void main(String[] args) {
        LinkedList<String> linkedlist1 = new LinkedList<>();
        // Add elements to linkedList using various add methods
        linkedlist1.add("B");
        linkedlist1.add("C");
        linkedlist1.addLast("G");
        linkedlist1.addFirst("A");
        linkedlist1.add(3, "D");
        linkedlist1.add("E");
        linkedlist1.add("F");
        //print the linkedList
        System.out.println("Linked list : " + linkedlist1);

        //Create and initialize an ArrayList
        ArrayList<String> aList = new ArrayList<>();
        aList.add("H");
        aList.add("I");
        //add the ArrayList to linkedList using addAll method
        linkedlist1.addAll(aList);
        //print the linkedList
        System.out.println("Linked list after adding ArrayList contents: " + linkedlist1);

        // use various remove methods to remove elements from linkedList
        linkedlist1.remove("B");
        linkedlist1.remove(3);
        linkedlist1.removeFirst();
        linkedlist1.removeLast();
        //print the altered list
        System.out.println("Linked list after deletion: " + linkedlist1);

        // use contains method to check for an element in the linkedList
        boolean returnValue = linkedlist1.contains("G");
        //print the results of contains method
        if (returnValue)
            System.out.println("List contains the element 'G' ");
        else
            System.out.println("List doesn't contain the element 'G'");

        // use size methods to return Number of elements in the linked list
        int size = linkedlist1.size();
        System.out.println("Size of linked list = " + size);

        // Get and set elements from linked list
        Object element = linkedlist1.get(3);
        System.out.println("Element returned by get() : " + element);
        linkedlist1.set(3, "J");
        System.out.println("Linked list after change : " + linkedlist1);

        //convert linkedList to Array using toArray methods
        String[] list_array = linkedlist1.toArray(new String[linkedlist1.size()]);

        for (String item : list_array) {
            System.out.print(item + "  ");
        }
        System.out.println(" -- End");

    }
}
