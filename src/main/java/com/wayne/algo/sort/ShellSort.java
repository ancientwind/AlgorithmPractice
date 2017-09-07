package com.wayne.algo.sort;

public class ShellSort {

    private int length;
    private int max;
    private int array[];

    public ShellSort() {
    }

    public ShellSort(int length, int max) {
        init(length, max);
    }

    private void init(int length, int max) {
        this.length = length;
        this.max = max;
        array = DataUtils.generateIntArray(length, max);
        DataUtils.displayIntArray(array, "The original array is: ");
    }

    /*
    * gap : h = 3*h + 1
    * */
    public void shellSortBasic(int[] array) {
        int gap = (this.max - 1) / 3;
        
        while (gap > 0) {
            int outter = gap;
            int temp = array[outter];
            // TODO
        }
    }

    public static void main(String[] args) {
        ShellSort ss = new ShellSort(12, 20);
    }

}
