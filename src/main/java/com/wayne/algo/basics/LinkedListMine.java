package com.wayne.algo.basics;

public class LinkedListMine<T> {

	private ListNode<T> head;
	private ListNode<T> tail;

	public static class ListNode<T> {
		public T val;
		public ListNode next;

		public ListNode(T val) {
			this.val = val;
			this.next = null;
		}
	}

	/**
	 * init an empty
	 * 
	 * @param null
	 */
	public LinkedListMine() {
		this.head = this.tail = null;
	}

	/**
	 * if there's only one node, head and tail will point to the same node
	 * 
	 * @param val
	 */
	public void addHead(T val) {
		this.head = new ListNode<T>(val);
		if (this.tail == null)
			this.tail = this.head;
	}

	public void addTail(T val) {
		if (this.head == null)
			this.addHead(val);
		else {
			this.tail = new ListNode<T>(val);
			this.head.next = this.tail;
		}
	}

	public void insertAfterHead(T val) {
		if (this.head == null) {
			this.addHead(val);
		} else if (this.head == this.tail) { // only one node
			this.addTail(val);
		} else {
			ListNode<T> next = this.head.next;
			this.head.next = new ListNode<T>(val);
			this.head.next.next = next;
		}
	}
	
	public void insertNode(ListNode<T> curr, ListNode<T> node) 
	{
		node.next = curr.next;
		curr.next = node;
		if (node.next == null) {
			this.tail = node;
		} else {
			
		}
	}
	
	public void deleteNextNode(ListNode<T> curr)
	{
		curr.next = curr.next.next;
	}

	/**
	 * given head node and print all
	 * 
	 * @param head
	 */
	public void printListNode(ListNode<T> head) {
		int num = 1;
		while (head != null) {
			System.out.println("Node-" + (num++) + ": " + head.val);
			head = head.next;
		}
	}

	/**
	 * print this LinkedList
	 */
	public void printLinkedList() {
		if (this.head != null) {
			ListNode<T> cur = this.head;
			int num = 1;
			while (cur != null) {
				System.out.println("Node-" + (num++) + ": " + cur.val);
				cur = cur.next;
			}
		}

	}

	/**
	 * 链表的基本形式是： 1 -> 2 -> 3 -> null ，反转需要变为 3 -> 2 -> 1 -> null 。这⾥要注意：
	 * a.访问某个节点 curt.next 时，要检验 curt 是否为 null。 b.要把反转后的最后⼀个节点（即反转前的第⼀个节点）指向
	 * null。
	 * 
	 * @param
	 */
	public void reverseListNode() {

		if (this.head == null || this.head == this.tail)
			return;

		// init
		ListNode<T> prev = null;
		ListNode<T> cur = this.head;
		ListNode<T> next = null;

		// handle tail
		this.tail = this.head;

		// the rest node
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}

		// handle head
		this.head = prev;
	}

	/**
	 * 
	 * Double linked list
	 *
	 */
	public static class DListNode<T> {
		T val;
		DListNode prev;
		DListNode next;

		public DListNode(T val) {
			this.prev = this.next = null;
		}
	}

	public void reverseDListNode(DListNode<T> head) {

		DListNode cur = null;
		while (head != null) {
			cur = head;
			head = cur.next;
			cur.next = cur.prev;
			cur.prev = head;
		}
	}

	public static void main(String... args) {
		LinkedListMine<Integer> list = new LinkedListMine<Integer>();
		list.insertAfterHead(3);
		list.insertAfterHead(6);
		list.insertAfterHead(9);
		list.insertAfterHead(15);
		list.printLinkedList();
		list.reverseListNode();
		list.printLinkedList();
	}
}
