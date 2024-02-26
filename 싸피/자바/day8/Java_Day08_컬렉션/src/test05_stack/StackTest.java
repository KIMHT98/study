//Stack
//-LIFO
//-Stack클래스

package test05_stack;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
    	Stack<Integer> stack = new Stack<>();
    	
    	for (int i=0;i<5;i++) {
    		stack.push(i);
    	}
    	while(!stack.isEmpty()) {
    		System.out.println(stack.pop());//4 3 2 1 0(뒤에서부터 나옴)
    	}
    }
}
