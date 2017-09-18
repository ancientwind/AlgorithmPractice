package com.wayne.algo.sort;

/**
 * use a matrix a[][] to store number regarding each
 * assume radix is 10
 */
public class RadixSortMatrix {


    private int[][] busket;
    private int[] numbers; // how many data in busket[i]
    private int digit = 1; // on which digit of the data is sorted

    public static void main(String[] args) {
        RadixSortMatrix sortMatrix = new RadixSortMatrix();
        int[] array = DataUtils.generateIntArray(10, 1240);
//        int[] array = {23,12,54,83,38,104,218,421,65,105,308,512};
        DataUtils.displayIntArray(array, "Origin: ");
        sortMatrix.sort(array);
        DataUtils.displayIntArray(array, "Sorted: ");
    }

    public void  sort(int[] array) {
        initBusket(array);
        initDigit(array);
        int radix = 1;

        for (int i = 1; i <= digit ; i++) {
            // put data from array to busket by number on digit
            for (int data: array) {
                int numberOnDigit = (data / radix) % 10;
                busket[numberOnDigit][numbers[numberOnDigit]++] = data;
            }
            radix *= 10;
            moveDataFromBusket(array);
        }
    }

    private void moveDataFromBusket(int[] array) {
        int index = 0;

        for (int i = 0; i < 10; i++) {
            int position = 0;
            while (numbers[i] > 0) {
                array[index++] = busket[i][position++];
                numbers[i]--;
            }
        }
    }

    private void initBusket(int[] array) {
        busket = new int[10][array.length];
        numbers = new int[10];
    }

    private void initDigit(int[] array) {
        digit = DataUtils.getLargestDigit(array);
    }
}
