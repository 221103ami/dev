package com.kh.main;

import java.io.File;
import java.io.FileWriter;

public class MemoOut {
	
	public void m01() throws Exception {
		// 파일 객체 준비
		File f = new File("abc.txt");
		
		// 통로 준비 (내보내기)
		FileWriter fw = new FileWriter(f);
		
		// 데이터 보내기
		fw.write("안녕ㅋㅋㅋ");
		fw.flush();
	}

}
