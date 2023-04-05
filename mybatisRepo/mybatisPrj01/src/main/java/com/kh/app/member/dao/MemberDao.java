package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberDao {

	//회원가입
	public int join(SqlSession ss, MemberVo vo) throws Exception {
		return ss.insert("member.join", vo);
	}

	//로그인
	public MemberVo login(SqlSession ss, MemberVo vo) throws Exception {
		return ss.selectOne("member.login" , vo);
	}

	//정보 수정
	public int edit(SqlSession ss, MemberVo vo) throws Exception {
		return ss.update("member.edit" , vo);
	}

	//회원조회 . no
	public MemberVo selectOneByNo(SqlSession ss, String no) throws Exception {
		return ss.selectOne("member.selectOneByNo" , no);
	}

	//회원탈퇴
	public int quit(SqlSession ss, String no) {
		return ss.delete("member.quit" , no);
	}

}//class













