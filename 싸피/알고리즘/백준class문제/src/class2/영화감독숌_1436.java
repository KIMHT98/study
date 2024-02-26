package class2;

import java.util.Scanner;

public class 영화감독숌_1436 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String pattern = "666";
		int cnt = 1;
		String num = "666";
		while(cnt<n) {
			num = Integer.toString(Integer.parseInt(num)+1);
			if(num.contains(pattern)) {
				cnt++;
			}
			
		}
		System.out.println(Integer.parseInt(num));
	}

}
