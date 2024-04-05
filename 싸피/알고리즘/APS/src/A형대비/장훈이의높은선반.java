package A형대비;

import java.util.Scanner;

public class 장훈이의높은선반 {
	static int min;
	static int[] arr, result;

	static void subset(int idx, int n, int B) {
		if (idx == n) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (result[i] == 1) {
					sum += arr[i];
				}
			}
			if (sum - B >= 0) {
				min = Math.min(sum - B, min);
			}
			return;
		}
		result[idx] = 0;
		subset(idx + 1, n, B);
		result[idx] = 1;
		subset(idx + 1, n, B);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int B = sc.nextInt();
			arr = new int[N];
			result = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			min = Integer.MAX_VALUE;
//			비트마스킹
//			for(int i=1;i<1<<N;i++) {//i는 모든 부분집합
//				int sum = 0;
//				for(int j=0;j<N;j++) {//i라고 하는 탑에 누구누구를 쌓았는지 확인
//					if((i&(1<<j))>0) {//j번째 직원은 탑에 소속되어 있음
//						sum+=arr[j];
//					}
//				}//i번째 탑의 노핑 다 구함
//			if(sum>=B && sum<min) {
//				min = sum;
//			}
//			if(sum >= B) {
//				min = Math.min(min, sum);
//			}
//			}
			
			subset(0, N, B);
			System.out.println("#" + t + " " + min);
		}
	}

}
