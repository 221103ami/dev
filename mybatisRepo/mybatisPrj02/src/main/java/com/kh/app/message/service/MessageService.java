package com.kh.app.message.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.message.dao.MessageDao;
import com.kh.app.util.JDBCTemplate;

public class MessageService {

	//작성
	public int write(String msg) {

		//conn
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		//SQL
		MessageDao dao = new MessageDao();
		int result = dao.write(ss , msg);
		
		//tx || rs
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		
		//close
		ss.close();
		
		return result;
	}//method

	//삭제
	public int del(String msg) {
		
		//conn
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		//SQL
		MessageDao dao = new MessageDao();
		int result = dao.del(ss , msg);
		
		//tx || rs
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		
		//close
		ss.close();
		
		return result;
	}

	//리스트
	public List<String> selectMsgList() {
		
		//conn
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		//SQL
		MessageDao dao = new MessageDao();
		List<String> list = dao.selectMsgList(ss);
		
		//tx || rs
		
		//close
		ss.close();
		
		return list;
	}

}//class










