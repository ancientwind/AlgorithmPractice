package com.wayne.algo.search;

import com.wayne.algo.sort.DataUtils;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author 212331901
 * @date 2019/4/12
 */
public class FindMedian {

    /**
     * (x..,a,y...) find a which x... < a and y... > a
     *
     * use heap
     * 1. make a mini-root heap of size n/2
     * 2. put [0,n/2] to heap
     * 3. compare i in [n/2 +1,n],if i <= heap[0] dismiss it, else add to heap and resize
     * @param array
     * @return
     */
    public static double medianByHeap(int[] array) {

        if (array == null || array.length == 0) {
            return -1;
        }

        int heapSize = array.length / 2 + 1;
        /** increasing queue*/
        PriorityQueue<Integer> heap = new PriorityQueue<>(heapSize);
        for (int i = 0; i < heapSize; i++) {
            heap.add(array[i]);
        }

        System.out.println("first heap: ");
        Iterator<Integer> iterator = heap.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        for (int i = heapSize ; i < array.length; i++) {
            if (array[i] > heap.peek()) {
                heap.poll();
                heap.add(array[i]);
            }
        }

        return (array.length % 2 == 1) ? (double) heap.peek() : (heap.poll() + heap.peek()) / 2.0;
   }

    public static void main(String[] args) {
        int[] arr = DataUtils.generateIntArray(7, 20);
        DataUtils.displayIntArray(arr, "origin: ");
        System.out.println("the median is : " + FindMedian.medianByHeap(arr));
    }
}

