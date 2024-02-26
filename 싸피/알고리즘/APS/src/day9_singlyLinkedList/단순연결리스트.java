package day9_singlyLinkedList;

class Node {
	int data;
	Node link;

	Node() {

	}

	Node(int data) {
		this.data = data;
		this.link = null;
	}
}

class SinglyLinkedList {
	Node head;
	int size;

	SinglyLinkedList() {
		head = null;// head가 비어져 있다.
					// head는 단순히 리스트의 첫 원소일 뿐
					// 원소가 추가되거나 삭제될 때마다 변경됨
	}

	void addFirst(int data) {
		Node newNode = new Node(data);
		newNode.link = head;
		head = newNode;
		size++;
	}

	void addLast(int data) {
		Node newNode = new Node(data);
		Node curr = head;
		while (curr.link != null) {
			curr = curr.link;
		}
		curr.link = newNode;
		size++;
	}

	void add(int idx, int data) {
		Node newNode = new Node(data);
		if (idx < 0 || size < idx) {
			System.out.println("삽입 불가(인덱스 초과)");
			return;
		}
		Node curr = head;
		if (idx == 0) {
			addFirst(data);
		} else {
			for (int i = 0; i < idx - 1; i++) {
				curr = curr.link;
			}
			newNode.link = curr.link;
			curr.link = newNode;
			size++;
		}
	}

	void remove(int idx) {
		if (idx < 0 || size <= idx) {
			System.out.println("삭제 가능 범위 초과");
			return;
		}
		if (idx == 0) {
			head = head.link;
			size--;
		} else {
			Node curr = head;
			for (int i = 0; i < idx - 1; i++) {
				curr = curr.link;
			}
			curr.link = curr.link.link;
			size--;
		}
	}

	void printList() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + "->");
			curr = curr.link;
		}
		System.out.println();
	}

}

public class 단순연결리스트 {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addFirst(1);
		list.addLast(2);
		list.addFirst(3);
		list.addLast(4);
		list.printList();
		list.remove(3);
		list.printList();
		list.add(0, 5);
		list.printList();
		list.remove(0);
		list.printList();

	}

}
