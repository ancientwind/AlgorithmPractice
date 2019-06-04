package com.wayne.algo.strAndArray;

import java.util.Arrays;

/**
 * @author 212331901
 */
public class SingleElementInSortedArray {

	private static final int data[] = {1,1,3,3,8,25,25,29,29};

	public static int compareToResult(int[] data) {
		int result = data.length > 0 ? data[1] : Integer.MIN_VALUE;

		int i = 0;
		while (i < data.length) {
			if (data[i+1] > data[i]){
		System.out.println("result: " + data[i]);
				return data[i];
			}
			i+=2;
		}

		return result;
	}

	public int getIndexOfSingleElement(int[] data) {
		System.out.println("origin data: " + Arrays.toString(data));
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
		int index = single.getIndexOfSingleElement(data);
		System.out.print( "the single element is " + data[index]);

		compareToResult(data);
	}

}
