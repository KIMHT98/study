package day04_String;

import java.util.Arrays;

public class String01_문자열3 {

	public static void main(String[] args) {
		//문자열 -> 정수형
		String str = "12345";

		int result = atoi(str);
		System.out.println(result);
}
	public static int atoi(String str) {
		int value = 0;
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if('0'<=c&&c<='9') {
				value = value * 10 +(c-'0');
			}else {
				System.out.println("정수가 아닙니다");
				return -999999;
			}
		}
		return value;
	}
}
