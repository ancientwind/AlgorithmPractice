package com.wayne.algo.binaryTree;

public interface BinaryTree {
	
//	public final String[] MODE = { "preOrder", "inOrder", "postOrder", "levelOrder"};
	
	/**
	 * create tree by its string of 广义表表示
	 * @param str
	 * @return
	 */
	public boolean createBTree(String str);
	public boolean isEmpty();
	
	public void traverseBTree(TraverseMode mode);
	
	public BTreeNode findNodeInBTree(BTreeNode root,Object element);
	
	public int getDepth(BTreeNode root);
	
	public int countNodes(BTreeNode root);
	
	public void printBTree(BTreeNode root);
}
