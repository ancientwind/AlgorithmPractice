package com.wayne.algo.binaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LinkedBinaryTree implements BinaryTree {

	protected BTreeNode root;
	
	public LinkedBinaryTree(){
		this.root = null;
	}
	
	public LinkedBinaryTree(BTreeNode root) {
		this.root = root;
	}
	
	public static void main(String[] args) {
		String treeTable = "A(B(C,D),E(,F(G)))";
		LinkedBinaryTree tree = new LinkedBinaryTree();
		
		System.out.print("Start creating binary tree with table: " + treeTable + "\n\n");
		tree.createBTree(treeTable);
		
		tree.traverseBTree(TraverseMode.PREORDER);
		tree.traverseBTree(TraverseMode.INORDER);
		tree.traverseBTree(TraverseMode.POSTORDER);
		tree.traverseBTree(TraverseMode.LEVELORDER);
		
//		System.out.print("\nSearch Node with element: C \n");
//		BTreeNode node = tree.findNodeInBTree(tree.root, 'C');
		
//		System.out.print("\n the depth of this tree is: " + tree.getDepth(tree.root) + "\n");
		
		System.out.print("\n the total number of nodes in this tree is: " + tree.countNodes(tree.root) + "\n");
		
		tree.printBTree(tree.root);
	}

	@Override
	public boolean createBTree(String str) {
		
//		Stack<BTreeNode> stack = new Stack<BTreeNode>();	// Prefer to use Deque(Double Ended Queue)
		Deque<BTreeNode> stack = new ArrayDeque<BTreeNode>();
		
		char[] input = str.toCharArray();
		
		BTreeNode node = null;	// current node
		
		int k = 1;	// 1:left, 2:right
		
		for(char ch: input){
			
			switch (ch) {
			case ' ':
				break;
			case '(':	// push current node to stack to mark a pair; k=1
				stack.push(node);
				k = 1;
				break;
			case ',':	// followed by right node, so set k=2
				k = 2;
				break;
			case ')':	// end of a pair of brothers, so pop
				stack.pop();
				break;
			default :
				if ( ( ch >= 'a' && ch <= 'z' )  || ( ch >= 'A' && ch <= 'Z' ) ) {
					
					node = new BTreeNode(ch);
					
					if(this.isEmpty()) {
						this.root = node;
					}
					else {
						if( k == 1 ) {
							((BTreeNode)stack.peek()).setLeft(node);
						} 
						else {
							((BTreeNode)stack.peek()).setRight(node);
						}
					}
				}
				else {
					System.out.println("error character in tree table");
				}
			}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public boolean isEmpty() {
		if(this.root == null)
			return true;
		else 
			return false;
	}

	@Override
	public void traverseBTree(TraverseMode mode) {
		
		switch (mode) {
			case PREORDER :
				System.out.print("Starting pre-order:\n");
				traverseBTreeByPreOrder(this.root);
				break;
			case INORDER :
				System.out.print("\nStarting in-order:\n");
				traverseBTreeByInOrder(this.root);
				break;
			case POSTORDER :
				System.out.print("\nStarting post-order:\n");
				traverseBTreeByPostOrder(this.root);
				break;
			case LEVELORDER :
				System.out.print("\nStarting level-order:\n");
				traverseBTreeByLevelOrder(this.root);
				break;
			default:
				System.out.print("error traverse type");
					
		}
	}

	private void traverseBTreeByLevelOrder(BTreeNode root) {
		
		if (root == null) {
			return ;
		}
		else {
			Deque<BTreeNode> queue = new ArrayDeque<BTreeNode>();
			queue.offer(root);
			
			BTreeNode node = null;
			while (!queue.isEmpty()) {
				node = queue.poll();
				System.out.print(node + "-");
				if (node.getLeft() != null) {
					queue.offer(node.getLeft());
				}
				if (node.getRight() != null) {
					queue.offer(node.getRight());
				}
			}
		}
	}

	//PostOrder: left->right->root
	private void traverseBTreeByPostOrder(BTreeNode root) {
		
		if (root == null) {
			return ;
		}
		else {
			traverseBTreeByPostOrder(root.left);
			traverseBTreeByPostOrder(root.right);
			System.out.print(root + "-");
		}	
	}

	//InOrder: left->root->right
	private void traverseBTreeByInOrder(BTreeNode root) {

		if (root == null) {
			return ;
		}
		else {
			traverseBTreeByInOrder(root.left);
			System.out.print(root + "-");
			traverseBTreeByInOrder(root.right);
		}		
	}

	//PreOrder : root->left->right
	private void traverseBTreeByPreOrder(BTreeNode root) {
		
		if (root == null) {
			return ;
		}
		else {
			System.out.print(root + "-");
			traverseBTreeByPreOrder(root.left);
			traverseBTreeByPreOrder(root.right);
		}
	}

	/**
	 * 思路：类似先序遍历 
	 */
	@Override
	public BTreeNode findNodeInBTree(BTreeNode root, Object element) {
		
		
		if (root != null) {
			if (((Character)root.getElement()).equals(element)) {
				System.out.print("found node: " + root + "\n");
				return root;
			}
			else {
				findNodeInBTree(root.getLeft(), element);
				findNodeInBTree(root.getRight(), element);
			}
		}
		
		return null;
	}

	/**
	 * 思路：若一一棵二叉树为空，那么它的深度为0，否则它的深度等于左子树和右子树中的最大深度+1 
	 */
	@Override
	public int getDepth(BTreeNode root) {
		
		if (root == null) {
			return 0;
		}
		else {
			int depthLeft = getDepth(root.getLeft());
			int depthRight = getDepth(root.getRight());
			if (depthLeft > depthRight) 
				return depthLeft + 1;
			else 
				return depthRight + 1;
		}
	}

	@Override
	public int countNodes(BTreeNode root) {
		
		if (root == null) {
			return 0;
		}
		else {
			return countNodes(root.left) + countNodes(root.right) + 1;
		}
	}

	@Override
	public void printBTree(BTreeNode root) {

		if (root == null) {
			return ;
		}
		else {
			System.out.print(root.element);
			if (root.hasLeft()) {
				System.out.print("(");
				printBTree(root.getLeft());
			}
			if (root.hasRight()) {
				System.out.print(",");
				printBTree(root.getRight());
				System.out.print(")");
			}
		}
	}
	
}
