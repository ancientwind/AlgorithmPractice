package com.wayne.algo.leetcode;

/**
 * @author 212331901
 * @date 2/4/2020
 */
/**
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class AddTwoNumber {

    public int addNode(ListNode index, int val) {
        index.next = new ListNode(val % 10);
        return val / 10;
    }

    // basic solution
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode index = head;

        int digitPlus = 0; // 1 means to add 1 in next digit
        while(l1 != null) {
            if (l2 != null) {
                digitPlus = addNode(index, l1.val + l2.val + digitPlus);
                l2 = l2.next;
            } else {
                digitPlus = addNode(index, l1.val + digitPlus);
            }
            l1 = l1.next;
            index = index.next;
        }
        while (l2 != null) {
            if (digitPlus == 0) {
                index.next = l2;
                break;
            } else {
                digitPlus = addNode(index, l2.val + digitPlus);
                l2 = l2.next;
                index = index.next;
            }
        }
        if (digitPlus == 1) {
            index.next =new ListNode(1);
        }

        return head.next;
    }

    // more precise one as refactored while loop
    public ListNode addTwoNumbersPrecise(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode index = head;

        int digitPlus = 0; // 1 means to add 1 in next digit
        int sum = 0;
        while(l1 != null || l2 != null || digitPlus == 1) {
            sum = (l1 != null ? l1.val : 0 ) + (l2 != null ? l2.val : 0) + digitPlus;
            digitPlus = addNode(index, sum);

            l1 = l1 != null ? l1.next: null;
            l2 = l2 != null ? l2.next: null;
            index = index.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        AddTwoNumber addTwoNumber = new AddTwoNumber();

        testCase1(addTwoNumber);
        testCase2(addTwoNumber);
        testCase3(addTwoNumber);
        testCase4(addTwoNumber);
        testCase5(addTwoNumber);
        long end = System.currentTimeMillis();
        System.out.println("time cost: " + (end - start));
    }

    private static void testCase1(AddTwoNumber addTwoNumber) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9); l2.next = new ListNode(9);
        ListNode result = addTwoNumber.addTwoNumbers(l1, l2);
        System.out.println("the result should be: {0 0 1}");
        System.out.println(result);
    }

    private static void testCase2(AddTwoNumber addTwoNumber) {
        ListNode l1 = new ListNode(1); l1.next = new ListNode(0); l1.next.next = new ListNode(7);
        ListNode l2 = new ListNode(9); l2.next = new ListNode(3); l2.next.next = new ListNode(3);
        ListNode result = addTwoNumber.addTwoNumbers(l1, l2);
        System.out.println("the result should be: {0 4 0 1}");
        System.out.println(result);
    }

    private static void testCase3(AddTwoNumber addTwoNumber) {
        ListNode l1 = new ListNode(2); l1.next = new ListNode(4); l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5); l2.next = new ListNode(6); l2.next.next = new ListNode(4);
        ListNode result = addTwoNumber.addTwoNumbers(l1, l2);
        System.out.println("the result should be: {7 0 8}");
        System.out.println(result);
    }

    private static void testCase4(AddTwoNumber addTwoNumber) {
        ListNode l1 = new ListNode(9); l1.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode result = addTwoNumber.addTwoNumbers(l1, l2);
        System.out.println("the result should be: {8 0 1}");
        System.out.println(result);
    }

    private static void testCase5(AddTwoNumber addTwoNumber) {
        ListNode l1 = new ListNode(3); l1.next = new ListNode(7);
        ListNode l2 = new ListNode(9); l2.next = new ListNode(2);
        ListNode result = addTwoNumber.addTwoNumbers(l1, l2);
        System.out.println("the result should be: {2 0 1}");
        System.out.println(result);
    }

}

