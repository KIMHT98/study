package class1;

import java.util.Arrays;
import java.util.Scanner;

public class 알파벳찾기_10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		for(int i=0;i<str.length();i++) {
			if(arr[str.charAt(i)-'a']==-1) {
				arr[str.charAt(i)-'a']=i;
			}
		}
		for(int i=0;i<26;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
