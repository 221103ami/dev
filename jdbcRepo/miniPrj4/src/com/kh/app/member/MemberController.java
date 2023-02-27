package com.kh.app.member;

import com.kh.app.main.Main;

//데이터 받기
public class MemberController {
	
	//회원가입
	public void join() {
		
		System.out.print("아이디 : ");
		String memberId = Main.SC.nextLine();
		System.out.print("패스워드 : ");
		String memberPwd = Main.SC.nextLine();
		System.out.print("닉네임 : ");
		String memberNick = Main.SC.nextLine();
		
		MemberVo vo = new MemberVo();
		vo.setId(memberId);
		vo.setPwd(memberPwd);
		vo.setNick(memberNick);
		
		MemberService ms = new MemberService();
		
		try {
			int result = ms.join(vo);
			if(result == 1) {
				System.out.println("회원가입 성공");
			}else {
				System.out.println("회원가입 실패");
			}
		} catch (Exception e) {
			System.out.println("[ERROR-J0001]회원가입 진행중 예외발생 !!!");
			e.printStackTrace();
		}
	
	}

}






















