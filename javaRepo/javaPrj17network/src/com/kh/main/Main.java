package com.kh.main;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("===== 네트워크 (서버) =====");
		
		ServerSocket ss = new ServerSocket(12345);
		
		System.out.println("서버소켓이 요청 대기중 ....");
		Socket socket = ss.accept();
		System.out.println("연결완료!");
		System.out.println("연결된 소켓 정보 : " + socket);
		
		//연결 통로 생성
		OutputStream os = socket.getOutputStream();
		PrintWriter w = new PrintWriter(os);
		
		//통로 이용해서 글자 내보내기
		w.println("hello world ~~~ !!! this is server~~~ !나는서버 ㅋㅋ");
		w.flush();
	}

}//class




























