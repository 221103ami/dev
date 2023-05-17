package com.kh.app.board.reply.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.app.board.reply.service.ReplyService;
import com.kh.app.member.vo.MemberVo;

@RestController
@RequestMapping("board/reply")
public class ReplyController {
	
	private final ReplyService rs;
	
	@Autowired
	public ReplyController(ReplyService rs) {
		this.rs = rs;
	}

	//댓글 작성
	// sql ~~~
	@PostMapping("write")
	public String write(ReplyVo vo , HttpSession session) {
		
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		
		if(loginMember == null) {
			return "unauthor";
		}
		
		String writerNo = loginMember.getNo();
		vo.setWriterNo(writerNo);

		int result = rs.write(vo);
		
		if(result != 1) {
			return "fail";
		}
		
		return "ok";
	}
	
	//댓글 목록 조회
	@GetMapping("list")
	public void list() {
		
	}
	
	//댓글 삭제
	@DeleteMapping("delete")
	public void delete() {
		
	}
	
}

























