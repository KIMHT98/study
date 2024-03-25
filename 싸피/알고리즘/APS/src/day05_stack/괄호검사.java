package day05_stack;

import java.util.Stack;

public class 괄호검사 {
	public static void main(String[] args) {
		//소괄호 () 만 있는 경우
		String text = "((()))";//"()()((()))";

		Stack<Character> stack = new Stack<>();
		
		boolean isOk = true;
		
		for(int i=0;i<text.length();i++) {
			char c = text.charAt(i);
			if(c=='(') {
				stack.push(c);//add도 가능 -> 얘는 vector에서 끌고 오는 것
			}
			else {
				if(stack.isEmpty()) {
					System.out.println("닫는 괄호가 많습니다.");
					isOk = false;
					break;
				}
				stack.pop();
			}
		}
		//다 끝난 후 스택이 비어있는지 확인 필요
		if (isOk) {
		if(stack.isEmpty() && isOk) {
			System.out.println("짝이 맞다");
		}else {
			System.out.println("여는 괄호가 많다");
		}
	}
	}

}
