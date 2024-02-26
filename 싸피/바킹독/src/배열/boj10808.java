package 배열;

import java.util.Arrays;
import java.util.Scanner;

public class boj10808 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		int[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int[] arr = new int[26];
		for(int i = 0;i<word.length();i++) {
			arr[indexOf(alphabet,word.charAt(i))]++;
		}
		for(int i = 0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	private static int indexOf(int[] arr, char target) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==target) {
				return i;
			}
		}
		return -1;
	}

}
