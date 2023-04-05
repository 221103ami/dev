package com.kh.app.message.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MessageDao {

	//작성
	public int write(SqlSession ss, String msg) {
		return ss.insert("message.write" , msg);
	}

	//삭제
	public int del(SqlSession ss, String msg) {
		return ss.delete("message.del" , msg);
	}

	//리스트
	public List<String> selectMsgList(SqlSession ss) {
		return ss.selectList("message.selectMsgList");
	}

}//class










