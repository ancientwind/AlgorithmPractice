package com.wayne.algo.binaryTree;

/**
 * 
 * @author wayne linked stored binary tree node
 */
public class BTreeNode {

	public Object element;
	public BTreeNode left, right;

	public BTreeNode(Object element) {
		this.element = element;
		left = right = null;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public BTreeNode getLeft() {
		return left;
	}

	public void setLeft(BTreeNode left) {
		this.left = left;
	}

	public BTreeNode getRight() {
		return right;
	}

	public void setRight(BTreeNode right) {
		this.right = right;
	}

	public String toString() {
		return String.valueOf(this.element);
	}
	
	public boolean hasLeft() {
		return this.getLeft() != null ;
	}
	
	public boolean hasRight() {
		return this.getRight() != null ;
	}
}
