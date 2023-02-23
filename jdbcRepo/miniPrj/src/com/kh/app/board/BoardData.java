package com.kh.app.board;

public class BoardData {
	
	private String no; 
	private String title; 
	private String content; 
	private String writer; 
	private String enrollDate; 
	private String nick;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public BoardData(String no, String title, String content, String writer, String enrollDate, String nick) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.enrollDate = enrollDate;
		this.nick = nick;
	}
	public BoardData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BoardData [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", enrollDate=" + enrollDate + ", nick=" + nick + "]";
	} 
	
	

}
