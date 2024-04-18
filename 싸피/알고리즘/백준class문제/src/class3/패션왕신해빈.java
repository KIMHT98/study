package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 패션왕신해빈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			Map<String, List<String>> closet = new HashMap<>();
			int result = 1;
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				result = 0;
				sb.append(result).append("\n");
			} else {
				for (int N = 0; N < n; N++) {
					String[] arr = br.readLine().split(" ");
					if (closet.get(arr[1]) == null) {
						List<String> wear = new ArrayList<>();
						wear.add(arr[0]);
						closet.put(arr[1], wear);
					} else {
						closet.get(arr[1]).add(arr[0]);
					}
				}
				for(String s : closet.keySet()) {
					result *= (closet.get(s).size()+1);
				}
				sb.append(result-1).append("\n");
			}
		}
		System.out.println(sb);
	}

}
