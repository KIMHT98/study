package day03_2tharray;

public class array03_전치행렬 {

	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		printArr(arr);
		
		//전치행렬로 바꾸기
		for(int r=0;r<arr.length;r++) {
			for(int c=0; c<arr[0].length;c++) {
				if(r<c) {
					int tmp = arr[r][c];
					arr[r][c]=arr[c][r];
					arr[c][r] = tmp;
				}
			}
				
		}
		printArr(arr);
		
		//시계방향으로 돌리기
		int[][] arr2 = {{1,2,3},{4,5,6},{7,8,9}};
		//같은 크기의 새로운 배열 생성
		int[][] newArr = new int[arr2.length][arr2[0].length];
		//행은 정방향으로 쭉~~
		for(int r=0;r<newArr.length;r++) {
			//열도 정방향으로 쭉~~
			for(int c=0;c<newArr[0].length;c++) {
				//새로운 배열의 행값은 (배열 크기 - c - 1), 열값은 r
				newArr[r][c] = arr2[newArr.length-c-1][r];
			}
		}
		printArr(newArr);
	}
	//배열 값 출력해주는 메소드
	public static void printArr(int[][] arr) {
		for(int r=0;r<arr.length;r++) {
			for(int c=0;c<arr[0].length;c++) {
				System.out.print(arr[r][c]+ " ");
			}
			System.out.println();
		}
	}

}
