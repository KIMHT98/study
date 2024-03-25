package day03_2tharray;
import java.util.Scanner;


public class Ladder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int T = sc.nextInt();
			int[][] arr = new int[100][100];
			int depr = 0;
			int depc = 0;
			//2차원 배열 생성
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					arr[r][c] = sc.nextInt();
					//도착지의 좌표값 구하기
					if (arr[r][c] == 2) {
						depr = r;
						depc = c;
					}
				}
			}
			depr--;//일단 한칸 올라와서 시작
			//맨 윗줄에 도착하면 반복 종료
			while (depr > 0) {
				//1번~98번일때
				if (depc < 99 && depc > 0) {
					//오른쪽이 1이면 쭉가는데 오른쪽이 0이 되거나 99열이 되면 위로
					if (arr[depr][depc + 1] == 1) {
						while (arr[depr][depc+1] > 0) {
							depc++;
							if (depc == 99) {
								depr--;
								break;
							}
						}
						//오른쪽으로 가는거 멈추면 한칸 위로
						depr--;
					}
					//왼쪽이 1이면 쭉가는데 왼쪽이 0이 되거나 0열이 되면 위로
					else if (arr[depr][depc - 1] == 1) {
						while (arr[depr][depc-1] > 0) {
							depc--;
							if (depc == 0) {
								depr--;
								break;
							}
						}
						//왼쪽으로 가는거 멈추면 한칸 위로
						depr--;
					}
					//양쪽이 0이면 그냥 위로만 간다
					else
						depr--;

				} 
				//첫열인 경우 오른쪽이 1이면 쭉가다가 오른쪽이 0이건 99열이면 위로
				else if (depc == 0) {
					if (arr[depr][depc + 1] == 1) {
						while (arr[depr][depc+1] > 0) {
							depc++;
							if (depc == 99) {
								depr--;
								break;
							}
						}
						depr--;
					} else
						depr--;
				} 
				//마지막 열인 경우 왼쪽이 1이면 쭉가다가 왼쪽이 0이거나 첫열이면 위로
				else {
					if (arr[depr][depc - 1] == 1) {
						while (arr[depr][depc-1] > 0) {
							depc--;
							if (depc == 0) {
								depr--;
								break;
							}
						}
						depr--;
					} else
						depr--;

				}

			}
			System.out.printf("#%d %d",t,depc);
			System.out.println();

		}
	}

}
//조건을 잘 못 걸겠네..
