package class3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 절댓값힙 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int a = Math.abs(o1);
				int b = Math.abs(o2);
				if(a==b) return o1-o2;
				return a-b;
			}
		});
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
