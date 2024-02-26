package day10_Tree;

import java.util.Scanner;

//노드 구현
class Node{
	int data;
	Node left;//왼쪽 자식 노드
	Node right;//오른쪽 자식 노드
	
	Node(){}
	
	Node(int data) {
		this.data = data;
	}
}
public class 연습문제2 {
	
	static Node[] nodes =  new Node[14];//정점의 개수가13개니깐
	static int[] count =new int[14];//자식노드인지 판별용
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i= 1;i<14;i++) {
			//각 노드들을 우선 빈 노드로 생성
			nodes[i] = new Node();
			//각 노드에 번호 부여
			nodes[i].data = i;
		}
		
		int v = sc.nextInt();
		//v-1개의 간선의 정보가 주어짐
		for(int i=0;i<v-1;i++) {
			//앞에 숫자가 부모 노드
			int parent = sc.nextInt();
			//뒤에 숫자가 자식 노드
			int child = sc.nextInt();
			
			//자식 노드의 호출 개수 
			count[child]++;
			
			if(nodes[parent].left == null) {
				//왼쪽 자식 노드가 비어 있으면
				//왼쪽부터 채움
				nodes[parent].left = nodes[child];
			}else {
				//왼쪽 자식 노드에 있으면
				//오른쪽 채움
				nodes[parent].right = nodes[child];
			}
		}
		int root = -1;
		for(int i=1;i<14;i++) {
			if(count[i]==0) {
				//자식 노드 판별 개수가 0이면 걔는 루트
				root = i;
			}
		}
		System.out.println(root);//1
		preorder(nodes[root]);//1 2 4 7 12 3 5 8 9 6 10 11 13
	}
	static void preorder(Node node) {
		if(node==null) {
			//빈 노드이면 건너 뛴다.
			return;
		}
		System.out.print(node.data+" ");//V
		preorder(node.left);//L
		preorder(node.right);//R
		
	}

}
