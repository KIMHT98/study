package day10_Tree;
import java.util.Scanner;

public class 중위순회 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int n = sc.nextInt();
			sc.nextLine();
			String[] arr = new String[n+1];
			for(int i=0;i<n;i++) {
				String command = sc.nextLine();
				arr[i+1] = command.split(" ")[1];//트리의 노드 번호에 맞는 문자 삽입
			}
			System.out.print("#"+t+" ");
			inorder(arr,1);
			System.out.println();
		}
		sc.close();
	}

//중위순회
static void inorder(String[] arr,int i) {
	if(arr.length <=i||arr[i]==null) {
		return;
	}
	inorder(arr,i*2);
	System.out.print(arr[i]);
	inorder(arr,i*2+1);
}
}