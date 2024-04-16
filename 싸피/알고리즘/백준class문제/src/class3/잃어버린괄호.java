package class3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 잃어버린괄호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] cal = sc.next().split("-");
		for(int i=0;i<cal.length;i++) {
			if(cal[i].contains("+")) {
				int num = 0;
				String[] plus = cal[i].split("\\+");
				for(int j=0;j<plus.length;j++) {
					num+= Integer.parseInt(plus[j]);
				}
				cal[i] = num +"";
			}
		}
		int result = Integer.parseInt(cal[0]);
		for(int i=1;i<cal.length;i++) {
			result-=Integer.parseInt(cal[i]);
		}
		System.out.println(result);
	}

}
