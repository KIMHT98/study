package day09_LinkedList;
import java.util.Scanner;


	class Node2{
		int data;
		Node2 link;
		
		Node2(){}
		
		Node2(int data){
			this.data = data;
		}
	}
	class singleLinkedList{
		Node2 head;
		int size;
		singleLinkedList(){
			head = new Node2();
		}
		
		void add(int idx , int data) {
			Node2 newNode = new Node2(data);
			Node2 curr = head;
			for(int i=0;i<idx;i++) {
				curr = curr.link;
			}
			newNode.link = curr.link;
			curr.link = newNode;
			size++;
		}
		void remove(int idx) {
			Node2 curr = head;
			for(int i=0;i<idx;i++) {
				curr = curr.link;
			}
			curr.link = curr.link.link;
			size--;
		}
		void addLast(int data) {
			Node2 newNode = new Node2(data);
			Node2 curr = head;
			while(curr.link!=null){
				curr = curr.link;
			}
			curr.link = newNode;
			size++;
		}
		void printList() {
			Node2 curr = head.link;
			for(int i=0;i<10;i++) {
				System.out.print(curr.data+" ");
				curr = curr.link;
			}
			System.out.println();
		}
	}
	public class 암호문3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			singleLinkedList list = new singleLinkedList();
			int n = sc.nextInt();
			for(int i =0;i<n;i++) {
				list.add(i, sc.nextInt());
			}
			int m = sc.nextInt();
			sc.nextLine();
			String[] command = sc.nextLine().split(" ");
			int idx = 0;//값이 들어가거나 삭제될 위치
			int IDidx = 0; //command에서 I나 R의 인덱스
			int k = 0; //추가되거나 삭제될 숫자 개수
			for(int i=0;i<command.length;i++) {
				if(command[i].equals("I")) {
					IDidx = i;
					idx = Integer.parseInt(command[IDidx+1]);
					k = Integer.parseInt(command[IDidx+2]);
					for(int j = 0;j<k;j++) {
						list.add(idx, Integer.parseInt(command[IDidx+3]));
						idx++;
						IDidx++;
					}
				}else if(command[i].equals("D")) {
					IDidx = i;
					idx = Integer.parseInt(command[IDidx+1]);
					k = Integer.parseInt(command[IDidx+2]);
					for(int j=0;j<k;j++) {
						list.remove(idx);
					}
				}else if(command[i].equals("A")) {
					IDidx = i;
					k = Integer.parseInt(command[IDidx+1]);
					for(int j=0;j<k;j++) {
						list.addLast(Integer.parseInt(command[IDidx+2]));
						IDidx++;
					}
				}else {
					continue;
				}
				
			}
			System.out.print("#"+t+" ");
			list.printList();
		}
	}

}
