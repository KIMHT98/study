package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
	static Map<Integer, Integer> checker;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int k = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> min = new PriorityQueue<>();
			PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
			checker = new HashMap<>();
			for (int i = 0; i < k; i++) {
				String[] arr = br.readLine().split(" ");
				if (arr[0].equals("I")) {
					int num = Integer.parseInt(arr[1]);
					min.add(num);
					max.add(num);
					checker.put(num, checker.getOrDefault(num, 0) + 1);
				} else {
					int type = Integer.parseInt(arr[1]);
					if (checker.isEmpty())
						continue;
					if (type == 1) {
						delete(max);
					} else {
						delete(min);
					}

				}
			}
			if (checker.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				int res = delete(max);
				sb.append(res).append(" ");
				if(!checker.isEmpty()) {
					res = delete(min);
				}
				sb.append(res).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static int delete(PriorityQueue<Integer> q) {
		int res = 0;
		while (true) {
			res = q.poll();

			int cnt = checker.getOrDefault(res, 0);
			if (cnt == 0)
				continue;

			if (cnt == 1)
				checker.remove(res);
			else
				checker.put(res, cnt - 1);
			break;
		}

		return res;
	}
}
