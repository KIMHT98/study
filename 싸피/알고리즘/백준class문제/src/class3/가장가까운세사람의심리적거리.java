package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가장가까운세사람의심리적거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			String[] mbti = br.readLine().split(" ");
			if(N>32) {
				sb.append(0).append("\n");
				continue;
			}
			int result = Integer.MAX_VALUE;
			out: for(int i=0;i<N-2;i++) {
				for(int j=i+1;j<N-1;j++) {
					for(int k=j+1;k<N;k++) {
						int cnt = 0;
						for(int m=0;m<4;m++) {
							cnt += mbti[i].charAt(m)==mbti[j].charAt(m)?0:1;
							cnt += mbti[i].charAt(m)==mbti[k].charAt(m)?0:1;
							cnt += mbti[j].charAt(m)==mbti[k].charAt(m)?0:1;
						}
						result = Math.min(result, cnt);
						if(result == 0 ) break out;
					}
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
