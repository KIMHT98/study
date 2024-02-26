package test01_bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest3 {
	public static void main(String[] args) {
		// ByteStream을 이용해서 이미지를 입출력
		
		try (FileInputStream fis =new FileInputStream("dog.jpg");
				FileOutputStream fos =new FileOutputStream("dog-copy.jpg"); 
				) {//()안에 내가 사용할 스트림 변수를 선언하고 생성
			// ;로 끝나는 여러 문장 가능
			
			//buffer를 사용하면 반환되는 b의 의미 변경됨
			int b;//읽어온 개수(못 읽으면 -1) -> 스트림이 채워준 바이트 개수
			
			byte[] buffer = new byte[10];
			int sum = 0;
			while ((b = fis.read(buffer)) != -1) {// 1바이트씩 읽어서 -1이 아니라면
				// b에 바이트를 하나 읽어 왔음.
				fos.write(buffer,0,b);
				sum+=1;
			}
			System.out.println(sum);
			System.out.println("복사 종료");
			System.out.println("스트림이 닫혔습니다");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
