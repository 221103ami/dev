package com.kh.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MemoIn {

	public void m01() throws Exception {
		
		// 파일 객체 준비
		File f = new File("abc.txt");
		
		// 통로 준비
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		// 데이터 읽고 출력
		String str = br.readLine();
		System.out.println(str);
		
	}
	
	

}//class



























