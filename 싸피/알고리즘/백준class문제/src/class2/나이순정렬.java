package class2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 나이순정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[][] arr = new String[n][3];
		for (int i = 0; i < n; i++) {
			arr[i][0] = Integer.toString(i);
			arr[i][1] = sc.next();
			arr[i][2] = sc.next();
		}
		Arrays.sort(arr, new Comparator<String[]>() {

			@Override
			public int compare(String[] a1, String[] a2) {
				if (a1[1].equals(a2[1])) {
					return Integer.parseInt(a1[0]) - Integer.parseInt(a2[0]);
				}
				return Integer.parseInt(a1[1])-Integer.parseInt(a2[1]);
			}
		});
		for(int i=0;i<n;i++) {
			System.out.println(arr[i][1]+" "+arr[i][2]);
		}
	}

}
