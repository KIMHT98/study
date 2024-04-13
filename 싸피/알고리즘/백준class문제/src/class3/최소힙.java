package class3;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 최소힙 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			int now = sc.nextInt();
			switch(now) {
			case 0:
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				}else {
					sb.append(pq.poll()).append("\n");
				}
				break;
			default :
				pq.add(now);
			}
		}
		System.out.println(sb);
	}

}
