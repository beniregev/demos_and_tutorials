package com.beniregev.demos_and_tutorials.demos.collections_api;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbersStoredInLinkedLists {
    static class ListNode {
        private int val;
        private ListNode next;
        ListNode() {

        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public ListNode getNext() {
            return next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * <div>
     *     <p>
     *         Given two non-empty linked lists representing two non-negative integers. The
     *         digits are stored in reverse order, and each of their nodes contains a single
     *         digit. Add the two numbers and return the sum as a linked list.
     *     </p>
     *     <p>
     *         You may assume the two numbers do not contain any leading zero, except the
     *         number 0 itself.
     *     </p>
     * </div>
     * @param l1 [2, 4, 3]
     * @param l2 [5, 6, 4]
     * @return {@code ListNode} the sum of the numbers stored in {@code l1} and {@code l2},
     * e.g., [7, 0, 8]
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum = l1.getVal() + l2.getVal();
        int carry = sum / 10;
        sum %= 10;
        ListNode result = new ListNode(sum%10);
        ListNode last = result;
        ListNode c1 = l1.getNext();
        ListNode c2 = l2.getNext();
        while (c1 != null && c2 != null) {
            sum = c1.getVal() + c2.getVal() + carry;
            carry = sum / 10;
            sum %= 10;
            c1 = c1.getNext();
            c2 = c2.getNext();
            last.setNext(new ListNode(sum));
            last = last.getNext();
        }
        if (c2 != null) c1 = c2;
        while (c1 != null) {
            sum = c1.getVal() + carry;
            carry = sum / 10;
            sum %= 10;
            c1 = c1.getNext();
            last.setNext(new ListNode(sum));
            last = last.getNext();
        }
        if (carry > 0) {
            last.setNext(new ListNode(carry));
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode ll1 = AddTwoNumbersStoredInLinkedLists.intToListNode(342);
        ListNode ll2 = AddTwoNumbersStoredInLinkedLists.intToListNode(465);
        ListNode ll3 = AddTwoNumbersStoredInLinkedLists.addTwoNumbers(ll1, ll2);
        System.out.println("ll1 = " + ll1.toString() + "\nll2 = " + ll2.toString()  + "\n-------\nll3 = " + ll3);
        System.out.println("-------------------------------------------------");
        ll1 = AddTwoNumbersStoredInLinkedLists.intToListNode(9999999);
        ll2 = AddTwoNumbersStoredInLinkedLists.intToListNode(9999);
        ll3 = AddTwoNumbersStoredInLinkedLists.addTwoNumbers(ll1, ll2);
        System.out.println("ll1 = " + ll1.toString() + "\nll2 = " + ll2.toString()  + "\n-------\nll3 = " + ll3);

    }

    private static ListNode intToListNode(int integer) {
        if (integer == 0) return new ListNode(0);
        List<ListNode> listNodes = new ArrayList<>();
        while (integer > 0) {
            int digit = integer % 10;
            integer /= 10;
            listNodes.add(new ListNode(digit));

        }
        ListNode listNode = listNodes.get(0);
        ListNode last = listNode;
        for (int i=1; i<listNodes.size(); i++) {
            last.setNext(listNodes.get(i));
            last = listNodes.get(i);
        }
        return listNode;
    }
}
