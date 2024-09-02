package class4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class A_B_16953 {
	static int A,B;
	static Set<Long> visit;
	static long bfs(long start, long end) {
		Queue<long[]> q = new LinkedList<>();
		visit = new HashSet<>();
		q.add(new long[] {start,1});
		visit.add(start);
		while(!q.isEmpty()) {
			long[] curr = q.poll();
			if(curr[0]==end) {
				return curr[1];
			}
			long n1 = curr[0]*2;
			if(n1<=end && !visit.contains(n1)) {
					q.add(new long[] {n1, curr[1]+1});
					visit.add(n1);
			}
			long n2 = curr[0]*10+1;
			if(n2<=end && !visit.contains(n2)) {
					q.add(new long[] {n2,curr[1]+1});
					visit.add(n2);
			}
		}
		return -1;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		System.out.println(bfs(A,B));
	}

}
