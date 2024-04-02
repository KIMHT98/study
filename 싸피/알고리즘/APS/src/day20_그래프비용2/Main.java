package day20_그래프비용2;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<int[]> s = new Stack<>();
		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int[] now = new int[] {sc.nextInt(),1};
			while (!s.isEmpty() && now[0] > s.peek()[0]) {
				cnt++;
				now[1]++;
				s.pop();
		}if(s.isEmpty()) {
			s.add(now);
		}else {
			if(now[0]<s.peek()[0]) {
				cnt++;
				s.add(now);
			}else {
				s.peek()[1]++;
				cnt+=s.peek()[1];
			}
		}
		System.out.println(cnt);
	}
	}

}
