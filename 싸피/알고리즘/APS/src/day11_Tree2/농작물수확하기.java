package day11_Tree2;
import java.util.Scanner;

public class 농작물수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n = sc.nextInt();
			char[][]map = new char[n][n];
			for(int r =0;r<n;r++) {
					map[r] = sc.next().toCharArray(); 
				}
				int sum = 0;
				for(int c=0;c<n;c++) {
					if(c<=n/2) {
					for(int r=n/2-c;r<=n/2+c;r++) {
						sum += (map[r][c]-'0');
					}
					}else {
						for(int r= c-(n/2);r<n-c+n/2;r++) {
							sum+=(map[r][c]-'0');
						}
				}
			}
				System.out.println("#"+t+" "+sum);
		}
	}
}
