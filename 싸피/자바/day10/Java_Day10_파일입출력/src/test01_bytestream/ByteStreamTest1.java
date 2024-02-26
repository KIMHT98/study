package test01_bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest1 {
	public static void main(String[] args) {
		// ByteStream을 이용해서 이미지를 입출력
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("dog.jpg");
			fos = new FileOutputStream("dog_copy.jpg");

			int b;
			// 파일로부터 읽어올 데이터를 임시 저장할 변수
			// 1바이트씩 저장, 더이상 읽을 값이 없으면 -1

			while ((b = fis.read()) != -1) {// 1바이트씩 읽어서 -1이 아니라면
				// b에 바이트를 하나 읽어 왔음.
				fos.write(b);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// fis가 null일 수 있음
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
				System.out.println("스트림이 닫혔습니다");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("복사 종료");
	}
}
