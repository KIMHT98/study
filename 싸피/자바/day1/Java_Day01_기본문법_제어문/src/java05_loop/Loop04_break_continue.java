package java05_loop;

public class Loop04_break_continue {
	public static void main(String[] args) {

		// 다음은 무슨 의미?
		for (int i = 2; i <= 9; i++) {
			if (i % 2 == 1)
				continue;
			System.out.println(i + "단");
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %d\n", i, j, i * j);
			}
		}

		// 다음은 무슨 의미? 
		for (int i = 2; i <= 9; i++) {
			if (i > 5)
				break;
			System.out.println(i + "단");
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %d\n", i, j, i * j);
			}
		}

		// 다음은 무슨 의미?
		for (int i = 2; i <= 9; i++) {
			System.out.println(i + "단");
			for (int j = 1; j <= 9; j++) {
				if (j > 5)
					break;
				System.out.printf("%d * %d = %d\n", i, j, i * j);
			}
		}

		// 다음은 무슨 의미?
		// label을 통해서 내가 빠져나갈 부분 지정 가능
		out: for (int i = 2; i <= 9; i++) {
			System.out.println(i + "단");
			for (int j = 1; j <= 9; j++) {
				if (j > 5)
					break out;
				System.out.printf("%d * %d = %d\n", i, j, i * j);
			}
		}

		// 다음은 무슨 의미?
		out: for (int i = 2; i <= 9; i++) {
			System.out.println(i + "단");
			for (int j = 1; j <= 9; j++) {
				if (j > 5)
					continue out;
				System.out.printf("%d * %d = %d\n", i, j, i * j);
			}
		}

	}
}
