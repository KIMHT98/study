package day17_그래프기본;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 보물상자비밀번호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			Set<String> bag = new HashSet<>();
			Deque<Character> dq1 = new ArrayDeque<>();
			Deque<Character> dq2 = new ArrayDeque<>();
			Deque<Character> dq3 = new ArrayDeque<>();
			Deque<Character> dq4 = new ArrayDeque<>();
			char[][] arr = new char[4][N/4];
			String str = sc.next();
			for(int i=0;i<N/4;i++) {
				dq1.add(str.charAt(i));
			}
			System.out.println(dq1.toString());
			for(int i=N/4;i<N/2;i++) {
				dq2.add(str.charAt(i));
			}
			for(int i=N/2;i<N/4*3;i++) {
				dq3.add(str.charAt(i));
			}
			for(int i=N/4*3;i<N;i++) {
				dq4.add(str.charAt(i));
			}
			for(int i=0;i<N/4;i++) {
				
			}
			
		}
	}

}
