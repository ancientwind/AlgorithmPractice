package com.wayne.algo.sort;

public class QuickSortClassic {

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
		
		if ( low >= high ) {
			return ;
		}
		else {
			int pivot = numbers[high];
			
			int next_pivot_index = patitionIt(low, high, pivot);
			quicksort(low, next_pivot_index - 1);
			quicksort(next_pivot_index + 1, high);
		}
		
	}
    
	//sorting implemented during finding next pivot index
	private int patitionIt(int low, int high, int pivot) {

		int i = low, j = high - 1;
		
		while (true) {
			
			while (numbers[i] < pivot) {
				i++;
			}
			
			while ( j >= 0 && numbers[j] > pivot ) {
				j--;
			}
			
			if ( i >= j) {
				break; 
			}
			else {
				swap(i,j);
				i++;
				j--;
			}
			
		}
		
		swap(i, high); //restore pivot to left cursor (i)
		
		return i; // return new pivot position
		
	}

	private void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int data[] = {2,21,4,5,0,13,9,8,2};
		
		QuickSort qs = new QuickSort();
		qs.sort(data);
		
		for(int i: data)
			System.out.print(i + " ");
		
	}
    
}
