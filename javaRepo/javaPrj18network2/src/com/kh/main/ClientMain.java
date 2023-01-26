package com.kh.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {

	public static void main(String[] args) throws Exception {
		
		System.out.println("===== 소켓 프로그래밍 (클라이언트) =====");
		
		Socket s = new Socket("127.0.0.1" , 12345);
		
		System.out.println("소켓 정보 : " + s);
		
		//연결 통로 생성
		InputStream is = s.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		//통로 이용해서 글자 읽어들이기
		String msg = br.readLine();
		System.out.println("전달받은 메세지 : " + msg);

	}//main

}//class
























