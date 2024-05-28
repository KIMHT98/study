package A형대비;

import java.util.Scanner;

public class 벌꿀채취 {
	static int N, M, C, result, max;
	static int[][] box, copy;
	static boolean[] sel;

	// box복사
	static void boxCopy() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				box[r][c] = copy[r][c];
			}
		}
	}

	// A탐색
	static void searchA() {
		int honeyA = 0;//A에서 짤 수 있는 꿀 양
		int[] A = new int[M];//A의 벌통 들 정보
		for (int r = 0; r < N; r++) {
			for (int c = 0; c <= N - M; c++) {
				honeyA = 0;
				for (int i = 0; i < M; i++) {
					A[i] = box[r][c + i];//M개의 벌통들 정보를 담는다.
					box[r][c + i] = 0;//A가 가져간 것들은 일단 0으로 표기
				}
				max = 0;//A가 가져갈 최대 꿀 양
				findMax(A,0);//최대 꿀 양 계산
				honeyA = max ;
				int honeyB = searchB();//A가 가져간 곳 제외하고 B가 탐색
				result = Math.max(result, honeyB + honeyA);
				boxCopy();//다시 원상복구
			}
		}
	}

	// B탐색
	static int searchB() {
		int honeyB = 0;//B가 가져갈 꿀 양
		int[] B = new int[M];//B의 벌통들 정보
		int maxB = 0;
		for (int r = 0; r < N; r++) {
			out: for (int c = 0; c <= N - M; c++) {
				honeyB = 0;
				for (int i = 0; i < M; i++) {
					//이미 A가 가져간 곳구역은 패스
					if (box[r][c + i] == 0) {
						honeyB = 0;
						continue out;
					}
					//B벌통들 정보 넣기
					B[i] = box[r][c + i];
				}
				max = 0;
				findMax(B,0);//최대 꿀 양 계산
				honeyB = max ;
				maxB = Math.max(maxB, honeyB);

			}
		}
		return maxB;
	}

	// 배열 내에서 제곱의 합이 가장 큰 값 찾기(부분집합 이용)
	static void findMax(int[] arr, int idx) {
		if (idx == M) {
			int sum = 0;
			int profit = 0;
			//1~M까지 돌면서 최대 꿀양 계산
			for (int i = 0; i < M; i++) {
				if(sel[i]) {
					sum+=arr[i];
					//C넘으면 리턴
					if(sum>C) {
						return;
					}
					profit += arr[i]*arr[i];
				}
			}
			max = Math.max(profit, max);
			return;
		}
		sel[idx] = false;
		findMax(arr, idx+1);
		sel[idx] = true;
		findMax(arr,idx+1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();//벌통 크기
			M = sc.nextInt();//벌통 개수
			C = sc.nextInt();//최대 꿀 양
			box = new int[N][N];//벌통들 정보
			copy = new int[N][N];//복사용
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					box[r][c] = sc.nextInt();
					copy[r][c] = box[r][c];
				}
			}
			result = 0;
			sel = new boolean[M];//부분집합 뽑기용
			searchA();//A탐색 -> B는 이 안에서 탐색됨
			System.out.println("#" + t + " " + result);

		}
	}

}
