package com.kh.app;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {

	public int join(SqlSessionTemplate sst, Map<String, String> paramMap) {
		return sst.insert("member.join" , paramMap);
	}

}
