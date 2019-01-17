package com.wayne.algo.sort;

/**
 * use a matrix a[][] to store number regarding each
 * assume radix is 10
 */
public class RadixSortMatrix {

    /**
     * to store data categorized by the number on each digit
     */
    private int[][] bucket;
    /**
     * count of data in each bucket[i] at current digit
     */
    private int[] numbers;
    /**
     * the largest digit in array
     */
    private int digit = 1;

    public static void main(String[] args) {
        RadixSortMatrix sortMatrix = new RadixSortMatrix();
        int[] array = DataUtils.generateIntArray(10, 1240);
//        int[] array = {23,12,54,83,38,104,218,421,65,105,308,512};
        DataUtils.displayIntArray(array, "Origin: ");
        sortMatrix.sort(array);
        DataUtils.displayIntArray(array, "Sorted: ");
    }

    public void  sort(int[] array) {
        initBucket(array);
        initDigit(array);
        int radix = 1;

        for (int i = 1; i <= digit ; i++) {
            // put data from array to bucket by number on digit
            for (int data: array) {
                int numberOnDigit = (data / radix) % 10;
                bucket[numberOnDigit][numbers[numberOnDigit]++] = data;
            }
            radix *= 10;
            moveDataFromBucket(array);
        }
    }

    private void moveDataFromBucket(int[] array) {
        int index = 0;

        for (int i = 0; i < 10; i++) {
            int position = 0;
            while (numbers[i] > 0) {
                array[index++] = bucket[i][position++];
                numbers[i]--;
            }
        }
    }

    private void initBucket(int[] array) {
        bucket = new int[10][array.length];
        numbers = new int[10];
    }

    private void initDigit(int[] array) {
        digit = DataUtils.getLargestDigit(array);
    }
}
