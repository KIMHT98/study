package day7_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class queue사용 {

	public static void main(String[] args) {
		//큐는 linkedlist를 통해 구현됨.
		Queue<Integer> queue = new LinkedList<>();
	
		//삽입
		queue.add(1);
		queue.offer(1);
		//삭제
		queue.remove();
		queue.poll();
		//조회
		queue.element();
		queue.peek();
		//add,remove,element는 실패 시 예외 발생
		//offer,poll,peek은 예외 처리를 하여 false,null,null반환
	}

}
