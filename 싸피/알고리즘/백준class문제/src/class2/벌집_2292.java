package class2;

import java.util.Scanner;

public class 벌집_2292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n==1) {
			System.out.println(1);
		}else {
			int min = 2;
			int max = 7;
			int degree = 1;
			while(true) {
				if(n>=min&&n<=max) {
					System.out.println(degree+1);
					break;
				}
				degree++;
				min += 6*(degree-1);
				max += 6*degree;
			}
		}
	}

}
