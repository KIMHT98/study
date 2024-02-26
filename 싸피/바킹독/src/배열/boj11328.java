package 배열;

import java.util.Arrays;
import java.util.Scanner;

public class boj11328 {
	public static void main(String[] args) {
		
	

	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		if(a.length==b.length) {
		int cnt = 0;
		for(int i=0;i<a.length;i++) {
			if(a[i]==b[i])
				cnt++;
		}
		if(cnt==a.length)
			System.out.println("Possible");
		else
			System.out.println("Impossible");
	}
		else
			System.out.println("Impossible");

}

}
}
