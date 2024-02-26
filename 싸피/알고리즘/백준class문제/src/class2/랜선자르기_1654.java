package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 랜선자르기_1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int k = Integer.parseInt(s[0]);
		int n = Integer.parseInt(s[1]);
		int[] arr = new int[k];
		int max = Integer.MIN_VALUE;
		for(int i=0;i<k;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		long start = 1;
		long end = max;
		long answer = 0;
		while(start<=end) {
			long mid = (start+end)/2;
			long sum = 0;
			for(int i=0;i<k;i++) {
				sum += (arr[i]/mid);
			}
			if(sum >= n) {
				start = mid+1;
				answer = mid;
			}else {
				end = mid-1;
			}
		}
		System.out.println(answer);
		
	}
	

}
