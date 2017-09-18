package com.wayne.algo.sort;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wayne on 2017/9/17.
 */
public class RadixSortTest {

    private RadixSort radixSort;

    @BeforeClass
    public void init(){
        radixSort = new RadixSort();
    }

    @Test
    public void sort() throws Exception {
        int array[] = DataUtils.generateIntArray(8, 235);
        DataUtils.displayIntArray(array, "before sort: ");
        radixSort.sort(array);
        DataUtils.displayIntArray(array, "sorted: ");
    }

    @Test
    public void getNumOnDigit() throws Exception {
        int number = 234698;
        assertEquals(6, RadixSort.getNumOnDigit(number, 10, 3));
    }

    @Test
    public void mutiplePower() throws Exception {
        assertEquals(100, RadixSort.mutiplePower(10, 3));
    }

    @Test
    public void getLargestDigit() throws Exception {
        int array[] = {23,244,12,5,36};
        assertEquals(3, RadixSort.getLargestDigit(array));
    }

    @Test
    public void getDigits() throws Exception {
        assertEquals(4, RadixSort.getDigits(2535));
    }

    @Test
    public void getDigitsWithStringMethod() throws Exception {
        assertEquals(4, RadixSort.getDigits(2535));
    }

}