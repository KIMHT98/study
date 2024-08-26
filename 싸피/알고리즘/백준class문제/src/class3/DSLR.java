package class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSLR {
	static boolean[] visit;
	static String[] arr;
	static void bfs(int A, int B) {
		Queue<Integer> q = new LinkedList<>();
		q.add(A);
		visit[A] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(curr == B)return;
			
			int D = 2*curr % 10000;
			if(!visit[D]) {
				q.add(D);
				arr[D]=arr[curr]+'D';
				visit[D] = true;
			}
			int S = curr==0?9999:curr-1;
			if(!visit[S]) {
				q.add(S);
				arr[S]=arr[curr]+'S';
				visit[S] = true;
			}
			int L = curr % 1000 * 10 + curr/1000;
			if(!visit[L]) {
				q.add(L);
				arr[L]=arr[curr]+'L';
				visit[L] = true;
			}
			int R = curr % 10 * 1000 + curr / 10;
			if(!visit[R]) {
				q.add(R);
				arr[R]=arr[curr]+'R';
				visit[R] = true;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int t=0;t<T;t++) { 
			int A = sc.nextInt();
			int B = sc.nextInt();
			arr = new String[10000];
			for(int i=0;i<10000;i++) {
				arr[i] = "";
			}
			visit = new boolean[10000];
			bfs(A,B);
			System.out.println(arr[B]);
			
		}
	}

}
