package day11_Tree2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//노드 구현
class Node {
	String data;
	Node next;
	Node prev;

	Node() {
	}

	Node(String data) {
		this.data = data;
	}
}

//양방향 연결 리스트 구현
class doublyLinkedList {
	Node head;
	Node tail;
	int size;

	// 연결리스트 생성자
	public doublyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}

	// 원소 삽입
	void add(int idx, String data) {
		Node newNode = new Node(data);
		if (idx >= size / 2) {
			Node curr = tail;
			for (int i = size; i > idx; i--) {
				curr = curr.prev;
			}
			newNode.prev = curr.prev;
			newNode.next = curr;

			newNode.next.prev = newNode;
			newNode.prev.next = newNode;
			size++;
		} else {
			Node curr = head;
			for (int i = 0; i < idx; i++) {
				curr = curr.next;
			}
			newNode.next = curr.next;
			newNode.prev = curr;
			
			newNode.next.prev = newNode;
			newNode.prev.next = newNode;
			
			size++;
		}
	}

	// 원소 삭제
	void remove(int idx) {
		if (!(0 < idx && idx <= size)) {
			return;
		}
		if (idx >= size / 2) {
			Node curr = tail;
			for (int i = size; i >= idx; i--) {
				curr = curr.prev;
			}
			curr.next.prev = curr.prev;
			curr.prev.next = curr.next;
			size--;
		} else {
			Node curr = head;
			for (int i = 0; i < idx; i++) {
				curr = curr.next;
			}
			curr.next.prev = curr.prev;
			curr.prev.next = curr.next;
			size--;
		}
	}

	// 출력
	void printList() {
		StringBuilder sb = new StringBuilder();
		Node curr = head;
		while (curr.next != tail) {
			curr = curr.next;
			sb.append(curr.data);
		}
		System.out.println(sb);
	}

}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		doublyLinkedList list = new doublyLinkedList();
		for (int i = 0; i < text.length(); i++) {
			list.add(i, text.split("")[i]);
		}
		int n = Integer.parseInt(br.readLine());
		int idx = list.size;
		for (int i = 0; i < n; i++) {
			String command = br.readLine();
			if (command.equals("L")) {
				if (idx > 0) {
					idx--;
				}
			} else if (command.equals("D")) {
				if (idx < list.size) {
					idx++;
				} else {
					idx = list.size;
				}
			} else if (command.equals("B")) {
				list.remove(idx);
				if (idx > 0)
					idx--;

			} else {
//				System.out.println("삽입" + idx +  "  " + command.split(" ")[1]);
				list.add(idx, command.split(" ")[1]);
				idx++;
				
			}
//			System.out.println(idx);
		}
//		System.out.println(list.size);
		list.printList();

	}
}