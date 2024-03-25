package day02_array;
import java.util.Scanner;


public class gravity {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1;t<=T;t++) {
			int N = sc.nextInt();
			//1차원 배열 설정(중력 작용 전)
			int[] before = new int[N];
			for (int i=0;i<N;i++) {
				before[i] = sc.nextInt();
			}
			
			//중력 작용 후 배열 설정 -> 작용 전 배열을 정렬해주면됨
			int[] after = countingSort(before);
			int max = 0;
			for(int i =0;i<N;i++) {
				int d = 0;
				for(int j =0;j<N;j++) {
					if (before[i] == after[j]) {
						if(j>i) {
						d = j - i;//낙차는 전 후의 값이 같은 인덱스의 차이
						break;
					}else {
						d=0;//d<0이면 그냥 0으로 두겠다.
						break;
					}
					}
				}
				if(d>max)
					max = d;
			}
//			int[] idxmap = new int[N];
//			for(int i = 0;i<N;i++) {
//				idxmap[after[i]] = i;
//			}
//			for(int i=0;i<N;i++) {
//				int j = idxmap[before[i]];
//				int distance = j-i;
//				max = Math.max(max, distance);
//			}
			System.out.printf("#%d %d",t,max);
			System.out.println();
		}

	}
	public static int[] countingSort(int[] arr) {
		//처음에는 그냥 100으로 고정했는데, 이러니깐 시간이 오래걸려서 오루 발생
		//->메모리 오류가 아닌 인덱스 오류였음->100층까지니깐 101이어야 했다.
		//유동적으로 변하게 해줘야 시간복잡도가 줄어듬.
		//->흠 이건 최댓값을 제대로 아는 경우라면 그냥 count의 크기를 고정하는 것이 조흥
		//->for문이 생기면서 연산량이 더 늘어날 수도 있음.
		int[] count = new int[101];//최대 100개까지니깐 0~100으로 101개여야 함.
//		int maxVal = 0;
//		for(int value : arr) {
//			maxVal = Math.max(maxVal, value);
//		}
//		int[] count = new int[maxVal+1];
		for(int i=0;i<arr.length;i++) {
			count[arr[i]]++;
		}
		for (int i = 1;i<count.length;i++) {
			count[i]+=count[i-1];
		}
		int[] sortedArr = new int[arr.length];
		
		for(int i= arr.length-1;i>=0;i--) {
			sortedArr[--count[arr[i]]] = arr[i];
			
		}
		return sortedArr;
	}

}
