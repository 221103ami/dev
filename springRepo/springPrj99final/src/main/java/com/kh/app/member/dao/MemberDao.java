package com.kh.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.member.vo.MemberVo;

@Repository
public class MemberDao {

	public int join(SqlSessionTemplate sst, MemberVo vo) throws Exception {
		return sst.insert("member.join" , vo);
	}

	public int checkId(SqlSessionTemplate sst, String id) {
		return sst.selectOne("member.checkId" , id);
	}

}
