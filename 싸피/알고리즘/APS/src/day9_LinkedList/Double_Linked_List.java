package day9_LinkedList;
class Node{
	int data;
	Node prev;
	Node next;
	
	Node(){}
	
	Node(int data){
		this.data = data;
	}
}
class DoublyLinkedList{
	Node head;
	Node tail;
	int size;
	
	public DoublyLinkedList() {
		//head와 tail의 더미 노드를 만들어 놓으면
		//모든 삽입과 삭제 연산이 중간 삽입 및 삭제로 이루어짐
		head = new Node();//head의 더미 노드
		tail = new Node();//tail의 더미 노드
		head.next = tail;
		tail.prev = head;
	}
	//삽입
	//처음에 삽입
	//싱글 연결 리스트와 유사
	void addFirst(int data) {
		//head -> new -> tail 순으로 만들거임.
		Node newNode = new Node(data);
		newNode.next = head.next;
		head.next.prev = newNode;
		
		head.next = newNode;
		newNode.prev = head;
		size++;
	}
	//마지막에 삽입
	void addLast(int data) {
		Node newNode = new Node(data);
		
		//newNode 먼저 연결
		newNode.next = tail;
		newNode.prev = tail.prev;
		
		//newNode 양 옆에 있는 노드가 newNode를 가리키도록 설정
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		
		size++;
	}
	//중간에 삽입
	void add(int idx, int data) {
		if(!(0<=idx&&idx<size)) {
			System.out.println("삽입할 수 없는 범위 입니다.");
			return;
		}
		Node newNode = new Node(data);
		Node curr = head;
		for(int i=0;i<idx;i++) {
			curr = curr.next;
		}
		newNode.next = curr.next;
		newNode.prev = curr;
		
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		size++;
	}
	//삭제
	void remove(int idx) {
		//idx범위 확인
		if (!(0<=idx&&idx<size)) {
			System.out.println("삭제할 수 없는 범위입니다.");
			return;
		}
		Node removeNode = head.next;
		
		for(int i=0;i<idx;i++) {
			removeNode = removeNode.next;
		}
		//반복문이 끝나면 curr은 삭제할 노드를 가리킴
		
		removeNode.prev.next = removeNode.next;
		removeNode.next.prev = removeNode.prev;
		
		size--;
	}
	void printList() {
		Node curr = head.next;
		while(curr != tail) {
			System.out.print(curr.data+"->");
			curr = curr.next;
		}
		System.out.println();
	}
}

public class Double_Linked_List {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.addFirst(1);
		list.addLast(2);
		list.add(1,3);
		list.remove(2);
		list.printList();//1->3->
		System.out.println(list.size);
		
	}

}
