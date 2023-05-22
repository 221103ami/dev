package com.kh.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.member.vo.MemberVo;

import oracle.net.aso.af;

@Repository
public class MemberDao {

	public int join(SqlSessionTemplate sst, MemberVo vo) throws Exception {
		return sst.insert("member.join" , vo);
	}

	public int checkId(SqlSessionTemplate sst, String id) {
		return sst.selectOne("member.checkId" , id);
	}

	public MemberVo login(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("member.login" , vo);
	}

	public int edit(SqlSessionTemplate sst, MemberVo vo) {
		return sst.update("member.edit" , vo);
	}

	public MemberVo selectOneByNo(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("member.getMember" , vo);
	}

	public int quit(SqlSessionTemplate sst, String no) {
		return sst.update("member.quit" , no);
	}

}//class























