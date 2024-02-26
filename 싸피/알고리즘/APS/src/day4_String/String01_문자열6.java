package day4_String;

import java.util.HashMap;
import java.util.Map;

public class String01_문자열6 {

	public static void main(String[] args) {
		// 보이어 - 무어 구현
		String text = "This iss a book";
		String pattern = " iss";
		int result = patternMatching(text.toCharArray(), pattern.toCharArray());
		System.out.println(result);
	}

	public static int patternMatching(char[] text, char[] pattern) {
		Map<Character, Integer> skip = new HashMap<>();
		int len = text.length;
		int lenP = pattern.length;
		for (int i = lenP - 1; i >= 0; i--) {
			skip.put(pattern[i], lenP - 1 - i);
		}
		int idx = lenP - 1;
		int cnt = 0;
		int pIdx = lenP - 1;
		while (idx>=0 && idx<len) {
			if (text[idx] == pattern[pIdx]) {
				cnt++;
				idx--;
				pIdx--;
			} else if (skip.get(text[idx]) != null) {
				idx += skip.get(text[idx]);
				cnt = 0;
				pIdx = lenP - 1;
			} else {
				idx += lenP;
				pIdx = lenP - 1;
				cnt = 0;
			}
			if (cnt == lenP)
				break;
		}
		if (cnt == 0)
			return -1;
		else
			return idx + 1;
	}
}
