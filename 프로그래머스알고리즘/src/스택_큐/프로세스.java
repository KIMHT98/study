package 스택_큐;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프로세스 {

	public int solution(int[] priorities, int location) {
		PriorityQueue<int[]> pq = new PriorityQueue()<>();
		int[][] arr = new int[priorities.length][2];
		for (int i = 0; i < priorities.length; i++) {
			arr[i][0] = priorities[i];
			arr[i][1] = i;
		}
		int answer = 0;
		while(pq.poll()[1]!=location) {
			
		}
		return answer;
	}
}
