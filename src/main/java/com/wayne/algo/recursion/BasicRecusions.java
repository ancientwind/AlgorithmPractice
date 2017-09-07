package com.wayne.algo.recursion;

public class BasicRecusions {

	public long iteMutiply(int n) {
		if ( n <= 1 ) {
			return 1;
		}
		else {
			return n*iteMutiply(n-1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BasicRecusions br = new BasicRecusions();
		System.out.print(br.iteMutiply(4));
	}

}
