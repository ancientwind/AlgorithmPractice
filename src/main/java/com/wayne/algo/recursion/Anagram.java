package com.wayne.algo.recursion;

/**
 * Created by wayne on 2017/9/14.
 *
 * full arrange a work , like cats can be cast, cats, atsc, ...
 */
public class Anagram {

    private char[] arrChar = new char[100];
    private int size;
    private int count = 0;

    public void doAnagram(int newSize) {
        if (newSize == 1) {
            return;
        }
        for (int i = 0; i < size; i++) {
            doAnagram(newSize - 1); // recursively do anagram for the rest of the letters
            if (newSize == 2) {
                showWorld();
            }
            rotate(newSize); // move the leftest letter to the end
        }

    }

    private void rotate(int newSize) {
        int position = size - newSize;
        char temp = arrChar[position];
        int i;
        for ( i = position + 1; i < size; i++) {
            arrChar[i - 1] = arrChar[i];
        }
        arrChar[i - 1] = temp;
    }

    public void showWorld()
    {
        if(count<99)
        {
            System.out.print(" ");
        }
        if(count<9)
            System.out.print("");

        System.out.print(++count+" ");

        for(int j=0;j<size;j++)
        {
            System.out.print(arrChar[j]);
            System.out.print("");
            System.out.flush();
        }

        System.out.print(" ");

        if(count%6==0)
        {
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        String str = "cats";
        anagram.arrChar = str.toCharArray();
        anagram.size = 4;
        anagram.doAnagram(anagram.size);

    }
}
