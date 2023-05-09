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
	private final BCryptPasswordEncoder enc;
	
	@Autowired
	public MemberService(SqlSessionTemplate sst, MemberDao dao , BCryptPasswordEncoder enc) {
		this.sst = sst;
		this.dao = dao;
		this.enc = enc;
	}

	//회원가입
	public int join(Map<String, String> paramMap) {
		String pwd = paramMap.get("pwd");
		
		String newPwd = enc.encode(pwd);
		
		paramMap.put("pwd", newPwd);
		return dao.join(sst, paramMap);
	}
	
	//로그인
	public Map<String, String> login(Map<String, String> paramMap) {
		
		Map<String, String> memberMap = dao.getMember(sst, paramMap);
		
		String userPwd = paramMap.get("pwd");
		String dbPwd = memberMap.get("PWD");
		boolean result = enc.matches(userPwd, dbPwd);
		if(result) {
			return memberMap;
		}else {
			return null;
		}
	}

}








