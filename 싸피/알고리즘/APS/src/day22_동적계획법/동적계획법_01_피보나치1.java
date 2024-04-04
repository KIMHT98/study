package day22_동적계획법;

import java.util.Arrays;
import java.util.Scanner;


public class 동적계획법_01_피보나치1 {
	static int[] callFibo;//i번쨰 항이 몇번 호출되는지 확인

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//10
		callFibo = new int[N+1];//0~N까지
		System.out.println(fibo1(N));//55
		System.out.println(Arrays.toString(callFibo));//[34, 55, 34, 21, 13, 8, 5, 3, 2, 1, 1]
	}

	static int fibo1(int n) {
		callFibo[n]++;
		if (n <= 1)
			return n;
		return fibo1(n - 2) + fibo1(n - 1);
	}

}
