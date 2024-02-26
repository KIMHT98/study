package day9_singlyLinkedList2;

class Node {// data와 link가 모여있는 곳
	String data;
	Node link;// 다른 노드를 가리키기 위한 수단

	Node() {
	}// 생성자

	Node(String data) {
		// 노드가 만들어질 때 노드의 데이터를 파라미터로 사용
		this.data = data;
//		this.link = null;//
	}
}

class SinglyLinkedList {
	Node head;
	int size;
	SinglyLinkedList() {
		head = new Node();// 더미 노드로 head 생성
	}

	// 삽입
	// 1. 제일 앞에 삽입
	void addFirst(String data) {
		//data를 받아서 새로운 노드를 삽입할 것이다.
		Node newNode = new Node(data);
		//head -> newNode -> 기존의 0번 인덱스 순으로 만들고 싶다.
		//연결 관계를 바꾸는 순서가 중요
		//기존의 연결을 끊으면 이후에 연결이 불가능함
		//기존의 연결을 끊기 전에 새 노드를 연결해준 후에 끊고 연결
		//newNode부터 연결 후에 head 연결
		newNode.link = head.link;//head와 newNode둘다 0번을 가리킴
		head.link = newNode; //head->newNode->0번으로 변경됨.
		
		size++;//데이터가 추가되었으므로 크기가 증가됨.
	}
	//2. 제일 뒤에 삽입
	void addLast(String data) {
		Node newNode = new Node(data);
		//초기 상태는 head라는 curr현재노드 생성
		//curr에 curr의 link를 할당하여 계속 옮김
		Node curr = head;
		while(curr.link != null) {//마지막이 되면 null임
			curr = curr.link;
		}
		//반복문이 끝나면 curr은 마지막 노드를 가리킴
		curr.link = newNode; //마지막 노드에 newNode를 넣어줌
		
		size++;
		
	}
	//3. 중간에 삽입
	void add(int idx, String data) {
		Node newNode = new Node(data);
		if(idx<0 || size<idx) {
			System.out.println("삽입 불가(인덱스 초과)");
			return;
		}
		Node curr = head;
		for(int i=0;i<idx;i++) {
			curr = curr.link;
		}
		//curr -> curr.link에서
		//curr -> newNode -> curr.link로 변경됨
		newNode.link = curr.link;
		curr.link = newNode;
		
		size++;
		
		
	}
	// 삭제
	//지정한 idx에 해당하는 노드 삭제
	void remove(int idx) {
		if(idx < 0 || size <= idx) {
			System.out.println("삭제 범위 초과");
			return;
		}
	//curr를 원하는 idx를 가리키게 하면 됨
	//curr를 head ~ idx-1까지 이동시킴
	//이후에 curr를 idx를 건너뛰어서 다음것과 연결시켜준다.
	//해당 idx에 연결된 것이 없으므로 GC(가비지 컬렉터)가 알아서 지워줌
		Node curr = head;
		for(int i=0;i<idx;i++) {
	//지금 더미 노드로 사용해서 하는 것
			curr = curr.link;
		}
		//반복문이 끝나면 curr은 삭제할 노드의 앞을 가리킴
		curr.link = curr.link.link;
		//삭제할 노드를 건너 뛰어서 연결을 끊어줌.
		//인덱스가 범위를 벗어나면 null에서 다음을 이어주는 것이라서 예외 발생
		//조건 필요(위에 작성)
		size--;//삭제되므로 크기하나 줄음
	}

	// 조회
	
	//모든 데이터 조회
	void printList() {
		Node curr = head.link;
		while(curr != null) {
			System.out.print(curr.data + "->");
			curr = curr.link;
		}
		System.out.println();
	}
	int getSize() {//리스트의 크기 확인
		//굳이 안만들어도 되긴 함
		Node curr = head;
		int size = 0;
		//null,즉 마지막 노드 전까지 이동
		while(curr.link != null) {
			curr = curr.link;
			size++;
		}
		return size;
	}
}

public class 단순연결리스트 {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addFirst("A");
		list.addLast("B");
		list.addFirst("C");
		list.addLast("D");
		list.printList();//C->A->B->D->
		list.remove(2);
		list.printList();//C->A->D->
		list.remove(5);//삭제 범위 초과
		list.add(1, "E");
		list.printList();//C->A->E->D->
	}

}
