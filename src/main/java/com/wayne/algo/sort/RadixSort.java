package com.wayne.algo.sort;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * base digit = 10
 */
public class RadixSort {

    Map<Integer, Queue<Integer>> busket= new HashMap<>();
    int largestDigit = 1;

    public RadixSort() {
        initBusket();
    }

    public void initBusket(){
        int size = 10;
        while (size > 0) {
            busket.put(--size, new LinkedBlockingDeque<>());
        }
    }

    public void sort(int array[]) {
        largestDigit = getLargestDigit(array);

        for (int i = 1; i <= largestDigit; i++) {
            // sort by number on digit i
            for (int j = 0; j < array.length; j++) {
                busket.get(getNumOnDigit(array[j], 10, i))
                        .add(array[j]);
            }
            // put the sorted number in busket back to array
            array = getArrayFromBusket(busket);
        }
    }

    public int[] getArrayFromBusket(Map<Integer, Queue<Integer>> busket) {
        Vector<Integer> array = new Vector<>();
        for (int number = 0; number < 10; number++) {
            Queue q = busket.get(number);
            while (!q.isEmpty()) {
                array.add((int)q.poll());
            }
        }
        return array.stream().mapToInt(i -> i).toArray();
    }

    /**
     *
     * @param number the input number
     * @param radix 10
     * @param digit 1=1s 2=10s 3=100s
     * @return number on digit position of the input
     */
    public static int getNumOnDigit(int number, int radix, int digit) {
        return (number / mutiplePower(radix, digit)) % 10;
    }

    public static int mutiplePower(int radix, int digit) {
        int result = 1;
        while (--digit > 0)
            result *= radix;
        return result;
    }

    public static int getLargestDigit(int array[]) {
        int largest = 1;
        for (int i = 0; i < array.length; i++) {
            int digit = getDigits(array[i]);
            if (digit > largest) largest = digit;
        }
        return largest;
    }

    public static int getDigits(int number) {
        int count = 0;
        while ( (number = number / 10) > 0) {
            count++;
        }
        return ++count;
    }

    public static int getDigitsWithStringMethod(int number) {
        return (String.valueOf(number).length());
    }

    public static void main(String[] args) {
        int i = 23427;
//        System.out.println(RadixSort.getDigits(i));
//        System.out.println(RadixSort.getDigitsWithStringMethod(i));
//        System.out.println((i / 1) % 10);
//        System.out.println(getNumOnDigit(i, 10, 3));
        RadixSort radixSort = new RadixSort();
        int array[] = { 23, 53, 16, 213, 27, 25, 19, 125, 36, 109};
        DataUtils.displayIntArray(array, "before sort: ");
        radixSort.sort(array);
        System.out.println("");
        DataUtils.displayIntArray(array, "sorted: ");
    }
}
