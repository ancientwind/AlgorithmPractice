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
//        quicksort(0, number - 1);
		quicksortOptimize(0, number -1);
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

    public void quicksortOptimize(int low, int high) {
    	if (low >= high) return;

    	int pivot = patitionit(low, high);
    	quicksortOptimize(low, pivot - 1);
    	quicksortOptimize(pivot + 1, high);

	}

	public int patitionit(int low, int high) {

    	// choose the median number as pivot and exchange it to high position
    	int pivot = low + (high - low) / 2;
    	exchange(pivot, high);

    	// dividerPosition keeps track of the position
		// where the pivot should be inserted
		int dividerPosition = low;

		// exchange smaller to left of dividerPosition
		for (int i = low; i < high; i++) {
			if (numbers[i] < numbers[high]) {
				exchange(i, dividerPosition++);
			}
		}

		exchange(dividerPosition, high);
		return dividerPosition;
	}

	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static void main(String[] args) {

		int data[] = {3,1,4,7,5,2,3,6,2,4,3,1,9,8};
		
		QuickSort qs = new QuickSort();
		qs.sort(data);
		
		for(int i: data)
			System.out.print(i + " ");
		
	}

}
