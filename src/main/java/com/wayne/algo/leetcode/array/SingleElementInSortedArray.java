package com.wayne.algo.leetcode.array;

public class SingleElementInSortedArray {

//	private final int data[] = {1,1,3,3,8,13,13,25,25}; 
	private final int data[] = {1,1,3,3,25,25,29}; 
	
	public int getIndexOfSingleElement(int[] data) {
		
		for (int i=0; i<data.length; i+=2) {
			
			if( i != data.length -1) {
				if ( data[i+1] != data[i]) {
					return i;
				}
			} else {
				return i;
			}

		}
		
		return 0;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SingleElementInSortedArray single = new SingleElementInSortedArray();
		int index = single.getIndexOfSingleElement(single.data);
		System.out.print( "the single element is " + single.data[index]);
	}

}
