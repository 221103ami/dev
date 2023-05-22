package com.kh.app.admin.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.admin.member.service.AdminMemberService;
import com.kh.app.member.vo.MemberVo;

@Controller
@RequestMapping("admin/member")
public class AdminMemberController {
	
	private final AdminMemberService ams;
	
	@Autowired
	public AdminMemberController(AdminMemberService ams) {
		this.ams = ams;
	}

	//전체 회원 목록 조회
	@GetMapping("list")
	public String list(Model model) {
		//서비스
		List<MemberVo> list = ams.getMemberList();
		
		model.addAttribute("voList" , list);
		
		//화면작업 == 문자열 내보내기
		return "admin/member/list";
	}

}

























