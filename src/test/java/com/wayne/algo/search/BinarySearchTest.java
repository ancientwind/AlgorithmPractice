package com.wayne.algo.search;

import com.wayne.algo.sort.DataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {
    @BeforeEach
    public void setUp() throws Exception {
    }

    @Test
    public void biSearch() throws Exception {
        assertEquals(6, BinarySearch.biSearch(DataSource.my_array, 28));
        assertEquals(9, BinarySearch.biSearch(DataSource.my_array, 238));
    }

    @Test
    public void biSearchRecur() throws Exception {
        assertEquals(6, BinarySearch.biSearchRecur(DataSource.my_array, 28, 0, DataSource.MAX - 1));
        assertEquals(9, BinarySearch.biSearchRecur(DataSource.my_array, 282, 0, DataSource.MAX - 1));
    }
}