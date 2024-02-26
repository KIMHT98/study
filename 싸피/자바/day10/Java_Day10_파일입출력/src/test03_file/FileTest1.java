package test03_file;

import java.io.File;

public class FileTest1 {
	public static void main(String[] args) {
		//File클래스 : 파일 또는 폴더를 관리하기 위한 클래스
		
		File f = new File("big_input.txt");//File객체 생성
		//상대 경로 -> 실행지점(같은 폴더)에 있는 파일의 이름? 
		
		System.out.println(f.getName());
		System.out.println(f.getAbsolutePath()); //절대경로
		System.out.println(f.isDirectory()); //폴더인지?
		System.out.println(f.isFile());// 파일인지?
		
		File folder = new File("folder");
		folder.mkdir();//디렉터리를 만들겠다. -> 상대경로에 폴더 만들어짐
		System.out.println(folder.isDirectory());
	}
}
