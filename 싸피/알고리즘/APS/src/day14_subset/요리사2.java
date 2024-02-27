package day14_subset;

import java.util.Arrays;
import java.util.Scanner;

public class 요리사2 {
	static int n,r;
	static int[][] S;
	static int[] sel;
	static int[] list;
	static int index = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int t=1;t<=T;t++) {
			n =sc.nextInt();
			S = new int[n][n];
		
			
			
		}
	}
	public static void comb(int idx, int sidx) {
		if(sidx==r) {
			System.out.println(Arrays.toString(sel));
		}
		for(int i=idx;i<n-r+sidx;i++) {
			sel[sidx] = list[i];
			comb(i+1,sidx+1);
			
		}
	}
	public static int minSalt(int[] arr) {
		
	}
	

		
		
	}


