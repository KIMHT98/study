package day6_stack2;

import java.util.Scanner;
import java.util.Stack;

public class 계산기1_v2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int n = sc.nextInt();
			String expression = sc.next();
			Stack<Character> op = new Stack<>();
			String postfix = "";
			for(int i = 0; i<expression.length();i++) {
				char c = expression.charAt(i);
				if(c=='+') {
					if(!op.isEmpty()&&op.peek()=='+') {
						postfix += c;
					}else {
						op.push(c);					}
				}else {
					postfix += c;
				}
			}
			postfix+=op.pop();
			Stack<Integer> nums = new Stack<>();
			for(int i=0;i<postfix.length();i++) {
				char c = postfix.charAt(i);
				if(c>='0'&&c<='9') {
					nums.push(c-'0');
				}else {
					int a = nums.pop();
					int b = nums.pop();
					nums.push(b+a);
				}
			}System.out.println("#"+t+" "+nums.pop());
		}
	}

}
