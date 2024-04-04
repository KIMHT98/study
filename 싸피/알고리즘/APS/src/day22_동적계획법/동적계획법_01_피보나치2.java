package day22_동적계획법;

import java.util.Arrays;
import java.util.Scanner;


public class 동적계획법_01_피보나치2 {
	static int[] callFibo;//i번쨰 항이 몇번 호출되는지 확인
	static int[] memo;//계산값을 저장하기 위한 공간을 할당하겠다.
	
	static {
		memo = new int[1000];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;
		//여기서 직접 계산을 다 해놓고 부를 수 있음
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//10
		
		callFibo = new int[N+1];//0~N까지
		System.out.println(fibo2(N));//55
		System.out.println(Arrays.toString(callFibo));//[1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1]
	}
	static int fibo2(int n) {
		callFibo[n]++;
		if(memo[n]==-1) {
			memo[n] = fibo2(n-1)+fibo2(n-2);
		}
		return memo[n];
	}

}
