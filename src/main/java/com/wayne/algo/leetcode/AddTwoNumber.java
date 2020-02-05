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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode index = head;

        int sum = 0;
        int digitPlus = 0; // 1 means to add 1 in next digit
        while(l1 != null) {
            if (l2 != null) {
                sum = l1.val + l2.val + digitPlus;
                index.next = new ListNode(sum % 10 );

                digitPlus = sum / 10;
                l2 = l2.next;
            } else {
                sum = l1.val + digitPlus;
                index.next = new ListNode(sum % 10);
                digitPlus = sum /10;
            }
            l1 = l1.next;
            index = index.next;
        }
        while (l2 != null) {
            if (digitPlus == 0) {
                index.next = l2;
                break;
            } else {
                sum = l2.val + digitPlus;
                index.next = new ListNode(sum % 10);
                digitPlus = sum / 10;
                l2 = l2.next;
                index = index.next;
            }
        }
        if (digitPlus == 1) {
            index.next =new ListNode(1);
        }

        return head.next;
    }

    public static void main(String[] args) {
        AddTwoNumber addTwoNumber = new AddTwoNumber();

        testCase1(addTwoNumber);
        testCase2(addTwoNumber);
        testCase3(addTwoNumber);
        testCase4(addTwoNumber);
        testCase5(addTwoNumber);
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

