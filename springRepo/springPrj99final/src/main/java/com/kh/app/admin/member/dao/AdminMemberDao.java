package com.kh.app.admin.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.member.vo.MemberVo;

@Repository
public class AdminMemberDao {

	public List<MemberVo> getMemberList(SqlSessionTemplate sst) {
		return sst.selectList("admin.member.getMemberList");
	}

	public MemberVo getMemberByNo(SqlSessionTemplate sst, String no) {
		return sst.selectOne("admin.member.getMemberByNo" , no);
	}

}


















