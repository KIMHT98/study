package day07_Queue;

public class 원형큐 {
	//원형큐도 따지고 보면 일차원 배열인데 배열의 크기를 하나더 늘림
	//이 칸에는 값이 들어오면 안됨.->front가 가리키는 곳이라고 생각
	static int n = 4;
	static int front = 0;
	static int rear = 0;
	static int[] queue = new int[n+1];
	
	public static void enQueue(int data) {
		if((rear+1)%(n+1)==front) {
			//원형큐는 rear가 빈칸으로 가면 큐가 꽉찼다고 판단
			System.out.println("큐가 포화 상태");
			return;
		}
		//무작정 rear를 한칸씩 옮기면
		//rear가 배열의 크기를 넘어갈 수 있음
		//배열의 크기로 나누어 나머지를 rear로 설정
		rear = (rear+1)%(n+1);
		queue[rear]=data;
	}
	public static int deQueue() {
		if(front == rear) {
			//원형큐도 마찬가지로 삭제시 front를 한칸 씩 이동
			//front랑 rear가 같아지면 공백이라고 판단
			System.out.println("큐가 공백 상태");
			return -99999;
		}
		//무작정 front를 한칸씩 옮기면
		//front가 배열의 크기를 벗어남
		//배열의 크기로 나누어 나머지를 front로 설정
		front = (front+1)%(n+1);
		int data = queue[front];
		return data;
	}
	public static int Qpeek() {
		if(front==rear) {
			System.out.println("큐가 공백 상태");
			return -99999;
		}
		return queue[(front+1)%(n+1)];
	}

	public static void main(String[] args) {
		int item = deQueue();//공백
		System.out.println(item);//-99999
		
		for(int i = 1;i<=n;i++) {
			enQueue(i);
		}
		enQueue(123); //포화
		for(int i = 0;i<n;i++) {
			int data = deQueue();
			System.out.println(data);//1-4반환
		}
	}

}
