package com.beniregev.demos_and_tutorials.demos.collections_api;

import org.springframework.hateoas.Link;

import java.util.*;

/**
 * What will be the output of the following program?
 * A)
 * X, A, B, F
 * A, B, F, X
 * X, A, B, F
 * -------------------------------------------------
 * B)
 * A, B, F, X
 * X, A, B, F
 * A, B, F, X
 * -------------------------------------------------
 * C)
 * X, A, B, F
 * X, A, B, F
 * A, B, F, X
 * -------------------------------------------------
 * D)
 * X, A, B, F
 * A, B, F, X
 * A, B, X, F
 */
public class CollectionsOutput {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<String>();
        ls.add("X");
        ls.add("A");
        ls.add("B");
        ls.add("F");

        List<String> lnl = new LinkedList<String>();
        lnl.add("X"); lnl.add("A"); lnl.add("B"); lnl.add("F");

        Queue<String> pq = new PriorityQueue<String>();
        pq.add("X");
        pq.add("A");
        pq.add("B");
        pq.add("F");
        System.out.println(ls.get(0) + ", " + ls.get(1) + ", " + ls.get(2) + ", " + ls.get(3));
        System.out.println("-------------------------------------------------");
        System.out.println(lnl.get(0) + ", " + lnl.get(1) + ", " + lnl.get(2) + ", " + lnl.get(3));
        System.out.println("-------------------------------------------------");
        System.out.println(pq.poll() + ", " + pq.poll() + ", " + pq.poll() + ", " + pq.poll());
    }
}