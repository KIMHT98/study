package test02_characterstream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamTest1 {
	public static void main(String[] args) {
		try (FileReader reader = new FileReader("big_input.txt");
				FileWriter writer = new FileWriter("big_input_copy.txt");) {
			int c; // 문자를 하나씩 읽고 더 없으면 -1
			while ((c = reader.read()) != -1) {
				writer.write(c);
			}
			System.out.println("복사 종료");
			System.out.println("스트림도 종료");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
