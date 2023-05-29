package com.kh.app.member.service;

import com.kh.app.member.vo.MemberVo;

public interface MemberServiceInter {
	
	public int join(MemberVo vo) throws Exception;

	public int checkId(String id);

	public MemberVo login(MemberVo vo);

	public MemberVo edit(MemberVo vo) throws Exception;

	public int quit(String no);

}
