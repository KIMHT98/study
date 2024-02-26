package day6_stack2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class 계산기구현연습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//표현식(중위 표기법)
		String expression = sc.next();
		Map<Character, Integer> priority = new HashMap<>();
		//우선순위 설정 끝
		priority.put('(',0);
		priority.put('+',1);
		priority.put('-',1);
		priority.put('*',2);
		priority.put('/',2);
		//후위 표기식
		String postfix = "";
		//스택
		Stack<Character> op = new Stack<>();
		//이제 표현식 순회하면서 계산
		for(int i=0;i<expression.length();i++) {
			char c = expression.charAt(i);
			//c에 따라서 구현이 달라짐
			if(c=='(') {
				op.push(c);
			}else if(c==')') {
				while(op.peek() !='(') {
					postfix += op.pop();
				}
				op.pop();//'('뺴주기
			}else if(c>='0'&&c<='9') {
				postfix += c;
			}else {
				if(op.isEmpty()) {
					op.push(c);
				}else {
					while(!op.isEmpty()&&priority.get(c)<=priority.get(op.peek())) {
						postfix += op.pop();
					}
					op.push(c);
				}
			}
		}
		System.out.println(postfix);
		
	}

}
