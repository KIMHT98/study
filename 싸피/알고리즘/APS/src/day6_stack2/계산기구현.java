package day6_stack2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class 계산기구현 {

	public static void main(String[] args) {
		//연산자의 우선순위를 map으로 설정
		//스택 안에서의 우선순위 비교를 위한 것
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('+',1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('(', 0);

		Scanner sc = new Scanner(System.in);
		//문자열로 표현된 수식
		String expression = sc.next();
		
		//중위표기식 -> 후위표기식
		String postfix = "";
		Stack<Character> op = new Stack<>();
		
		//수식의 길이만큼 반복 수행
		for(int i=0; i< expression.length();i++) {
			//c에 따라서 스택에 넣을지 출력할지 결정
			char c = expression.charAt(i);
			
			if(c == '(') {
				op.push(c);
			}else if(c==')') {
				//c가 ')'이면 '('가 나올 때까지 pop해서 후위 표기식에 추가한다.
				while(op.peek() != '(') {
					postfix += op.pop();
				}
				op.pop();
			//피연산자인 경우 후위 표기식에 바로 추가
			}else if('0' <= c && c <= '9') {
				postfix += c;
			}else {
			//+,-,*,/의 경우 스택이 비어있다면 바로 push
				if(op.isEmpty()) {
					op.push(c);
				}else {//비어있지 않으면 우선순위가 낮은 연산자가 마지막에 위치할 때까지 pop
					while(!op.isEmpty() && priority.get(c) <= priority.get(op.peek())) {
						postfix += op.pop();//pop해서 후위 표기식에 더해줌
					}
					op.push(c);//pop한 후에 push
				}
			}
//			postfix+=op.pop();
			
		}
		System.out.println(postfix);
	}

}
