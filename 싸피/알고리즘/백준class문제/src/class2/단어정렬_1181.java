package class2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 단어정렬_1181 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = new String[sc.nextInt()];
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.next();
		}
		Arrays.sort(arr,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()==o2.length()) {
					for(int i=0;i<o1.length();i++) {
						char c1 = o1.charAt(i);
						char c2 = o2.charAt(i);
						if(c1!= c2) {
							return c1-c2;
						}
					}
//					return 0;
				}
				return o1.length()-o2.length();
			}
		});
		for(int i=0;i<arr.length;i++) {
			if(i>0&&arr[i].equals(arr[i-1])) {
				continue;
			}
			System.out.println(arr[i]);
		}

	}

}
