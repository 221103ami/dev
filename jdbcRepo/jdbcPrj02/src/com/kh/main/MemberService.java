package com.kh.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MemberService {
	
	private final String path = "member.txt";
	File f = new File(path);

	// 회원가입 (insert)
	public void join(MemberData data) throws Exception {
		//통로 준비
		FileWriter fw = new FileWriter(f);
		
		//데이터 내보내기
		fw.write(data.getId() + "," + data.getPwd() + "," + data.getNick());
		fw.flush();
		
		//통로 닫기
		fw.close();
	}

	// 로그인 (select)
	public void login(MemberData data) throws Exception {
		//통로 준비
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		//파일에서 데이터 읽기
		String memo = br.readLine();	//user01,1234,nick01
		
		//아이디 비번 일치여부 확인
		int idx = memo.indexOf(",");
		String memoId = memo.substring(0, idx);
		
		int lastIdx = memo.lastIndexOf(",");
		String memoPwd = memo.substring(idx+1 , lastIdx); 
		
		if( data.getId().equals(memoId) && data.getPwd().equals(memoPwd)) {
			//로그인 성공 ~~~
			System.out.println("로그인 성공");
		}
		
	}

}//class


















