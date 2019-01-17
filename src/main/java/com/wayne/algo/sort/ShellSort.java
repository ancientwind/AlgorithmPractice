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

    /**
    * gap : h = 3*h + 1
    */
    public void shellSortBasic() {

        // get the max step as start point
        int step = 1;
        int factor = 3;
        while (step <= this.max / factor) {
            // [1,4,13,...]
            step = step * factor + 1;
        }

        sortByStep(step, factor);

    }

    /**
     * in the original shell sort algo, 2 is used as factor to get each steps, but it not efficient cause it may do repeat comparing & insert
     * use Prime number as each step would be best as every time of insert by step, no cross repeat will occur
     */
    public void shellSortPrimeNumber() {

        double factor = 2.2;
        int max_step = (int) Math.ceil(this.length / factor);
        this.sortByStep(max_step, factor);

    }

    private void sortByStep(int step, double factor) {
        // sort array by each step from max to 1
        while (step > 0) {
            System.out.println("each step: " + step);

            // sort by index gap = step, using insert sort algorithm
            for (int outter = step; outter < this.length; outter++) {

                int temp = array[outter];
                int inner = outter;

                // find where to insert the temp
                // move to right_index if it's bigger than temp
                while ( inner > step -1 && array[inner-step] > temp) {
                    array[inner] = array[inner-step];
                    inner -= step;
                }
                array[inner] = temp;
            }

            step = (int) Math.ceil((step -1) / factor);
        }
    }

    public static void main(String[] args) {
        ShellSort ss = new ShellSort(20, 30);
        ss.shellSortPrimeNumber();
        System.out.println();
        DataUtils.displayIntArray(ss.array, "sorted result: ");
    }
}
