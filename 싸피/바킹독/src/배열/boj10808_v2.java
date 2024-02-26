package 배열;

import java.util.Arrays;
import java.util.Scanner;

public class boj10808_v2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] word = sc.next().toCharArray();
		int[] arr = new int[26];
		for(char c:word) {
			arr[c-'a']++;
		}
		for(int i = 0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
