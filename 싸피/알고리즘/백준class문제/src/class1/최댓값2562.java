package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최댓값2562 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int max = 0;
		int maxidx = 0;
		for(int i=0;i<9;i++) {
			if(arr[i]>max) {
				max = arr[i];
				maxidx = i+1;
			}
		}
		System.out.println(max);
		System.out.println(maxidx);

	}

}
