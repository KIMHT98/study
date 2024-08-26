package class4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 트리의지름_1967 {
	static class Node {
		int end, dist;

		public Node(int end, int dist) {
			this.end = end;
			this.dist = dist;
		}
	}

	static List<Node>[] nodeList;
	static int n, max, maxNode;
	static boolean[] visit;

	static void dfs(int root, int sum) {
		if (max < sum) {
			max = sum;
			maxNode = root;
		}
		for (Node a : nodeList[root]) {
			if (visit[a.end])
				continue;
			visit[a.end] = true;
			dfs(a.end, sum + a.dist);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		nodeList = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			nodeList[i] = new ArrayList<>();
		}
		for (int i = 1; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int dist = sc.nextInt();
			nodeList[start].add(new Node(end, dist));
			nodeList[end].add(new Node(start, dist));

		}
		max = 0;
		maxNode = 0;
		visit = new boolean[n + 1];
		visit[1] = true;
		dfs(1, 0);
		visit = new boolean[n + 1];
		visit[maxNode] = true;
		dfs(maxNode, 0);
		if (n == 1) {
			System.out.println(0);
		} else
			System.out.println(max);
	}

}
