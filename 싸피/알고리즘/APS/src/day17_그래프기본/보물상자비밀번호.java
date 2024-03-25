package day17_그래프기본;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.TreeSet;

public class 보물상자비밀번호 {
	static int[] sortedArr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
//			Set<Integer> bag = new HashSet<>();
			TreeSet<Integer> bag = new TreeSet<>();
			Deque<Character> dq = new ArrayDeque<>();
			String str = sc.next();
			for(int i=0;i<N;i++) {
				dq.add(str.charAt(i));
			}
			for(int i=0;i<N/4;i++) {
				for(int n=0;n<N;n+=N/4) {
					String hexa ="";
					for(int j=0;j<N/4;j++) {
						hexa += dq.peekFirst();
						dq.addLast(dq.pollFirst());
					}
					bag.add(Integer.parseInt(hexa,16));
				}
				dq.addFirst(dq.pollLast());
			}
			  int count = 0;
	            int result = 0;
	            for (int num : bag.descendingSet()) {
	                count++;
	                if (count == K) {
	                    result = num;
	                    break;
	                }
	            }
	            System.out.println("#" + t + " " + result);

		}
	}


}
