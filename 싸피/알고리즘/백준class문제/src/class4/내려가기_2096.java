package class4;

import java.util.Scanner;

public class 내려가기_2096 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dpMax = new int[3];
		int[] dpMin = new int[3];
		for (int i = 0; i < 3; i++) {
			int n = sc.nextInt();
			dpMax[i] = n;
			dpMin[i] = n;
		}
		for (int i = 1; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			int beforeMax1 = dpMax[1];

			dpMax[1] = Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2])) + b;
			dpMax[0] = Math.max(dpMax[0], beforeMax1) + a;
			dpMax[2] = Math.max(beforeMax1, dpMax[2]) + c;
			int beforeMin1 = dpMin[1];

			dpMin[1] = Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2])) + b;
			dpMin[0] = Math.min(dpMin[0], beforeMin1) + a;
			dpMin[2] = Math.min(beforeMin1, dpMin[2]) + c;
		}
		System.out.println(Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2]))+" "+Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2])));
	}

}
