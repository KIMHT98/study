package class4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 거짓말 {
	static List<Integer>[] party;
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int t = sc.nextInt();
		int[] truth = new int[t];
			
			for(int i=0;i<t;i++) {
				truth[i] = sc.nextInt();
			}
		parent = new int[N+1];
		party = new ArrayList[M];
		for(int i=0;i<M;i++) {
			party[i] = new ArrayList<>();
			int partySize = sc.nextInt();
			for(int j=0;j<partySize;j++) {
				party[i].add(sc.nextInt());
			}
		}
		for(int i=0;i<=N;i++) {
			parent[i] = i;
		}
		for(int i=0;i<M;i++) {
			int firstMan = party[i].get(0);
			for(int j=1;j<party[i].size();j++) {
				union(firstMan,party[i].get(j));
			}
		}
		int cnt = 0;
		for(int i=0;i<M;i++) {
			int leader = party[i].get(0);
			boolean flag = true;
			for(int j=0;j<t;j++) {
				if(find(leader)==find(truth[j])) {
					flag = false;
					break;
				}
			}
			if(flag) cnt++;
		}
		System.out.println(cnt);
		
		
	}

	private static void union(int a, Integer b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[b] = a;
		}
	}

	private static int find(Integer a) {
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

}
