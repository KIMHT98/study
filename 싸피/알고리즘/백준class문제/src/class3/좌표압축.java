package class3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 좌표압축 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Map<Integer,Integer> map = new HashMap<>();
		int n = sc.nextInt();
		int[] origin = new int[n];
		int[] points = new int[n];
		for (int i = 0; i < n; i++) {
			points[i] = sc.nextInt();
			origin[i] = points[i];
		}
		points = Arrays.stream(points).distinct().toArray();
		Arrays.sort(points);
		for(int i=points.length-1;i>=0;i--) {
			map.put(points[i], i);
		}
		for (int i = 0; i < n; i++) {
			sb.append(map.get(origin[i])).append(" ");
		}
		System.out.println(sb);
	}

}
