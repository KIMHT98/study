package class1;

import java.util.Scanner;

public class 시험성적_9498 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		char result;
		if(score>=90) {
			result = 'A';
		}else if(score >=80) {
			result = 'B';
		}else if(score >= 70) {
			result = 'C';
		}else if(score >= 60) {
			result = 'D';
		}else {
			result = 'F';
		}
		System.out.println(result);
	}

}
