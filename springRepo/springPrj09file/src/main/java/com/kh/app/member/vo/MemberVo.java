package com.kh.app.member.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberVo {
	
	private String memberId;
	private String memberPwd;
	private String memberNick;
	private MultipartFile memberProfile;
//	private List<MultipartFile> memberProfile;
	
	public boolean isProfileEmpty() {
		if (memberProfile == null) return true;
		if (memberProfile.isEmpty()) return true;
//		if (memberProfile.size() < 1) return true;
//		if (memberProfile.get(0).isEmpty()) return true;
		return false;
	}

}






