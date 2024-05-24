package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 뱀과사다리게임 {
	static int n,m;
	static int[][] N,M;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr1 = br.readLine().split(" ");
		n = Integer.parseInt(arr1[0]);
		m = Integer.parseInt(arr1[1]);
		N = new int[n][2];
		M = new int[m][2];
		for(int i=0;i<n;i++) {
			String[] arr2 = br.readLine().split(" ");
			N[i][0] = Integer.parseInt(arr2[0]);
			N[i][1] = Integer.parseInt(arr2[1]);
		}
		for(int i=0;i<m;i++) {
			String[] arr3 = br.readLine().split(" ");
			M[i][0] = Integer.parseInt(arr3[0]);
			M[i][1] = Integer.parseInt(arr3[1]);
		}
		
	}

}
