package class1;

import java.util.Scanner;

public class 나머지_3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] count = new int[42];
		for (int i = 0; i < 10; i++) {
			count[sc.nextInt() % 42]++;
		}
		int cnt = 0;
		for(int i=0;i<42;i++) {
			if(count[i]!=0) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
