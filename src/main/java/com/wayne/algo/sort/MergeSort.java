package com.wayne.algo.sort;

public class MergeSort {
	private int[] numbers;
	private int[] helper;

	private int number;

	public void sort(int[] values) {
		this.numbers = values;
		number = values.length;
		this.helper = new int[number];
		mergesort(0, number - 1);
	}

	private void mergesort(int low, int high) {
		
		// check if low is smaller than high, if not then the array is sorted
		if (low < high) {
			int middle = low + (high - low)/2;
			mergesort(low, middle);
			mergesort(middle+1, high);
			merge(low, middle, high);
		}
	}
	
    private void merge(int low, int middle, int high) {
        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while ( i <= middle && j <= high) {
        	
        	if ( helper[i] < helper[j] ) {
        		numbers[k] = helper[i];
        		i++;
        	} else {
        		numbers[k] = helper[j];
        		j++;
        	}
        	
        	k++;
        }
        
        // if the left side has no remaining data, means the remaining data in right are all larger than left, no need to adjust any more 
        // if the left side has remaining data, means all right have been merged, copy the rest of the left side of the array into the target array
        while ( i <= middle ) {
        	numbers[k++] = helper[i++];
        }
        
        
    }

}
