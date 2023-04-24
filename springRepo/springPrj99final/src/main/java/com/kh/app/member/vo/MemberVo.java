package com.kh.app.member.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberVo {
	
	private String no;
	private String id;
	private String pwd;
	private String nick;
	private MultipartFile profile;
	private String profileName;
	private String[] hobby;
	private String hobbyStr;
	private String status;
	private String enrollDate;
	private String modifyDate;
	
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
		if(hobby != null) {
			this.hobbyStr = String.join(",", hobby);
		}
	}

}













