package com.kh.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.member.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberDao {

	public MemberVo login(SqlSessionTemplate sst, MemberVo vo) throws Exception {
		log.debug("login called...");
		return new MemberVo();
	}

}//class




















