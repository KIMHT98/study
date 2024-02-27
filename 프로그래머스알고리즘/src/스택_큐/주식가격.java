package 스택_큐;

import java.util.Stack;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> s = new Stack<>();
        for(int i = 1;i<prices.length;i++) {
        	s.push(0);
        	int idx = 1;
        	while(!s.isEmpty()&&prices[s.peek()]>=prices[idx]) {
        		s.push(prices)
        	}
        }
        return answer;
    }
}
