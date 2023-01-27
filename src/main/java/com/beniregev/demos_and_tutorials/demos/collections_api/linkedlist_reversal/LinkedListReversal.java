package com.beniregev.demos_and_tutorials.demos.collections_api.linkedlist_reversal;

public class LinkedListReversal {

    public static ListNode constructLinkedList(int listSize) {
        ListNode head = null;
        ListNode tail = null;
        for (int i = 1; i <= listSize; i++) {
            ListNode node = new ListNode(i);
            if (head == null) {
                head = node;
            } else {
                tail.setNext(node);
            }
            tail = node;
        }
        return head;
    }

    public ListNode reverseListIterative(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextElement = current.getNext();
            current.setNext(previous);
            previous = current;
            current = nextElement;
        }
        return previous;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.getNext() == null) {
            return head;
        }
        ListNode node = reverseListRecursive(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return node;
    }

    public void printLinkedList(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.getData() + " --> ");
            node = node.getNext();
        }
        System.out.println("||");
    }
}
