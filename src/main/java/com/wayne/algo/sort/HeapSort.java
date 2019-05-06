package com.wayne.algo.sort;

/**
 *
 * heap is a complete binary tree; every node is bigger or smaller than its children
 * usually use array to store heap
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
         * build heap, start from leaf of right sub tree
         */
        for (int i = parent(n); i >= 0; i--) {
            heapify(arr, n, i);
        }

        /**
         * one by one extract an element from heap
         */
        int i = n - 1;
        while (i > 0) {
            // move current root to end
            DataUtils.swap(arr, 0, i--);
            // as root changed, do heapify from root node
            heapify(arr, i, 0);
        }

    }

    /**
     * max-root heapify for subtree with subroot node i
     *
     * @param arr
     * @param n   size of the heap
     * @param i   root node of sub
     */
    private void heapify(int[] arr, int n, int i) {
        int largest = i; // initailize largest as root
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
        int[] arr = DataUtils.generateIntArray(8, 20);
        DataUtils.displayIntArray(arr, "origin: ");
        System.out.println();
        new HeapSort().sort(arr);
        DataUtils.displayIntArray(arr, "result: ");
    }
}
