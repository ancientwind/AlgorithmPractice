package com.wayne.algo.basics;

/**
 * 单向链表
 * @author 212331901
 *
 */
public class Link {

	private Object data = null;
	private Link next = null;
	private Link head;
	private Link tail;
	private Link curr;
	
	private void init() {
		this.head = this.tail = this.curr = new Link(null);
	}
	
	Link(Object d) {
		this.setData(d);
	}
	
	Link(Object d, Link n) {
		this.setData(d);
		this.setNext(n);
	}
	
	
	public void insert(Link curr, Link link) {
		
		if (curr.next != null) {
			
			link.setNext(curr.next);
			curr.setNext(link);
			
		} else {
			
			curr.setNext(link);
			
		}
		
	}
	
	public void insert(Link curr, Object data) {
		
		this.insert(curr, new Link(data));
	}
	
	public void deleteNext (Link curr) {
		if ( curr.getNext() != null ) {
			curr.setNext(curr.getNext().getNext());
		}
	}
	
	public Link findFirstLink(Link head, Object data) {
		Link curr = head;
		while ( curr.next != null ) {
			if (curr.getData().equals(data)) {
				return curr;
			} else {
				curr = curr.next;
			}
		}
		
		return null;
	}
	
	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}


	public Link getNext() {
		return next;
	}


	public void setNext(Link next) {
		this.next = next;
	}


	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
