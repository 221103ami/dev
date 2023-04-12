package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberService {
	
	private final SqlSessionTemplate sst;
	private final MemberDao dao;
	
	@Autowired
	public MemberService(SqlSessionTemplate a , MemberDao b) {
		this.sst = a;
		this.dao = b;
	}

	public MemberVo login(MemberVo vo) throws Exception {
		log.debug("login called...");
		return dao.login(sst, vo);
	}

}//class























