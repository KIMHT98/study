package class1;

import java.util.Scanner;

public class 윤년_2753 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		if(n%4==0 && n%100!=0) {
			result = 1;
		}else if(n%400==0) {
			result = 1;
		}else {
			result = 0;
		}
		System.out.println(result);
	}

}
