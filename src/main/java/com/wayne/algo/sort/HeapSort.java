package com.wayne.algo.sort;

/**
 * heap is a complete binary tree; every node is bigger or smaller than its children
 * usually use array to store heap because its location could be calculated
 *
 * @author 212331901
 * @date 2019/4/4
 */
public class HeapSort {

    /**
     * increasing sort
     *
     * @param arr
     */
    public void sort(int[] arr) {
        int n = arr.length;

        /**
         * build heap, start from last node's parent, and iterate each parents
         */
        for (int i = parent(n); i >= 0; i--) {
            heapify(arr, n, i);
        }

        /**
         * one by one extract an element from heap
         */
        int i = n;
        while (i > 0) {
            // move current root to end
            DataUtils.swap(arr, 0, i - 1);
            // as root changed, do heapify from root node for total (i - 1) nodes
            heapify(arr, i - 1, 0);
            i--;
        }

    }

    /**
     * max-root heapify for subtree with subroot node i
     * <p>
     * 1. compare with left and right child
     * 2. if exchange, do heapify the exchanged child
     *
     * @param arr
     * @param n   size of the heap
     * @param i   root node of sub
     */
    private void heapify(int[] arr, int n, int i) {
        int largest = i; // initialize largest as root
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            DataUtils.swap(arr, largest, i);
            heapify(arr, n, largest); // recursively heapify the affected sub-tree
        }
    }

    protected int parent(int i) {
        return (i - 1) / 2;
    }

    protected int leftChild(int i) {
        return 2 * i + 1;
    }

    protected int rightChild(int i) {
        return 2 * i + 2;
    }

    public static void main(String[] args) {
//        int[] arr = DataUtils.generateIntArray(8, 20);
        int[] arr = {13, 12, 1, 20, 13, 11, 9, 11, 7, 5};
        DataUtils.displayIntArray(arr, "origin: ");
        System.out.println();
        new HeapSort().sort(arr);
        DataUtils.displayIntArray(arr, "result: ");
    }
}
