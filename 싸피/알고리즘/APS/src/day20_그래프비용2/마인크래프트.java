package day20_그래프비용2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class 마인크래프트 {

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr1 = br.readLine().split(" ");
		int n = Integer.parseInt(arr1[0]);
		int m = Integer.parseInt(arr1[1]);
		int b = Integer.parseInt(arr1[2]);
		int size = n * m;
		int[] ground = new int[size];
		int min = 256;
		int max = 0;
		int idx = 0;
		for (int i = 0; i < n; i++) {
			String[] arr2 = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
			ground[idx] = Integer.parseInt(arr2[j]);
			min = Math.min(min, ground[idx]);
			max = Math.max(max, ground[idx]);
			idx++;
			}
		}
		Arrays.sort(ground);
		int sec = 0;
		int finalsec = Integer.MAX_VALUE;
		int maxH = Integer.MIN_VALUE;
		for (int h = min; h <= max; h++) {
			sec = 0;
			boolean isflat = true;
			int inventory = b;
			out: for (int i = size-1; i >=0; i--) {
					if (ground[i] == h)
						continue;
					else if (ground[i] > h) {
						sec += 2 * (ground[i] - h);
						inventory += (ground[i] - h);
					} else {
						inventory -= (h - ground[i]);
						if (inventory < 0) {
							isflat = false;
							break out;
						}
						sec += (h - ground[i]);
					}
			}
			if (isflat) {
				if (sec <= finalsec) {
					finalsec = sec;
					maxH = h;
				}
			}
		}
		System.out.println(finalsec + " " + maxH);

	}

}
