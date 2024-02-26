package class1;

import java.util.Arrays;
import java.util.Scanner;

public class 단어공부_1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.next();
		text = text.toUpperCase();
		int[] count = new int[26];
		for(int i=0;i<text.length();i++) {
			count[text.charAt(i)-'A']++;
		}
//		System.out.println(Arrays.toString(count));
		int cnt = 0;
		int maxidx = 0;
		int max = 0;
		for(int i=0;i<count.length;i++) {
			max = Math.max(max, count[i]);
		}
//		System.out.println(max);
		for(int i=0;i<count.length;i++) {
			if(count[i]==max) {
				maxidx = i;
				cnt++;
			}
		}
		if(cnt > 1) {
			System.out.println('?');
		}else {
			System.out.println((char)('A'+maxidx));
		}
	}
}
