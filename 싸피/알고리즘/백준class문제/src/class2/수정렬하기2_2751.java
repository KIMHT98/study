package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기2_2751 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[1000001][2];
		int min = 1000000;
		for (int i = 0; i < n; i++) {
			int N = Integer.parseInt(br.readLine());
			min = Math.min(min, N);
			if (N >= 0)
				arr[N][0]++;
			else
				arr[Math.abs(N)][1]++;
		}
		if (min < 0) {
			for (int i = 1000000; i >= 0; i--) {
				if (arr[i][1] != 0) {
					sb.append(-i).append("\n");
				}
			}
			for (int i = 0; i < 1000001; i++) {
				if (arr[i][0] != 0)
					sb.append(i).append("\n");
			}
		} else {
			for (int i = 0; i < 1000001; i++) {
				if (arr[i][0] != 0)
					sb.append(i).append("\n");
			}
		}
		System.out.println(sb);

	}

}
