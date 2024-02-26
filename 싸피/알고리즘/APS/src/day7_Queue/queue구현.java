package day7_Queue;

public class queue구현 {
	//배열을 활용하여 큐 구현
	//큐의 특성을 갖는 배열을 만들어본다.
	//creatQueue의 기능과 같음 -> 큐 선언 및 초기화 하는 것
	static int[] queue = new int[10];
	static int front = -1, rear = -1;//타입이 같으면 한번에 해도됨
	
	
	public static void main(String[] args) {
		
		int item = deQueue();//공백
		System.out.println(item);//-1
		
		for(int i = 0;i<10;i++) {
			enQueue(i);
		}
		enQueue(123); //배열(큐)의 크기를 초과해서 예외 발생
					  //isFull()생성 후에는 '포화' 반환
		for(int i = 0;i<10;i++) {
			int data = deQueue();
			System.out.println(data);//0-9반환
		}
		enQueue(10);//포화
	}
	//포화 상태 확인
	public static boolean isFull() {
		//데이터가 추가로 들어갈 수 있는지 확인 -> rear확인
		//rear가 배열의 마지막 인덱스라면 포화 상태라는 얘기
		return rear == queue.length-1;
	}
	
	//공백 상태 확인
	public static boolean isEmpty() {
		//빠져나올 데이터가 있는지 확인 -> front로 확인
		//front가 rear와 같은 값을 가지면 큐가 비어있다는 얘기(둘 다 1씩 증가하므로)
		return front == rear;
	}
	
	//삽입 성공 여부를 확인하려면 boolean타입으로 반환 가능
	public static void enQueue(int data) {
		//queue[?] = data; 
		//배열의 특정 인덱스에 값을 넣는다.
		//값 삽입 시 rear가 변한다. -> rear를 인덱스로 사용하면 되겠다.
		//삽입할 때는 포화상태인지 확인 필요
		if(isFull()) {
			System.out.println("포화");
			return;
		}
		queue[++rear] = data;
		//rear++;
		//queue[rear] = data;
	}
	//삭제된 값을 반환
	public static int deQueue() {
		//int item = queue[?];
		//삭제될 값을 저장
		//삭제 시 front가 변한다. -> front를 인덱스로 사용하면 되겠다.
		//삭제할 때는 공백 상태인지 확인해야 함
		if(isEmpty()) {
			System.out.println("공백");
			//큐에 들어갈 수 없는 범위의 데이터를 반환해서 
			//공백 상태구나를 확인
			return -1;//예시로 한 것
		}
		int item = queue[++front];
		//front++;
		//int item = queue[front];
		return item;
	}
	//삭제하기 전에 삭제될 데이터를 확인하는 연산
	public static int Qpeek() {
		//공백 확인 필요
		if(isEmpty()) {
			System.out.println("공백");
			return -1;
		}
		//front를 변경시킬 필요가 없다. -> 단순히 확인하는 용이기 때문	
		return queue[front+1];
		
	}
}
