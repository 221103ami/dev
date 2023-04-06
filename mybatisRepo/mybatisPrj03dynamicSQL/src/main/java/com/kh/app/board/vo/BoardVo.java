package com.kh.app.board.vo;

public class BoardVo {
	
	private String no;
	private String title;
	private String content;
	private String writer;
	private String enrollDate;
	private String deleteYn;
	
	public BoardVo(String no, String title, String content, String writer, String enrollDate, String deleteYn,
			String hit) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.enrollDate = enrollDate;
		this.deleteYn = deleteYn;
		this.hit = hit;
	}
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", enrollDate=" + enrollDate + ", deleteYn=" + deleteYn + ", hit=" + hit + "]";
	}
	private String hit;

}
