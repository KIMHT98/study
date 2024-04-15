package pjt_패턴매칭;

import java.util.Arrays;

public class KMP {
	//브루트포스처럼 모두 비교X
	//부분문자열 중 접두사와 접미사가 일치하는 가장 긴 길이를 구해놓고 점프
	public static void main(String[] args) {
		String text = "ABABABACABAABABACACA";
		String pattern = "ABABACA";
		
		KMP(text,pattern);
	}
	
	//T : text
	//P : pattern
	private static void KMP(String T, String P) {
		//부분문자열 일치 테이블
		int pi[] = getPi(P);
//		System.out.println(Arrays.toString(pi));
		int j=0;
		for(int i=0;i<T.length();i++) {
			//달랐을 때
			while(j>0 && T.charAt(i) != P.charAt(j)) {
				j = pi[j-1];//점프
			}
			//같았을 때
			if(T.charAt(i)==P.charAt(j)) {
				//패턴 찾음
				if(j==P.length()-1) {
					System.out.println((i-j)+"에서 시작하면 패턴 찾음");
					j = pi[j];
				}else {
					j++;
				}
			}
		}
		
	}

	private static int[] getPi(String p) {
		//부분문자열 중 접두사와 접미사가 일치하는 최대 길이를 담을 배열
		int[] pi = new int[p.length()]; //0~i까지의 부분문자열을 뽑는다.
		
		int j = 0;//여기까지 같다.
		for(int i=1;i<p.length();i++) {
			//지금 두개의 포인트가 가리키는 값이 다르면
			while(j>0 && p.charAt(i) != p.charAt(j))
				j=pi[j-1];
			
			//두개의 포인트가 가리키는 값이 같으면 저장
			if(p.charAt(i)==p.charAt(j)) {
				pi[i] = ++j;//i번째 최대 길이는 ++j
			}
		}
		return pi;
	}
}
