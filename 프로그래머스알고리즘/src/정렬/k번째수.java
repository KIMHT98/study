package 정렬;

import java.util.Arrays;

public class k번째수 {
	public static int[] solution(int[] array, int[][] commands) {
		int N = commands.length;
		int[] answer = new int[N];
		for (int n = 0; n < N; n++) {
			int i = commands[n][0];
			int j = commands[n][1];
			int k = commands[n][2];
			int[] subarr = new int[j - i + 1];
			int idx = 0;
			for (int p = i - 1; p < j; p++) {
				subarr[idx] = array[p];
				idx++;
			}
			for (int r = 0; r < k; r++) {
				int minidx = r;
				for (int c = r + 1; c < idx; c++) {
					if (subarr[minidx] > subarr[c]) {
						minidx = c;
					}
				}
				int tmp = subarr[r];
				subarr[r] = subarr[minidx];
				subarr[minidx] = tmp;
			}
			answer[n] = subarr[k - 1];

		}
		return answer;
	}
	public static void main(String[] args) {
		int[] arr= {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		System.out.println(Arrays.toString(solution(arr,commands)));
	}

}
