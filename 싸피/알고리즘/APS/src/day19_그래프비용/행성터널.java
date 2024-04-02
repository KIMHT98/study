package day19_그래프비용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 행성터널 {
	static int[] p;
	static class point{
		int num,x,y,z;

		public point(int num, int x, int y, int z) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static class Edge{
		int start, end, w;

		public Edge(int start, int end, int w) {
			this.start = start;
			this.end = end;
			this.w = w;
		}
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		point[] points = new point[N]; 
		List<Edge> edges = new ArrayList<>();
		for(int i=0;i<N;i++) {
			String[] arr = br.readLine().split(" ");
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);
			int z = Integer.parseInt(arr[2]);
			points[i] = new point(i,x,y,z);
		}
		Arrays.sort(points, new Comparator<point>() {

			@Override
			public int compare(point o1, point o2) {
				// TODO Auto-generated method stub
				return o1.x-o2.x;
			}
		});
		for(int i=1;i<N;i++) {
			edges.add(new Edge(points[i-1].num,points[i].num,Math.abs(points[i-1].x-points[i].x)));
		}
		Arrays.sort(points, new Comparator<point>() {

			@Override
			public int compare(point o1, point o2) {
				// TODO Auto-generated method stub
				return o1.y-o2.y;
			}
		});
		for(int i=1;i<N;i++) {
			edges.add(new Edge(points[i-1].num,points[i].num,Math.abs(points[i-1].y-points[i].y)));
		}
		Arrays.sort(points, new Comparator<point>() {

			@Override
			public int compare(point o1, point o2) {
				// TODO Auto-generated method stub
				return o1.z-o2.z;
			}
		});
		for(int i=1;i<N;i++) {
			edges.add(new Edge(points[i-1].num,points[i].num,Math.abs(points[i-1].z-points[i].z)));
		}
		Collections.sort(edges, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.w-o2.w;
			}
		});
		p = new int[N];
		for(int i=0;i<N;i++) {
			p[i]=i;
		}
		int ans = 0;
		int pick = 0;
		for(int i=0;i<edges.size();i++) {
			int px = findset(edges.get(i).start);
			int py = findset(edges.get(i).end);
			
			if(px!=py) {
				p[py] = px;
				ans+=edges.get(i).w;
				pick++;
			}
			if(pick == N-1)break;
		}
		System.out.println(ans);
		
	}
	static int findset(int x) {
		if(x != p[x]) p[x] = findset(p[x]);
		return p[x];
	}

}
