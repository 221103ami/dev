package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//SQL 실행
public class MemberDao {
	
	public int join(Connection conn , MemberVo vo) throws Exception {
		String sql = "INSERT INTO MEMBER(NO, ID, PWD , NICK) VALUES(SEQ_MEMBER_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getNick());
		int result = pstmt.executeUpdate();
		return result;
	}

}
