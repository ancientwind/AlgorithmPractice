package com.wayne.algo.strAndArray;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Example
 * A = [1, 2, 3, empty, empty], B = [4, 5]
 * After merge, A will be filled as [1, 2, 3, 4, 5]
 * 
 * @author 212331901
 *
 */
public class MergeSortedArray {

    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * 
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int start = 0;
        int end = 0;
    	for (int j = 0 ; j < n ; j++) { // iterate B
    		insertToArray(A, m, B[j]);
        }
    }
    
    /**
     * rules: 
	 *   when a >= b, insert a after b;
	 *   when a < b, insert a before b.
	 *   
     * @param A
     * @param m
     * @param data
     */
    public void insertToArray(int[] A, int m, int data) {
    	
    }
    
    /**
     * insert data to A[location]
     * @param A
     * @param m
     * @param data
     * @param location
     */
    public void insertToArray(int[] A, int m, int data, int location) {
    	for (int i = m - 1; i > location; i --) {
    		A[m+1] = A[m];
    	}
    	A[location] = data;
    }
    
}
