package class1;

import java.util.Scanner;

public class 알람시계_2884 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		if(m-45<0) {
			h--;
			if(h<0) {
				h+=24;
			}
			m = 60+(m-45);
		}else {
			m -=45;
		}
		System.out.printf("%d %d",h,m);

	}

}
