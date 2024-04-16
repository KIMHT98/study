package class3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 좌표압축 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int[][] points = new int[n][2];
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			points[i][0] = sc.nextInt();
			points[i][1] = i;
		}
		Arrays.sort(points, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[0] - o1[0];
			}
		});
		result[points[0][1]] = n-1;
		for (int i = 1; i < n; i++) {
			result[points[i][1]] = n - 1 - i;
			if (points[i][0] == points[i - 1][0]) {
				result[points[i][1]] = result[points[i - 1][1]];
			}
			
		}
		for (int i = 0; i < n; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}

}
