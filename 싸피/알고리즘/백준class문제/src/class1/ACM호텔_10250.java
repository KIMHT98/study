package class1;

import java.util.Scanner;

public class ACM호텔_10250 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();
			if(n%h==0) {
				System.out.println(h*100+n/h);
			}else {
				System.out.println((n%h)*100+(n/h+1));
			}
		}
	}

}
