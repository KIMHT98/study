package day05_stack;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class 괄호짝짓기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int answer = 1;
			Map<Character, Character> map = new HashMap<>();
			map.put(']', '[');
			map.put('}', '{');
			map.put(')', '(');
			map.put('>', '<');
			int n = sc.nextInt();
			String text = sc.next();
			Stack<Character> stack = new Stack<>();
			char[] arr = text.toCharArray();
			for(int i=0;i<arr.length;i++) {
				if(arr[i]=='['||arr[i]=='{'||arr[i]=='('||arr[i]=='<') {
					stack.push(arr[i]);
				}else {
					if(stack.isEmpty()) {
						answer = 0;
						break;
					}else if(stack.peek()!=map.get(arr[i])) {
						answer = 0;
						break;
					}else {
						stack.pop();
					}
					
						
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}

}
