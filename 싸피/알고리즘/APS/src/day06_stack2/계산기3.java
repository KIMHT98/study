package day06_stack2;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class 계산기3 {

	public static void main(String[] args) {
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('(', 0);
		priority.put('+', 1);
		priority.put('*', 2);
		Scanner sc = new Scanner(System.in);
		Stack<Character> op = new Stack<>();
		Stack<Integer> nums = new Stack<>();
		for(int t=1;t<=10;t++) {
			int n = sc.nextInt();
			String expression = sc.next();
			String postfix = "";
			for(int i=0;i<expression.length();i++) {
				char c = expression.charAt(i);
				if(c=='(') {
					op.push(c);
				}else if(c<='9'&&c>='0') {
					postfix += c;
				}else if(c == ')') {
					while(op.peek() != '(') {
						postfix += op.pop();
					}
					op.pop();
				}else {
					if(op.isEmpty()) {
						op.push(c);
					}else {
						while(!op.isEmpty()&&priority.get(c)<=priority.get(op.peek())) {
							postfix += op.pop();
						}op.push(c);
						
					}
				}
			}
			while(!op.isEmpty()) {
				postfix+=op.pop();
			}
			for(int i=0; i<postfix.length();i++) {
				char c = postfix.charAt(i);
				if(c>='0'&&c<='9') {
					nums.push(c-'0');
				}else {
					nums.push(calculator(nums.pop(),nums.pop(),c));
				}
				
			
		}
			System.out.println("#"+t+" "+nums.pop());
	}
	
	}
	public static int calculator(int a, int b, char op) {
		switch(op) {
		case '+':
			return b+a;
		case '*':
			return b*a;
		}return -1;
		}

}
