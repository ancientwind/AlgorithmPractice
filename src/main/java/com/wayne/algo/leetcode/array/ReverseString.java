package com.wayne.algo.leetcode.array;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseString rs = new ReverseString();
		System.out.print(rs.reverse2("Let's fly away !"));
	}
	
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
}
