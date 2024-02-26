package class2;

import java.util.Scanner;

public class 분해합_2231 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean isgenerator = false;
		int generator = 0;
		while(!isgenerator) {
			int sum = generator;
			char[] arr = Integer.toString(generator).toCharArray();
			for(int i=0;i<arr.length;i++) {
				sum += (arr[i]-'0');
			}
			if(sum == n || generator == n) {
				isgenerator = true;
			}else {
				generator ++;
			}
		}
		System.out.println(generator==n?0:generator);
		
	}

}
