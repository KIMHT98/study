package day20_그래프비용2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 보급로 {
	static int N, INF = Integer.MAX_VALUE,result;
	static int[][] dist,ground;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	

	static class Node implements Comparable<Node> {
		int r,c, w;

		public Node(int r,int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", w=" + w + "]";
		}
		
	}

	static void dijkstra(int srow, int scol) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[][] visit = new boolean[N][N];

		dist[srow][scol] = 0;
		pq.add(new Node(srow,scol, 0));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if(curr.r==N-1 && curr.c == N-1) {
				result = curr.w;
			}
			if (visit[curr.r][curr.c])
				continue;
			visit[curr.r][curr.c] = true;

			for (int i=0;i<4;i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c +dc[i];
				if (nr>=0&&nr<N&&nc>=0&&nc<N&&!visit[nr][nc] && dist[nr][nc] > dist[curr.r][curr.c] + ground[nr][nc]) {
					dist[nr][nc] = dist[curr.r][curr.c] + ground[nr][nc];
					pq.add(new Node(nr, nc,dist[nr][nc]));
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb= new StringBuilder();
			N = Integer.parseInt(br.readLine());
			ground = new int[N][N];
			dist = new int[N][N];
			for (int r = 0; r < N; r++) {
				String str = br.readLine();
				for (int c = 0; c < N; c++) {
					dist[r][c] = INF;
					ground[r][c] = str.charAt(c)-'0';
				}
			}
			result = 0;
			dijkstra(0,0);
			sb.append("#").append(t).append(" ").append(result);
			System.out.println(sb);
		}
	}

}
