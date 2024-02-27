package 스택_큐;
import java.util.*;
public class 같은숫자는싫어 {
    public static int[] solution(int []arr) {
    	Stack<Integer> s = new Stack<>();
    	for(int i=0;i<arr.length;i++) {
    		if(!s.isEmpty()&&s.peek()==arr[i]) {
    			continue;
    	}else {
    		s.push(arr[i]);
    	}
    	}
    	int [] answer = new int[s.size()];
    	for(int i=answer.length-1;i>=0;i--) {
    		answer[i] = s.pop();
    	}
        return answer;
    }
    public static void main(String[] args) {
    	int[] arr = {1,1,3,3,0,1,1};
		System.out.println(Arrays.toString(solution(arr)));
	}
}
