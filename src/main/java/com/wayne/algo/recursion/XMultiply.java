package com.wayne.algo.recursion;

/**
 * calculate x^y, like 2^6 = 64
 */
public class XMultiply {

    public long calculate(int x, int y) {
        long result = 1;

        if ( y == 1 ) {
            return x;
        }
        else{
            int next_x = y % 2 == 1 ? power(x) * x : power(x);
            int next_y = ( y-1 ) / 2 ;
            return calculate(next_x, next_y);
        }

    }

    public int power(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        XMultiply xm = new XMultiply();
        long result = xm.calculate(2, 7);
        System.out.println(result);
    }
}
