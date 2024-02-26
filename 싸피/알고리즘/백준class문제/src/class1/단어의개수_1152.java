package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어의개수_1152 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		if (text.equals(" ")||text.equals("")) {
			System.out.println(0);
		} else {
			System.out.println(text.strip().split(" ").length);

		}
	}

}
