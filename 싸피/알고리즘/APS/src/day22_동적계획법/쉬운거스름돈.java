package day22_동적계획법;

import java.util.Scanner;

public class 쉬운거스름돈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] money = {5000,1000,500,100,50,10,5,1};
		StringBuilder sb  = new StringBuilder();
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append("\n");
			int N = sc.nextInt()/10;
			for(int i=0;i<8;i++) {
				sb.append(N/money[i]).append(" ");
				N %= money[i];
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
