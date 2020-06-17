package com.wayne.algo.basics;

/**
 * @author 212331901
 * @date 4/15/2020
 */
public class BasicExceptionHandling {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println();
    }
}
