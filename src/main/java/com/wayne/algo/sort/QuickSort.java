package com.wayne.algo.sort;

public class QuickSort {

	
	private int[] numbers;
    private int number;

    public void sort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
    	
    	int i = low, j = high;
    	int pivot = numbers[low + (high - low)/2];
    	
    	while (i<=j) {
    		
    		while (numbers[i] < pivot) {
    			i++;
    		}
    		
    		while (numbers[j] > pivot) {
    			j--;
    		}
    		
    		if (i<=j) {
    			exchange(i,j);
    			i++;
    			j--;
    		}
    	}
    	
    	if (low < j) {
    		quicksort(low, j);
    	}
    	
    	if (i < high) {
    		quicksort(i, high);
    	}
    }
    
	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int data[] = {3,1,4,5,0,1,9,8};
		
		QuickSort qs = new QuickSort();
		qs.sort(data);
		
		for(int i: data)
			System.out.print(i + " ");
		
	}

}
