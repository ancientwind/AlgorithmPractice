package com.wayne.algo.sort;

/**
 * Created by wayne on 2017/5/3.
 */
public class SelectSort {

    int[] data = DataSource.my_array;
    int size = DataSource.MAX;

    public void sort() {


        for(int i = 0; i < size - 1; i++) {
            int min_index = i;

            for( int j = i + 1; j < size; j++) {
                if( data[j] < data[min_index]) {
                    min_index = j;
                }
            }

            swap(i, min_index);
        }
    }

    private void swap(int i, int min_index) {
        if( i != min_index ) {
            int temp = data[i];
            data[i] = data[min_index];
            data[min_index] = temp;
        }
    }

    public String toString() {

        StringBuilder sbu = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sbu.append(data[i] + "-");
        }

        return sbu.toString();
    }

    public static void main(String[] args) {

        SelectSort selectSort = new SelectSort();
        System.out.println(selectSort);
        selectSort.sort();
        System.out.println(selectSort);
    }

}
