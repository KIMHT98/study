package day04_String;

import java.util.Arrays;

public class String01_문자열5 {

	public static void main(String[] args) {
	String text = "This iss a book";
	String pattern = "a book";
	
	int result = patternMatching(text.toCharArray(),pattern.toCharArray());
	System.out.println(result);
	}
	public static int patternMatching(char[] text, char[] pattern) {
		//i : 패턴 비교 시작 위치
		//j : 문자 하나씩 비교하는 인덱스
		//다중 반복문에서 라벨 사용
		//반복문에 이름 붙여준다 생각하면 될 듯
		start : for(int i = 0; i<= text.length-pattern.length;i++) {
			pattern : for(int j = 0; j<pattern.length;j++) {
				if(text[i+j] != pattern[j]) {
					continue start;
				}
			}
			return i;
		}
		return -1;
}
}
