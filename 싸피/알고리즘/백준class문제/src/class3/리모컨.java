package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 리모컨 {
	static int N, len, min;
	static int[] result,resultlower,resultupper;
	static boolean[] broken;

	static void search(int idx) {
		if (idx==len) {
			int num = 0;
			for (int i = len-1; i >= 0; i--) {
				num += result[i]*Math.pow(10, len-1-i);
			}
			min = Math.min(Math.abs(N - num)+ idx, min);
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (broken[i])
				continue;
			result[idx] = i;
			search(idx + 1);
			
		}
	}
	static void searchlower(int idx) {
		if (idx==len-1) {
			int num = 0;
			for (int i = len-2; i >= 0; i--) {
				num += resultlower[i]*Math.pow(10, len-2-i);
			}
			min = Math.min(Math.abs(N - num)+ idx, min);
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (broken[i])
				continue;
			resultlower[idx] = i;
			searchlower(idx + 1);
			
		}
	}
	static void searchupper(int idx) {
		if (idx==len+1) {
			int num = 0;
			for (int i = len; i >= 0; i--) {
				num += resultupper[i]*Math.pow(10, len-i);
			}
			min = Math.min(Math.abs(N - num)+ idx, min);
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (broken[i])
				continue;
			resultupper[idx] = i;
			searchupper(idx + 1);
			
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		len = str.length();
		N = Integer.parseInt(str);
		int M = Integer.parseInt(br.readLine());
		broken = new boolean[10];
		result = new int[len];
		resultlower = new int[len-1];
		resultupper = new int[len+1];
		String[] arr = null;
		//사용할 수 없는 버튼과 사용 가능한 버튼은 boolean으로 구분
		if (M > 0) {
			arr = br.readLine().split(" ");
			for (int i = 0; i < M; i++) {
				broken[Integer.parseInt(arr[i])] = true;
			}
		}
		min = Integer.MAX_VALUE;
		int now = 100;
		int cnt = 0;
		if (N != 100) {
			search(0);
			cnt = min;
			if(len>1) {
				searchlower(0);
				cnt = Math.min(min, cnt);
			}
			searchupper(0);
			cnt = Math.min(min, cnt);
			cnt = Math.min(Math.abs(now-N), cnt);
		}
		System.out.println(cnt);

	}

}
