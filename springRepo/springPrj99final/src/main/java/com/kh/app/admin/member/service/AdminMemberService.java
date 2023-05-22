package com.kh.app.admin.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.admin.member.dao.AdminMemberDao;
import com.kh.app.member.vo.MemberVo;

@Service
@Transactional
public class AdminMemberService {
	
	
	private final AdminMemberDao dao;
	private final SqlSessionTemplate sst;
	
	@Autowired
	public AdminMemberService(AdminMemberDao dao, SqlSessionTemplate sst) {
		this.dao = dao;
		this.sst = sst;
	}

	public List<MemberVo> getMemberList() {
		return dao.getMemberList(sst);
	}

	public MemberVo getMemberByNo(String no) {
		return dao.getMemberByNo(sst , no);
	}

}






















