package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solvedac_18110 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		if(n>0) {
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int [] SortedArr = countsort(arr);
		double sum = 0;
		int del = (int) Math.round(((double)n)*3/20);
		for(int i = del;i<n-del;i++) {
			sum += SortedArr[i];
		}
		int avg = (int)Math.round(sum/(n-2*del));
		System.out.println(avg);
		}else {
			System.out.println(0);
		}

	}
	static int[] countsort(int[] arr) {
	int max = -1;
	for (int i = 0; i < arr.length; i++) {
		max = Math.max(max, arr[i]);
	}
	int[] count = new int[max + 1];
	for (int i = 0; i < arr.length; i++) {
		count[arr[i]]++;
	}
	for (int i = 1; i < max + 1; i++) {
		count[i] += count[i - 1];
	}
	int[] sortedArr = new int[arr.length];
	for (int i = arr.length - 1; i >= 0; i--) {
		sortedArr[--count[arr[i]]] = arr[i];
	}
	return sortedArr;
}

}
