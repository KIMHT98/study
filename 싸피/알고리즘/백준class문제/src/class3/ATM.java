package class3;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] line = new int[N];
		for(int i=0;i<N;i++) {
			line[i] = sc.nextInt();
		}
		Arrays.sort(line);
		for(int i=1;i<N;i++) {
			line[i]+=line[i-1];
		}
		int result = 0;
		for(int i=0;i<N;i++) {
			result+=line[i];
		}
		System.out.println(result);
	}

}
