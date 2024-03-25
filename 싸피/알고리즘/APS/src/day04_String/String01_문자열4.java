package day04_String;

import java.util.Arrays;

public class String01_문자열4 {

	public static void main(String[] args) {
	int num = 12345;
	String result = itoa(num);
	System.out.println(result);//12345
}
	public static String itoa(int num) {
		int idx = 1;
		int numCopy = num;
		String result = "";
		//숫자의 각 자릿수를 배열의 요소로 저장
		while(numCopy / 10 >0) {
			numCopy /= 10;//10으로 나누면서 한자리 씩 줄여간다
			idx++;//한자리씩 줄어가면 배열은 한자리 증가
		}
		int[] arr = new int[idx];
		for(int i=idx-1;i>=0;i--) {
			arr[i] = num%10;//배열의 마지막 원소부터 숫자의 1의자리 추가
			num /= 10;//일의자리를 지워감
		}
		for(int i = 0;i<idx;i++) {
			result += arr[i];//최종 숫자들을 더해서 문자열로 표현
		}
		return result;
	}
}
