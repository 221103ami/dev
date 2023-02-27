package com.kh.app.member;

public class MemberVo {

	private String memberId;
	private String memberPwd;
	private String memberNick;
	@Override
	public String toString() {
		return "MemberVo [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberNick=" + memberNick + "]";
	}
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVo(String memberId, String memberPwd, String memberNick) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberNick = memberNick;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	
	
	
}
