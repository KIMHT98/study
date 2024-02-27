package 스택_큐;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] diff = new int[progresses.length];
        Stack<Integer> s = new Stack<>();
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<diff.length;i++) {
        	if((100-progresses[i])%speeds[i]!=0) {
        		diff[i]=(100-progresses[i])/speeds[i]+1;
        	}else {
        		diff[i]=(100-progresses[i])/speeds[i];
        	}
        }
        
    	return answer;
    }
}
