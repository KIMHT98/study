package day07_Queue;
import java.util.Scanner;

public class 준홍이카드놀이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int result = 0;
			if(n==m) {
				System.out.println("#"+t+" "+(n+1));
			}else {
				System.out.print("#"+t+" ");
				for(int i = Math.min(n, m)+1;i<=Math.max(n, m)+1;i++) {
					System.out.print(i+" ");
				}
				System.out.println();
			}
		}
	}

}
