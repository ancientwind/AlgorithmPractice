package com.wayne.algo.basics;

import java.util.ArrayList;

public class ArrayStack {

	private int SIZE = 10;
	
	//top one is empty
	private int top;
	
	private Object[] arrayStack;
	
	public ArrayStack() {
		this.init();
	}

	public ArrayStack(int size) {
		if ( size > 0 ) this.SIZE = size;
		this.init();
	}

	public void init() {
		this.top = 0;
		this.arrayStack = new Object[SIZE];
	}

	public boolean isEmpty() {
		return this.top == 0 ;
	}

	public boolean isFull() {
		return this.top == this.SIZE;
	}

	public static boolean isEmpty (ArrayStack stack) {
		return stack.top == 0 ;
	}
	
	public static boolean isFull (ArrayStack stack) {
		return stack.arrayStack.length == stack.SIZE; // or top == SIZE
	}
	
	public boolean push(Object obj) {
		if(top < this.SIZE) {
			arrayStack[top++] = obj;
			return true;
		}
		else {
			return false;
		}
	}
	
	public Object pop() {
		if(top > 0) {
			return this.arrayStack[--top];
		}
		else {
			return null;
		}
	}

	public Object peak() {
		if (top > 0) return this.arrayStack[top];
		else return  null;
	}
	
	public void clear() {
		this.top = 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
