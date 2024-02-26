package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 숫자카드2_10816 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String[] line = br.readLine().split(" ");
		HashMap<Integer,Integer> cardcnt = new HashMap<>();
		int max = -1;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(line[i]);
			cardcnt.put(num, cardcnt.getOrDefault(num, 0)+1);
		}

		int m = Integer.parseInt(br.readLine());
		String[] line2 = br.readLine().split(" ");
		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(line2[i]);
			int count = cardcnt.getOrDefault(target, 0);
			sb.append(count).append(" ");
		}
		System.out.println(sb);
	}

}

