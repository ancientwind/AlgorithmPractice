package com.wayne.algo.sort;

import java.util.*;

/**
 * this sort apply to uniform distribution data
 *
 * @author 212331901
 * @date 2019/8/20
 */
public class BucketSort {

    /**
     * make limited bucket, put array data into each bucket, and do insert sort in each bucket;
     * put data back into array from buckets
     * @param array
     */
    public static int[] sort(int[] array) {
        int bucket_counts = array.length / 3;
        Map<Integer, LinkedList> buckets = new HashMap<>();
        for (int i = 0; i < bucket_counts; i++) {
            buckets.put(i, new LinkedList());
        }

        int max = DataUtils.getMaxNumber(array);

        for (int i = 0; i < array.length; i++) {
            int indexOfBuckets = (array[i] * bucket_counts)/(max + 1);
            System.out.println(indexOfBuckets + " for data: " + array[i]);
            DataUtils.insertSort(buckets.get(indexOfBuckets), array[i]);
        }

        List list = new ArrayList();
        buckets.forEach((k, v) -> {
            v.forEach(d -> list.add(d));
        });

        return list.stream().mapToInt( i -> (int) i).toArray();
    }

    public static void main(String[] args) {
        int[] tests = {234,489,149,824,143,620,83,193,393,620,529,684,923,359,94,418,210,724,819,293};
        int[] results = sort(tests);
        DataUtils.displayIntArray(results, "bucket sort");
    }

}
