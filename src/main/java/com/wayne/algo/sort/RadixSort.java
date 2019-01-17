package com.wayne.algo.sort;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * base radix = 10
 * use a Map of <0~9, Queue> to store number regarding each digit
 */
public class RadixSort {

    Map<Integer, Queue<Integer>> bucket= new HashMap<>();
    int largestDigit = 1;

    public RadixSort() {
        initBusket();
    }

    public void initBusket(){
        int size = 10;
        while (size > 0) {
            bucket.put(--size, new LinkedBlockingDeque<>());
        }
    }

    public int[] sort(int[] array) {
        largestDigit = DataUtils.getLargestDigit(array);

        for (int i = 1; i <= largestDigit; i++) {
            // sort by number on digit i
            for (int j = 0; j < array.length; j++) {
                bucket.get(DataUtils.getNumOnDigit(array[j], 10, i))
                        .add(array[j]);
            }
            // put the sorted number in bucket back to array to prepare for higher digit sort
            array = getArrayFromBusket(bucket);
            System.out.println("\n temp: " + i);
            DataUtils.displayIntArray(array, "");
        }

        return array;
    }

    public int[] getArrayFromBusket(Map<Integer, Queue<Integer>> bucket) {
        Vector<Integer> array = new Vector<>();
        for (int number = 0; number < 10; number++) {
            Queue q = bucket.get(number);
            while (!q.isEmpty()) {
                array.add((int)q.poll());
            }
        }
        return array.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int i = 23427;
//        System.out.println(RadixSort.getDigits(i));
//        System.out.println(RadixSort.getDigitsWithStringMethod(i));
//        System.out.println((i / 1) % 10);
//        System.out.println(getNumOnDigit(i, 10, 3));
        RadixSort radixSort = new RadixSort();
        int[] array = { 23, 53, 16, 213, 27, 25, 19, 125, 36, 109};
        DataUtils.displayIntArray(array, "before sort: ");
        int[] sortedArray = radixSort.sort(array);
        System.out.println("");
        DataUtils.displayIntArray(sortedArray, "sorted: ");
    }
}
