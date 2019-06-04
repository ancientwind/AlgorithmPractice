package com.wayne.algo.strAndArray;

import java.util.Arrays;

public class ReverseString {
	
	/**
	 * Given a string, you need to reverse the order of characters in each word within a sentence
	 *  while still preserving whitespace and initial word order.
	 */
	public String reverse2(String str) {
		String[] strs = str.split(" ");
		StringBuffer sb = new StringBuffer();
		for(String s: strs) {
			sb.append(new StringBuffer(s).reverse()).append(" ");
		}
		return sb.toString().trim();
	}
	
	
	public String reverse(String str) {
		String[] strs = str.split(" ");
		StringBuffer sb = new StringBuffer();
		
		for(String s: strs) {
			sb.append(reverseWord(s)).append(" ");
		}
		
		return sb.toString().trim(); 
	}
	
	/*
	 * Strings are constant; their values cannot be changed after they are created. 
	 */
	public String reverseWord(String word) {
		int max_index = word.length() - 1;
		char[] chars = word.toCharArray();
		for (int i = 0; i <= max_index / 2; i++) {
			exchangeChar(chars, i, max_index - i);
		}
		return String.valueOf(chars);
	}
	
	public void exchangeChar(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}

	public static String reverse3(String input) {
		String[] words = input.split(" ");
		int m = 0, n = words.length - 1;
		while (m < n) {
			String temp = words[m];
			words[m++] = words[n];
			words[n--] = temp;
		}
		return Arrays.toString(words);
	}


	public static void main(String[] args) {
//		char[] test = "hello jack!".toCharArray();
		String test = "oh, hello jack!";
		System.out.println(reverse3(test));
	}
}
