package day5_stack;
import java.util.Scanner;
import java.util.Stack;

public class 제로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int k = sc.nextInt();
			for(int i=0;i<k;i++) {
				stack.push(sc.nextInt());
				if(stack.peek()==0) {
					stack.pop();
					stack.pop();
				}
			}
			int sum = 0;
			while(!stack.isEmpty()) {
				sum+=stack.pop();
			}
			System.out.printf("#%d %d",t,sum);
			System.out.println();
			
		}
		
	}

}
