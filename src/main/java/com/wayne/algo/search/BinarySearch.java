package com.wayne.algo.search;

/**
 * Search a sorted array
 */
public class BinarySearch {

    public static int biSearch(int array[], int target) {
        int low = 0, high = array.length - 1;
        int currIndex;

        while (true) {

            currIndex = (high + low) / 2;

            if (low > high) {
                return array.length; // target not in array
            }
            else if (array[currIndex] == target) {
                return currIndex;
            }
            else {
                if (target > array[currIndex]) {
                    low = currIndex + 1;
                }else {
                    high = currIndex - 1;
                }
            }

        }

    }

    public static int biSearchRecur(int array[], int target, int low, int high) {

        int currIndex = (low + high) / 2;

        if (low > high)
            return array.length;
        else if (array[currIndex] == target)
            return currIndex;
        else if (array[currIndex] < target)
            return biSearchRecur(array, target, currIndex+ 1, high);
        else
            return biSearchRecur(array, target, low, currIndex - 1);

    }
}
