package com.wayne.algo.lintcode.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.BeforeClass;

import com.wayne.algo.lintcode.array.MaximumSubarray;

public class MaximumSubarrayTest {

	private static MaximumSubarray maximum;
	
	private int[] input1 = {-2,2,-3,4,-1,2,1,-5,3};
	private int[] input2 = {-4};

	
	@BeforeClass
	public static void init() {
		maximum = new MaximumSubarray();
	}
	
	@Test
	public void testMaxSubArray_1() {
		assertEquals(6, maximum.maxSubArray(input1));
	}
	
	@Test
	public void testMaxSubArray_2() {
		assertEquals(-4, maximum.maxSubArray(input2));
	}
	
	@Test
	public void testmaxSubArray2_1() {
		assertEquals(6, maximum.maxSubArray2(input1));
	}
	
	@Test
	public void testmaxSubArray2_2() {
		assertEquals(-4, maximum.maxSubArray2(input2));
	}
	

}
