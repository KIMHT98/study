package day06_stack2;

import java.util.Stack;

public class 계산하기 {
//(1+2*(4/2)+1*3)=8
	public static void main(String[] args) {
		String postfix = "345+6*+7+";
		//피연산자를 담아 놓을 스택
		Stack<Integer> nums = new Stack<>();
		//후위 표기식의 길이만큼 반복
		for(int i = 0;i<postfix.length();i++) {
			char c = postfix.charAt(i);
			//피연산자의 경우 정수형으로 바꿔서 push
			if(c>='0'&&c<='9') {
				nums.push(c-'0');
			}else {
				//연산자의 경우 두개를 pop한후 
				//뒤에 pop된 숫자에서 앞에 pop된 숫자를 연산
				int a = nums.pop();
				int b = nums.pop();
				nums.push(calculator(b, a, c));
			}
		}
		System.out.println(nums.pop());//8

	}
	//연산자의 종류에 따라 계산을 바로 해주기 위한 메소드
	public static int calculator(int a, int b, char op) {
		switch(op) {
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		case '/':
			return a/b;
		}
		return -1;
	}

}
