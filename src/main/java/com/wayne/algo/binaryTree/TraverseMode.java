package com.wayne.algo.binaryTree;

public enum TraverseMode {
	
	PREORDER("pre"), INORDER("in"), POSTORDER("post"), LEVELORDER("level");
	
	private final String mode;
	
	TraverseMode(String mode){
		this.mode = mode;
	}
	
	public String getMode(){
		return this.mode;
	}
}
