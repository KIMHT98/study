package test02_characterstream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamTest2 {
	public static void main(String[] args) {
		try (FileReader reader = new FileReader("big_input.txt");
				FileWriter writer = new FileWriter("big_input_copy2.txt");) {
			
			int c; // reader가 채워준 char의 개수 / 끝나면-1
			char[] buffer = new char[10];
			
			while ((c = reader.read(buffer)) != -1) {
				writer.write(buffer,0,c);
			}
			System.out.println("복사 종료");
			System.out.println("스트림도 종료");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
