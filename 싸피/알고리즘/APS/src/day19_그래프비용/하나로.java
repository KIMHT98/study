package day19_그래프비용;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 하나로 {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1;t<=T;t++) {
			//세팅
			int N = sc.nextInt();//정점 개수
			List<double[]> edges = new ArrayList<>();//간선 넣을 곳
			double[] x = new double[N];//x좌표
			double[] y = new double[N];//y좌표
			for(int i=0;i<N;i++) {
				x[i] = sc.nextDouble();
			}
			for(int i=0;i<N;i++) {
				y[i] = sc.nextDouble();
			}
			double E = sc.nextDouble();//세율
			//간선 만들기 -> 모든 경우의 수
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					//가중치(거리)
					double dist = Math.pow(x[i]-x[j], 2)+Math.pow(y[i]-y[j],2);
					edges.add(new double[] {i,j,dist});
				}
			}
			//1단계 : 가중치 기준으로 오름차순
			Collections.sort(edges,new Comparator<double[]>() {

				@Override
				public int compare(double[] o1, double[] o2) {
					return (int) (o1[2]-o2[2]);
				}
			});
			//2단계 : N-1개의 간선 뽑기
			p = new int[N];
			for(int i=0;i<N;i++) {
				p[i] = i;
			}
			double ans = 0;//최소 비용의 합
			int pick = 0;//내가 뽑은 간선의 수
			
			for(int i=0;i<edges.size();i++) {
				int px = findset((int)edges.get(i)[0]);
				int py = findset((int)edges.get(i)[1]);
				
				if(px != py) {
					union(px,py);
					ans+= edges.get(i)[2];
					pick++;
				}
				if(pick==N-1) {
					break;
				}
			}
			System.out.println("#"+t+" "+Math.round(ans*E));
		}
	}

	static void union(int px, int py) {
		p[py] = px;
	}

	static int findset(int x) {
		if(x != p[x]) p[x] = findset(p[x]);
		return p[x];
		
	}

}
