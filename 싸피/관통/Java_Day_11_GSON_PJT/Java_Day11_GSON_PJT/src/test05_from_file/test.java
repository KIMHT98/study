package test05_from_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import com.google.gson.Gson;

public class test {
	public static void main(String[] args) throws IOException {
		
	
		//파일 입출력
		//FileInputStream사용
		//Byte stream => char스트림
		//속도를 빠르게 하려면 -> BufferedReader를 같이 써준다
		
		//JSON은 문자열로 저장되어 있으니깐 문자열로 입출력해줘야 함.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/refrigerator.json")));
		
		StringBuilder sb = new StringBuilder();//여러 줄을 모아서 하나의 긴 문자열 만들기
		String str = null;//한 줄씩 읽어온 것을 임시저장할 변수
		
		while((str = br.readLine())!=null) {//문자열을 읽어 왔다면(조건)
			sb.append(str);
			//sb안에 긴 문자열이 저장된다.
		}
		br.close();
		
		Gson gson = new Gson();
		Refrigerator[] arr = gson.fromJson(sb.toString(), Refrigerator[].class);
		
		System.out.println(Arrays.toString(arr));
		
		arr[0].setPrice(2000000000);
		
		BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/copy.json")));
		String str2 = gson.toJson(arr);
		bw.write(str2);
		bw.close();
	}
}
