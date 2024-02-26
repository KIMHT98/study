package day6_stack2;
import java.util.Scanner;

public class 계산기1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int n = sc.nextInt();
			String str = sc.next();
			int sum = 0;
			for(int i=0;i<str.length();i+=2) {
				sum += str.charAt(i)-'0';
			}
			System.out.println("#"+t+" "+sum);
		}
	}
}
