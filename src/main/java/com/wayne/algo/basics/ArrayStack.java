package com.wayne.algo.basics;

public class ArrayStack {

	private final int SIZE = 10;
	
	//top one is empty
	private int top;
	
	private Object[] arrayStack = new Object[SIZE];
	
	public ArrayStack() {
		this.top = 0;
	}
	
	public boolean isEmpty (ArrayStack stack) {
		return stack.top == 0 ;
	}
	
	public boolean isFull (ArrayStack stack) {
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
	
	public void clear() {
		this.top = 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
