package com.kh.app.main;

import com.kh.app.board.BoardService;
import com.kh.app.member.MemberService;

public class MainService {

	private final MainMenu menu = new MainMenu();
	private final MemberService ms = new MemberService();
	private final BoardService bs = new BoardService();
	
	public void start() throws Exception {
		
		//메뉴 보여주기
		menu.showMenu();
		
		//입력받기
		System.out.print("원하는 메뉴 번호 입력 : ");
		String input = Main.SC.nextLine();
		
		//서비스 실행
		switch(input) {
		case "1" : ms.join(); break;
		case "2" : ms.login(); break;
		case "3" : ms.edit(); break;
		case "4" : ms.quit(); break;
		case "5" : ms.selectList(); break;
		case "6" : bs.write(); break;
		case "7" : bs.selectList(); break;
		case "8" : bs.selectOne(); break;
		case "9" : bs.update(); break;
		case "10" : bs.delete(); break;
		}
	}

}
