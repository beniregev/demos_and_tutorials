package com.beniregev.demos_and_tutorials.examples.algorithms.linkedlist_reversal;

public class ListNode {
    private int data;
    private ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    // region Getters and Setters
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
    // endregion

}
