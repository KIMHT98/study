package day8_Queue2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 원형큐 {
	//초기 큐 선언
	static String[] queue = new String[5];
	static int front = 0;
	static int rear = 0;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(queue));
		enQueue("김");//1번 인덱스에 값이 저장됨
		System.out.println(Arrays.toString(queue));
		enQueue("나");//2번에 저장
		enQueue("박");//3번에 저장
		enQueue("이");//4번에 저장
		deQUeue();//김 삭제, front위치 1로됨, 값은 그대로 남아있긴 함(원칙 상 삭제된 것)
		deQUeue();//나 삭제, front위치 2로됨, 값은 그대로 남아있긴 함(원칙 상 삭제된 것)
		deQUeue();//이 삭제, front위치 3로됨
		enQueue("최");//0번에 저장
		enQueue("오");//1번에 저장
		enQueue("강");//2번에 저장
		
		System.out.println(Arrays.toString(queue));//[최, 오, 강, 박, 이]
	}

	// 공백상태
	// front와 rear가 같은 위치를 가리키고 있다.
	public static boolean isEmpty() {
		return front == rear;
	}

	// 포화상태
	// front가 rear보다 한 칸 앞서있는 경우
	public static boolean isFull() {
		return front == (rear + 1) % queue.length;
	}

	// 삽입
	public static void enQueue(String data) {
		if (isFull()) {
			System.out.println("포화 상태");
			return;
		}
		rear = (rear + 1) % queue.length;
		queue[rear] = data;
	}
	//삭제
	public static String deQUeue() {
		if(isEmpty()) {
			System.out.println("공백 상태");
			return null;
		}
		front = (front + 1) % queue.length;
		return queue[front];
	}
}
