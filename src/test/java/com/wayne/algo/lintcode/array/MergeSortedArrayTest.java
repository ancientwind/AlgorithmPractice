package com.wayne.algo.lintcode.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.BeforeClass;

public class MergeSortedArrayTest {

	public static MergeSortedArray mergedSA;
	
	@BeforeClass
	public static void init() {
		mergedSA = new MergeSortedArray();
	}
	
	@Test
	public void testInsertToArray() {
		int[] A = {
				2 , 4, 5, 0, 0 
		};
		int m = 3;
		int data = 4;
		int location = 2;
		
		mergedSA.insertToArray(A, m, data, location);
		
		assertEquals(data, A[location]);
	}
	
	@Test
	public void testCase1() {
		int[] A = {
				2 , 4, 5, 0, 0 
		};
		int m = 3;
		int[] B = {
				6, 9
		};
		int n = 2;
		
		mergedSA.mergeSortedArray(A, m, B, n);
		
		assertEquals(6, A[3]);
		assertEquals(9, A[4]);
	}
	
	@Test
	public void testCase2() {
		int[] A = {
				2 , 6, 9, 0, 0 
		};
		int m = 3;
		int[] B = {
				4, 8
		};
		int n = 2;
		
		mergedSA.mergeSortedArray(A, m, B, n); //expect A = {2,4,6,8,9}
		
		assertEquals(4, A[1]);
		assertEquals(6, A[2]);
		assertEquals(8, A[3]);
		assertEquals(9, A[4]);
	}

}
