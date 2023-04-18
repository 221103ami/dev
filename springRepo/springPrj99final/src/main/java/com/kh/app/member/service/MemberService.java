package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

@Service
@Transactional
public class MemberService {
	
	private final SqlSessionTemplate sst;
	private final MemberDao dao;
	
	@Autowired
	public MemberService(SqlSessionTemplate sst , MemberDao dao) {
		this.sst = sst;
		this.dao = dao;
	}

	public int join(MemberVo vo) throws Exception {
		return dao.join(sst , vo);
	}

	public int checkId(String id) {
		return dao.checkId(sst , id);
	}

	public MemberVo login(MemberVo vo) {
		return dao.login(sst, vo);
	}

	public MemberVo edit(MemberVo vo) throws Exception {
		int result = dao.edit(sst , vo);
		if(result != 1) {
			throw new Exception();
		}
		return dao.selectOneByNo(sst , vo);
	}

}//class

















