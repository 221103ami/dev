package com.kh.app.board.vo;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.kh.app.common.file.FileVo;

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
	private String categoryName;
	private String writerName;
	private List<FileVo> attList;
	
}



















