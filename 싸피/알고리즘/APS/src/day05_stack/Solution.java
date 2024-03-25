package day05_stack;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			String text = sc.next();
			char[] arr = text.toCharArray();
			int n = text.length();
			int cnt = 0;
			int sum = 0;
			for(int i=0;i<n;i++) {
				if(arr[i]=='(') {
					stack.push(arr[i]);
					cnt++;
				}else {
					if(arr[i-1]=='(') {
					stack.pop();
					sum += cnt--;
				}else {
					cnt--;
					stack.pop();
					
				}
			}
			}
			System.out.println("#"+t+" "+sum);
		}
	}

}
