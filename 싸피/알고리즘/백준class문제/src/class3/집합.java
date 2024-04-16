package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 집합 {
	static int minMax;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] S = new int[21];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			String[] arr = br.readLine().split(" ");
			String method = arr[0];
			int x=0;
			if(arr.length>1) {
			x = Integer.parseInt(arr[1]);
			}
			if(method.equals("add")) {
				if(S[x]==0)S[x]++;
			}else if(method.equals("remove")) {
				if(S[x]==1)S[x]--;
			}else if(method.equals("check")) {
				if(S[x]==1) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}else if(method.equals("toggle")) {
				if(S[x]==1)S[x]=0;
				else S[x]=1;
			}else if(method.equals("all")) {
				for(int j=1;j<=20;j++) {
					S[j]=1;
				}
			}else {
				for(int j=1;j<=20;j++) {
					S[j]=0;
				}
			}
		}
		System.out.println(sb);
	}

}
