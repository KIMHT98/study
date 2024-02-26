package class1;

import java.util.Scanner;

public class ox퀴즈_8958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=-0;i<n;i++) {
			int score = 0;
			int sum = 0;
			String quiz = sc.next();
			for(int j=0;j<quiz.length();j++) {
				if(quiz.charAt(j)=='O') {
					score++;
				}else {
					score=0;
				}
				sum+=score;
				
			}
			System.out.println(sum);
		}
	}

}
