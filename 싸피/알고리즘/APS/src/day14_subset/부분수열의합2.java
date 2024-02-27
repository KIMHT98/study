package day14_subset;

import java.util.Scanner;
public class 부분수열의합2 {
    static int n,k;
    static int[] a;
    static boolean[] sel;
    static int cnt, sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++) {
            n = sc.nextInt();
            k = sc.nextInt();
            a = new int[n];
            sel = new boolean[n];
            for(int i=0;i<n;i++) {
                a[i] = sc.nextInt();
            }
            cnt = 0;
            cSum(0,0);
            System.out.println("#"+t+" "+cnt);
        }
    }
    static void cSum(int idx, int currentSum) {
        if (idx >= n) {
        	System.out.println(currentSum);
            if (currentSum == k) {
                cnt++;
            }
            return;
        }
        cSum(idx + 1, currentSum + a[idx]);
        cSum(idx + 1, currentSum);
    }
}