package day10_Tree;
import java.util.Scanner;


class Node4{
	int num;
	Node4 left;//왼쪽 자식 노드
	Node4 right;//오른쪽 자식 노드
	Node4 mom;//부모 노드
	Node4(){}
	Node4(int num){
		this.num = num;
	}
}
public class 공통조상 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=  sc.nextInt();
		for(int t=1;t<=T;t++) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			Node4[] tree = new Node4[v+1];//트리
			int[] count = new int[v+1];//자식노드인지 판별용
			for(int i=1;i<v+1;i++) {
				tree[i] = new Node4(i);
			}
			for(int i=1;i<=e;i++) {
				int parent = sc.nextInt();
				int child = sc.nextInt();
				
				count[child]++;
				
				if(tree[parent].left==null) {
					tree[parent].left = tree[child];//왼쪽 자식 노드로 설정
					tree[child].mom = tree[parent];//부모 노드로 설정
				}else {
					tree[parent].right = tree[child];//오른쪽 자식 노드로 설정
					tree[child].mom = tree[parent];//부모 노드로 설정
				}
			}
			
			int commonroot = 1;
			Node4 node1 = tree[n1];
			while(node1.mom != null) {
				Node4 node2 = tree[n2];
				while(node2.mom != null) {
					if(node2 == node1) {
						commonroot = node1.num;
						break;
					}
					node2 = node2.mom;
				}if(commonroot!=1)
					break;
				node1 = node1.mom;
				
			}
			System.out.println("#"+t+" "+commonroot+" "+preorder(tree[commonroot]));
		}
	}
	static int preorder(Node4 node) {
		if(node==null) {
			//빈 노드이면 건너 뛴다.
			return 0;
		}
		return 1+preorder(node.left)+preorder(node.right);
		
		
		
	}

}
