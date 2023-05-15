package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

//@Service
public class MemberServiceImpl implements MemberService{
	
	private final SqlSessionTemplate sst;
	private final MemberDao dao;
	
	@Autowired
	public MemberServiceImpl(SqlSessionTemplate sst, MemberDao dao) {
		this.sst = sst;
		this.dao = dao;
	}

	@Override
	public int join(MemberVo vo) {
		
		//암호화
		String pwd = vo.getPwd();
		String newPwd = pwd + "abc";
		vo.setPwd(newPwd);
		
		//dao 호출
		
		return 0;
	}
	
	

}















