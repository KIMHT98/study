package day19_그래프비용;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 별자리만들기 {
	static int[] p;
	static class star{
		double x, y;

		public star(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static class Edge{
		int s, e;
		double dist;
		public Edge(int s, int e, double dist) {
			super();
			this.s = s;
			this.e = e;
			this.dist = dist;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		star[] stars = new star[n];
		int size = n*(n-1)/2;
		Edge[] edges = new Edge[size];
		for(int i=0;i<n;i++) {
			stars[i] = new star(sc.nextDouble(),sc.nextDouble());
		}
		int idx = 0;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				edges[idx] = new Edge(i,j,Math.sqrt(Math.pow(stars[i].x-stars[j].x, 2)+Math.pow(stars[i].y-stars[j].y, 2)));
				idx++;
			}
		}
		Arrays.sort(edges, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				 if (o1.dist < o2.dist) return -1;
			        else if (o1.dist > o2.dist) return 1;
			        else return 0;
			}
		});
		p = new int[size];
		for(int i=0;i<size;i++) {
			p[i] = i;
		}
		double ans = 0;
		int pick = 0;
		for(int i=0;i<size;i++) {
			int px = findset(edges[i].s);
			int py = findset(edges[i].e);
			if(px!=py) {
				union(px,py);
				ans+=edges[i].dist;
				pick++;
			}
			if(pick==size-1) {
				break;
			}
		}
		System.out.println(Math.round(ans*100)/100.0);
	}

	private static void union(int px, int py) {
		p[py] = px;
	}

	private static int findset(int s) {
		if(s!=p[s]) p[s] = findset(p[s]);
		return p[s];
	}

}
