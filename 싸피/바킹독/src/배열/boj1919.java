package 배열;

import java.util.Scanner;

public class boj1919 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<b.length;j++) {
				if(a[i]==b[j]) {
					a[i]='1';
					b[j]='1';
					break;
					
				}
				
			}
		}int cnt = 0;
		for(int i=0;i<a.length;i++) {
			if(a[i]!='1')
				cnt++;
		}
		for(int i=0;i<b.length;i++) {
			if(b[i]!='1')
				cnt++;
		}
		System.out.println(cnt);
	}
}
