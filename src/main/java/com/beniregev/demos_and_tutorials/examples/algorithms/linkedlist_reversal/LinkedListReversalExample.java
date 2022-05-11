package com.beniregev.demos_and_tutorials.examples.algorithms.linkedlist_reversal;

public class LinkedListReversalExample {
    LinkedListReversal linkedListReversal = new LinkedListReversal();

    public void givenLinkedList_whenIterativeReverse_thenOutputCorrectResult() {
        ListNode head = LinkedListReversal.constructLinkedList(5);
        System.out.print("whenIterativeReverse iterative - \n\tinitial state: ");
        this.linkedListReversal.printLinkedList(head);
        ListNode node = head;
        node = this.linkedListReversal.reverseListIterative(head);
        System.out.print("\tfinal state: ");
        this.linkedListReversal.printLinkedList(node);
        System.out.println("-------------------------------------------------");

    }

    public void givenLinkedList_whenRecursiveReverse_thenOutputCorrectResult() {
        ListNode head = LinkedListReversal.constructLinkedList(7);
        System.out.print("whenIterativeReverse Recursive - \n\tinitial state: ");
        this.linkedListReversal.printLinkedList(head);
        ListNode node = head;
        node = this.linkedListReversal.reverseListRecursive(head);
        System.out.print("\tfinal state: ");
        this.linkedListReversal.printLinkedList(node);
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) {
        LinkedListReversalExample examples = new LinkedListReversalExample();
        examples.givenLinkedList_whenIterativeReverse_thenOutputCorrectResult();
        examples.givenLinkedList_whenRecursiveReverse_thenOutputCorrectResult();
    }
}
