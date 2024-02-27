package 스택_큐;

import java.util.Stack;

public class 올바른괄호 {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
    	boolean answer = true;
        
        for(int i =0;i<s.length();i++) {
        	char c = s.charAt(i);
        	if(c=='(') {
        		st.push(c);
        	}else {
        		if(st.isEmpty()) {
        			answer=false;
        			break;
        		}else if(st.peek()=='(') {
        			st.pop();
        		}else {
        			answer=false;
        			break;
        		}
        	}
        }
        	if(!st.isEmpty()) {
        		answer = false;
        	}

        return answer;
    }
}
