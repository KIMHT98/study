package day12_solve;

import java.util.Arrays;
import java.util.Scanner;

public class 정곤이의단조증가하는수 {
	static boolean isMonotone(int n) {
		String num = Integer.toString(n);
		if (num.length() == 1)
			return true;
		for (int i = 1; i < num.length(); i++) {
			if (num.charAt(i) - num.charAt(i - 1) < 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			int result = -1;
			for(int i = n-2;i>=0;i--) {
				for(int j = n-1;j>=i+1;j--) {
					int m = arr[i] * arr[j];
					if(isMonotone(m)) {
						result = Math.max(result, m);
						break;
					}
				}
			}
			System.out.println("#"+t+" "+result);
		}

	}

}
