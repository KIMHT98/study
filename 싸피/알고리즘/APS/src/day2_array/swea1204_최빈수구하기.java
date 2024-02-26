package day2_array;
import java.util.Arrays;
import java.util.Scanner;


public class swea1204_최빈수구하기 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=1;t<=T;t++) {
		int num = sc.nextInt();
		int[] score = new int[1000];
		int[] count = new int[101];
		for(int i =0;i<1000;i++) {
			score[i] = sc.nextInt(); 
		}
		for(int i=0;i<1000;i++) {
			count[score[i]]++;
		}
		int max = 0;
		int maxidx = 0;
		for(int i=0;i<101;i++) {
			if(count[i]>=max) {
				max = count[i];
				maxidx = i;
		}
		}
		System.out.printf("#%d %d",num,maxidx);
		System.out.println();
	}
}
}
