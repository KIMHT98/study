package class2;

import java.util.Scanner;

public class 펠린드롬수_1259 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String s = sc.next();
			if(s.equals("0")) {
				break;
			}
			String str = "";
			for(int i=s.length()-1;i>=0;i--) {
				str+=s.charAt(i);
			}
			if(s.equals(str)) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}

	}

}
