package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 카잉달력 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			String[] arr = br.readLine().split(" ");
			int M = Integer.parseInt(arr[0]);
			int N = Integer.parseInt(arr[1]);
			int x = Integer.parseInt(arr[2]);
			int y = Integer.parseInt(arr[3]);
			int cnt = 0;
			boolean possible = false;
			if (M > N) {
				if (x == y) {
					cnt = x;
					possible = true;
				}
				else {
					int n = y;
					cnt = y;
					while (true) {
						n = (n + N - M)<=0?n+N:n+N-M;
						cnt += N;
						if (n == x) {
							possible = true;
							break;
						}
						if(n==y) break;
					}
				}
			} else if (M < N) {
				if (x == y) {
					cnt = x;
					possible = true;
				}
				else {
					int n = x;
					cnt = x;
					while (true) {
						n = (n + M - N)<=0?n+M:n+M-N;
						cnt += M;
						if (n == y) {
							possible = true;
							break;
						}
						if(n==x)break;
					}
				}
			} else {
				if (x == y) {
					cnt = x;
					possible = true;					
				}
			}
			if (!possible)
				cnt = -1;
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
