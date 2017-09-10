package com.wayne.algo.sort;

import java.util.concurrent.ThreadLocalRandom;

public class DataUtils {

    public static int[] generateIntArray(int length, int max) {
        int array[] = new int[length];
        int i = 0;
        while ( i < length ) {
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
    }

}
