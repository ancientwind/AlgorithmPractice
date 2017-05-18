package com.wayne.algo.sort;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

    private int[] numbers;
    private final static int SIZE = 7;
    private final static int MAX = 20;

    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        	System.out.println(numbers[i]);
        }
    }

    @Test
    public void testMergeSort() {
    	
    	long startTime = System.currentTimeMillis();
    	
    	MergeSort msorter = new MergeSort();
    	msorter.sort(numbers);
    	
    	long stopTime = System.currentTimeMillis();
    	long elapsedTime = stopTime - startTime;
    	System.out.println("Mergesort used time: " + elapsedTime);
    	
        for (int i = 0; i < numbers.length - 1; i++) {
        	System.out.println(numbers[i]);
            if (numbers[i] > numbers[i + 1]) {
                fail("Should not happen");
            }
        }
        
        assertTrue(true);

    } 
    
}
