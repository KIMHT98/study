package class3;

import java.util.*;
import java.io.*;

public class 비밀번호찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr1 = br.readLine().split(" ");
		int N = Integer.parseInt(arr1[0]);
		int M = Integer.parseInt(arr1[1]);
		Map<String,String> map = new HashMap<>(); 
		for(int i=0;i<N;i++) {
			String[] arr2 = br.readLine().split(" ");
			map.put(arr2[0], arr2[1]);
		}
		for(int i=0;i<M;i++) {
			System.out.println(map.get(br.readLine()));
		}
		

	}

}
