package com.wayne.algo.sort;

/**
 * Created by wayne on 2017/5/4.
 */
public class InsertSort {

    int[] data = DataSource.my_array;

    int size = DataSource.MAX;

    public String toString() {

        StringBuilder sbu = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sbu.append(data[i] + "-");
        }

        return sbu.toString();
    }

    /**
     * iterate rest elements then insert into the sorted array starting from index=1
     */
    public void sort () {

        for (int current = 1; current < size; current++) {
            int i = current - 1;
            int temp = data[current];
            while ( i > 0 && data[i] > temp) {
                data[i+1] = data[i];
                --i;
            }
            data[i+1] = temp;
        }
    }

    public void sort_dump() {

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if ( data[i] < data[j] ) {
                    //move data from index-j to (index-i - 1) right by 1 distance
                    int temp = data[i];
                    moveRight(j, i-1);
                    data[j] = temp;
                }
            }
        }
    }

    private void moveRight(int start, int end) {
        int i = end;
        while ( i >= start ) {
            data[i+1] = data[i];
            i--;
        }
    }

    public static void main(String[] args) {
        InsertSort insert = new InsertSort();
        insert.sort_dump();
        System.out.println(insert);
        insert.data = DataSource.my_array;
        insert.sort();
        System.out.println(insert);
    }

}
