package class4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 치킨배달_15686 {
	static class Home{
		int row, col;
		Home(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	static int N,M,min;
	static List<Home> home, chicken;
	static Home[] sel;
	
	static void comb(int idx, int sidx) {
		int sum = 0;
		if(sidx==M) {
			int s1 = home.size();
			for(int i=0;i<s1;i++) {
				int dist = 1000;
				Home nowHome = home.get(i);
				for(int j=0;j<M;j++) {
					Home nowChicken = sel[j];
					dist = Math.min(dist,Math.abs(nowHome.row-nowChicken.row)+Math.abs(nowHome.col-nowChicken.col));
				}
				sum+=dist;
				if(sum>=min)return;
			}
			min = Math.min(sum, min);
			return;
		}
		else if(idx>=chicken.size())return;
		else {
			sel[sidx] = chicken.get(idx);
			comb(idx+1,sidx+1);
			comb(idx+1,sidx);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new Home[M];
		min = Integer.MAX_VALUE;
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) {
				int now = sc.nextInt();
				if(now == 0) continue;
				else if(now==1) {
					home.add(new Home(r,c));
				}else {
					chicken.add(new Home(r,c));
				}
			}
		}
		comb(0,0);
		System.out.println(min);
		
	}

}
