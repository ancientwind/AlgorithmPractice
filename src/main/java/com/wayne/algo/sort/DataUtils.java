package com.wayne.algo.sort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class DataUtils {

    public static int[] generateIntArray(int length, int max) {
        int array[] = new int[length];
        int i = 0;
        while (i < length) {
            array[i++] = ThreadLocalRandom.current().nextInt(1, max + 1);
        }
        return array;
    }

    public static void displayIntArray(int[] array, String intro) {
        if (intro != null && intro.length() > 0) {
            System.out.println(intro);
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * @param number the input number
     * @param radix  10
     * @param digit  1=1s 2=10s 3=100s
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

    public static int getLargestDigit(int[] array) {
        int largest = 1;
        for (int i = 0; i < array.length; i++) {
            int digit = getDigits(array[i]);
            if (digit > largest) largest = digit;
        }
        return largest;
    }

    public static int getDigits(int number) {
        int count = 1;
        while ((number = number / 10) > 0) {
            count++;
        }
        return count;
    }

    public static int getDigitsWithStringMethod(int number) {
        return (String.valueOf(number).length());
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int getMaxNumber(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int a : array) {
            max = a > max ? a : max;
        }
        return max;
    }

    public static void insertSort(LinkedList<Integer> linkedList, int data) {
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            int curr = (int) iterator.next();
            if (data < curr) {
                linkedList.add(linkedList.indexOf(curr), data);
                return;
            }
        }
        linkedList.add(data);
    }

    public static double sum(double[] l) {
        double r = Double.MIN_NORMAL;
        for(double d: l) {
            r += d;
        }
        return r;
    }
}
