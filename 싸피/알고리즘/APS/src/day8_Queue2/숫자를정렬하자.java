package day8_Queue2;
import java.util.Scanner;

public class 숫자를정렬하자 {
	

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			for(int i=1;i<n;i++) {
				int key = arr[i];
				for(int j=i-1;j>=0;j--)
					if(arr[j]>key) {
						arr[j+1]=arr[j];
						arr[j]=key;
					}
			}
			System.out.print("#"+t+" ");
			for(int i=0;i<n;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}

}
