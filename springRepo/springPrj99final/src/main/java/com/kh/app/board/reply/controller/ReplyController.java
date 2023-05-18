package com.kh.app.board.reply.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.kh.app.board.reply.service.ReplyService;
import com.kh.app.board.reply.vo.ReplyVo;
import com.kh.app.member.vo.MemberVo;

@RestController
@RequestMapping("board/reply")
public class ReplyController {
	
	private final Gson gson;
	private final ReplyService rs;
	
	@Autowired
	public ReplyController(ReplyService rs , Gson gson) {
		this.rs = rs;
		this.gson = gson;
	}

	//댓글 작성
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
	public String list(String bno) {
		
		//서비스
		List<ReplyVo> list = rs.getReplyList(bno);
		
		String str = gson.toJson(list);
		
		//화면 == 문자열내보내기
		return str;
	}
	
	//댓글 삭제
	@DeleteMapping("delete")
	public String delete(String rno , HttpSession session) throws Exception {
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		if(loginMember == null) {
			throw new Exception("로그인 plz");
		}
		String memberNo = loginMember.getNo();
		
		ReplyVo rvo = new ReplyVo();
		rvo.setNo(rno);
		rvo.setWriterNo(memberNo);
		
		int result = rs.delete(rvo);
		
		if(result == 1) {
			return "del-ok";
		}else {
			return "del-fail";
		}
	}
	
	//댓글 수정
	@PostMapping("edit")
	public String edit(ReplyVo vo , HttpSession session) {
		
		//작성자 번호 셋팅
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		if(loginMember == null) {
			throw new IllegalStateException("로그인 하고 오세요 ~~~");
		}
		vo.setWriterNo(loginMember.getNo());
		
		System.out.println(vo);
		
		//서비스
		int result = rs.edit(vo);
		
		//문자열 내보내기
		if(result == 1) {
			return "edit-ok";
		}else {
			return "edit-fail";
		}
	}
	
}

























