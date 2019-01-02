package com.wayne.algo.basics;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TempTest {

    @Test
    public void testBytesOfPrimitiveDataTypes() throws Exception {
        int a_int = 82;
        short a_short = 82;
        long a_long = 82;
        float a_float = 82;
        double a_double = 82;
//        assertEquals(32, Integer.SIZE);
        assertEquals(1, Byte.BYTES);
        assertEquals(4, Integer.BYTES);
        assertEquals(2, Short.BYTES);
        assertEquals(8, Long.BYTES);
        assertEquals(4, Float.BYTES);
        assertEquals(8, Double.BYTES);
    }

    @Test
    public void testThreadSleep() {
        int MAX = 5;
        int count = 0;
        while ((count++) < MAX) {
            System.out.println("times in loop: " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        assertEquals(6, count);
    }
}
