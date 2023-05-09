package com.kh.app;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {
	
	private final SqlSessionTemplate sst;
	private final MemberDao dao;
	
	@Autowired
	public MemberService(SqlSessionTemplate sst, MemberDao dao) {
		this.sst = sst;
		this.dao = dao;
	}

	//회원가입
	public int join(Map<String, String> paramMap) {
		String pwd = paramMap.get("pwd");
		
		BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
		String newPwd = enc.encode(pwd);
		
		paramMap.put("pwd", newPwd);
		return dao.join(sst, paramMap);
	}
	
	//로그인
	public Map<String, String> login(Map<String, String> paramMap) {
		
		Map<String, String> memberMap = dao.getMember(paramMap);
		
		String userPwd = paramMap.get("pwd");
		String dbPwd = memberMap.get("pwd");
		
		
	}

}








