package day10_Tree;
import java.util.Scanner;
class Node5{
	int num;
	String data;
	Node5 left;//왼쪽 자식 노드
	Node5 right;//오른쪽 자식 노드
	Node5 mom;//부모 노드
	Node5(){}
	Node5(int num, String data){
		this.num = num;
		this.data = data;
	}
}

public class 사칙연산 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int n = sc.nextInt();
			sc.nextLine();
			Node5[] tree = new Node5[n+1];
			for(int i=1;i<n+1;i++) {
				tree[i] = new Node5();
			}
			for(int i=1;i<n+1;i++) {
				String[] command = sc.nextLine().split(" ");
				tree[i].data = command[1];
				if(command.length>2) {
					tree[i].left = tree[Integer.parseInt(command[2])];
					tree[i].right = tree[Integer.parseInt(command[3])];
//					tree[Integer.parseInt(command[3])].mom = tree[i+1];
//					tree[Integer.parseInt(command[4])].mom = tree[i+1];
				}
			}
			int sum = 0;
			for(int i=1;i<n+1;i++) {
//				switch(tree[i].data) {
//				case"*":
//					
//				}
				
			}
			
			System.out.print("#"+t+" "+(int)inorder(tree[1]));
			
			System.out.println();
			
		}
	}
	static double inorder(Node5 node) {
		if(node==null) {
			return 0;
		}
		if(node.data.equals("+")) {
			return inorder(node.left)+inorder(node.right);
		}else if(node.data.equals("-")) {
			return inorder(node.left)-inorder(node.right);
		}else if(node.data.equals("*")) {
			return inorder(node.left)*inorder(node.right);
		}else if(node.data.equals("/")) {
			return inorder(node.left)/inorder(node.right);
		}else {
			return Integer.parseInt(node.data);
		}
//		inorder(node.left);
//		System.out.print(node.data+" ");
//		inorder(node.right);
	}

}
