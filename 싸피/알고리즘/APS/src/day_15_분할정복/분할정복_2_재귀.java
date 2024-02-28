package day_15_분할정복;

public class 분할정복_2_재귀 {

	public static void main(String[] args) {
		int C = 2;
		int N = 10;
		System.out.println(pow(C,N));//1024
	}
	public static int pow(int C, int N) {
		//기저조건
		if (N ==1) return C;
		
		int tmp;
		//재귀 부분
		//N이 짝수인 경우와 아닐때로 나눔
		if(N%2==0) {
			//짝수인 경우 지수를 2로 나누면서 감
			tmp =pow(C,N/2);
			return tmp*tmp;
		}else {
			//홀수인 경우 하나가 남으니깐 C를 하나 더 곱해줌
			tmp = pow(C,(N-1)/2);
			return tmp*tmp * C;
		}
	}

}
