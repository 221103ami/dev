package com.kh.app.board.vo;

import org.springframework.web.bind.annotation.RequestParam;

import lombok.Data;

@Data
public class BoardVo {

	private String no;
	private String title;
	private String content;
	private String writerNo;
	private String categoryNo;
	private String enrollDate;
	private String status;
	private String modifyDate;
	private String hit;
	
}
