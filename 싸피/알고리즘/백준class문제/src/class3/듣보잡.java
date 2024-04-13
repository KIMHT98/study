package class3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 듣보잡 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int len = N+M;
		int size = 0;
		String[] name = new String[len];
		for(int i=0;i<len;i++) {
			name[i]= sc.next();
		}
		Arrays.sort(name);
		for(int i=0;i<len-1;i++) {
			if(name[i].equals(name[i+1])) {
				size++;
				sb.append(name[i]).append("\n");
			}
		}
		sb.insert(0, size+"\n");
		System.out.println(sb);
	}

}
