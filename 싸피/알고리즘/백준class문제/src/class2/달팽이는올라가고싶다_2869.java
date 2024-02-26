package class2;

import java.util.Scanner;

public class 달팽이는올라가고싶다_2869 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int v = sc.nextInt();
		int height = 0;
		int day = (v-b)%(a-b)==0?(v-b)/(a-b):(v-b)/(a-b)+1;
		
		System.out.println(day);

	}

}
