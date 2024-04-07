package A형대비;

import java.util.Arrays;
import java.util.Scanner;

public class 숫자만들기 {
	static int n, max, min;
	static int[] nums, op;

	static void perm(int idx, int sum, int add, int minus, int multiple, int divide) {
//		if(sum>=min && sum <= max)
		if (idx == n - 1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		if (add > 0)
			perm(idx + 1, sum + nums[idx + 1], add - 1, minus, multiple, divide);
		if (minus > 0) 
			perm(idx + 1, sum - nums[idx + 1], add, minus - 1, multiple, divide);
		if (multiple > 0)
			perm(idx + 1, sum * nums[idx + 1], add, minus, multiple - 1, divide);
		if (divide > 0)
			perm(idx + 1, sum / nums[idx + 1], add, minus, multiple, divide - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			nums = new int[n];
			op = new int[4];
			for (int i = 0; i < 4; i++) {
				op[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			perm(0,nums[0],op[0],op[1],op[2],op[3]);
//			System.out.println(Arrays.toString(op));
//			System.out.println(Arrays.toString(nums));
			System.out.println("#"+t+" "+(max-min));
		}

	}
}
