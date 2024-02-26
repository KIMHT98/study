package day9_LinkedList;
import java.util.Scanner;

class Node {
	int data;
	Node link;

	Node() {
	}

	Node(int data) {
		this.data = data;
	}
}

class singlyLinkedList {
	Node head;
	int size;

	singlyLinkedList() {
		head = new Node();
	}

	void add(int idx, int data) {
		Node newNode = new Node(data);
		Node curr = head;
		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}
		newNode.link = curr.link;
		curr.link = newNode;
		size++;
	}

	void printList() {
		Node curr = head.link;
		for (int i = 0; i < 10; i++) {
			System.out.print(curr.data + " ");
			curr = curr.link;
		}
		System.out.println();

	}
}

public class 암호문1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			singlyLinkedList list = new singlyLinkedList();
			int n = sc.nextInt();
			for(int i=0;i<n;i++) {
				list.add(i, sc.nextInt());
			}
			int m = sc.nextInt();
			sc.nextLine();
			String[] command = sc.nextLine().split(" ");
			int idx = 0;//리스트에 add할 위치
			int k = 0;//넣을 숫자 개수
			int Iidx = 0;//I의 인덱스
			for(int i=0;i<command.length;i++) {
				if(command[i].equals("I")) {
					Iidx = i;
					idx = Integer.parseInt(command[Iidx+1]);
					k = Integer.parseInt(command[Iidx+2]);
					for(int j =0;j<k;j++) {
						list.add(idx, Integer.parseInt(command[Iidx+3]));
						idx++;
						Iidx++;
					} 
					
				}else {
					continue;
				}
			}
			System.out.print("#"+t+ " ");
			list.printList();
			}
		}

	}


