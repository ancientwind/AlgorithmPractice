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
    public void shellSortBasic() {

        // get the max step as start point
        int step = 1;
        while (step <= this.max / 3) {
            step = 3 * step + 1; // [1,4,13,...]
        }

        // sort array by each step from max to 1
        while (step > 0) {

            // sort by index gap = step, using insert sort algorithm
            for (int outter = step; outter < this.length; outter++) {

                int temp = array[outter];
                int inner = outter;

                // find where to insert the temp
                while ( inner > step -1 && array[inner-step] > temp) {
                    array[inner] = array[inner-step];
                    inner -= step;
                }
                array[inner] = temp;
            }

            step = (step -1) / 3;
        }
    }

    public static void main(String[] args) {
        ShellSort ss = new ShellSort(20, 30);
        ss.shellSortBasic();
        DataUtils.displayIntArray(ss.array, "sorted result: ");
    }
}
