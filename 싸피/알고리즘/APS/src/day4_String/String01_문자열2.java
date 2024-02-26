package day4_String;

import java.util.Arrays;

public class String01_문자열2 {

	public static void main(String[] args) {
		//문자열 뒤집기
		String str = "Hello SSafy";
		//문자를 바꾸기 위해서는 배열로 만들어주는 것이 좋음
		char[] charArr = str.toCharArray();
		//자기 자신 내에서 뒤집기
		int len = str.length();
		for(int i=0; i<len/2;i++) {
			char temp = charArr[i];
			charArr[i] = charArr[len-i-1];
			charArr[len-i-1] = temp;
		}
		System.out.println(Arrays.toString(charArr));
		
		//새로운 빈 문자열 활용
		char[] reverse = new char[len];
		for(int i = 0 ;i<len;i++) {
			reverse[i] = charArr[len-1-i];
		}
		System.out.println(Arrays.toString(reverse));
		
	}

}
