package class2;

import java.util.Scanner;

public class 덩치_7568 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for(int i=0;i<n;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		for(int[] p:arr) {
			int rank = 1;
			for(int i=0;i<n;i++) {
				if(p[0]<arr[i][0]&&p[1]<arr[i][1]) {
					rank++;
				}
			}
			System.out.print(rank+" ");
		}

	}

}
