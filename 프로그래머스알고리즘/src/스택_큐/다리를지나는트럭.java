package 스택_큐;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> bridge = new LinkedList<>();
		int answer = 0;
		int nowWeight = 0;
		int sec = 0;
		boolean isfinish = false;
		int i = 0;
		while(!isfinish) {
			if (bridge.isEmpty()) {
				bridge.offer(truck_weights[i]);
				nowWeight += truck_weights[i];
				i++;
				sec++;
			}else if ( nowWeight + truck_weights[i]<=weight) {
				bridge.offer(truck_weights[i]);
				nowWeight += truck_weights[i];
				sec++;
				i++;
			}else {
				sec++;
			}
			if(sec == bridge_length) {
				nowWeight -= bridge.poll();
				answer+=sec;
				if(bridge.isEmpty())
					sec=0;
				else
					sec--;
			}
			if(i>truck_weights.length-1) {
				while(!bridge.isEmpty()) {
					sec++;
				}
				answer += sec;
				isfinish = true;
				break;
			}
		}

		return sec;
	}
	public static void main(String[] args) {
		int[] tw = {7,4,5,6};
		System.out.println(solution(2,10,tw));
	}
}
