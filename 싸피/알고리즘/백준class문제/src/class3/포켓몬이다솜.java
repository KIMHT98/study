package class3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 포켓몬이다솜 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String,Integer> dogamS = new HashMap<>();
		Map<Integer,String> dogamI = new HashMap<>();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		for(int i=1;i<=N;i++) {
			String monster = sc.next();
			dogamS.put(monster, i);
			dogamI.put(i, monster);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			String now = sc.next();
			try {
				sb.append(dogamI.get(Integer.parseInt(now))).append("\n");
			}catch(NumberFormatException e) {
				sb.append(dogamS.get(now)).append("\n");
			}
			
		}
		System.out.println(sb);
		
	}

}
