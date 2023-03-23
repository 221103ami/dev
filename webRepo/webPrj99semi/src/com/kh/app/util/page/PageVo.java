package com.kh.app.util.page;

public class PageVo {
	
	private int listCount; 		//게시글 총 갯수
	private int currentPage;	//현재 페이지
	private int pageLimit;		//페이징 영역에 보여줄 페이지 최대갯수
	private int boardLimit;		//한 페이지에 보여줄 게시글 최대갯수
	
	private int maxPage;		//마지막 페이지 (==총페이지 수)
	private int startPage;		//페이징 영역 시작 값
	private int endPage;		//페이징 영역 마지막 값
	
	//getter
	
	
	//생성자
	public PageVo(int listCount , int currentPage, int pageLimit, int boardLimit) {
		
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		
		this.maxPage = (int)Math.ceil( (double)listCount / boardLimit );
		this.startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		this.endPage = startPage + pageLimit-1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
	}

	public int getListCount() {
		return listCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public int getBoardLimit() {
		return boardLimit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}
	
	
}//class


/*
			 * maxPage : 제일 마지막 페이지
			 * listCount , boardLimit 으로 계산
			int maxPage = (int)Math.ceil( (double)listCount / boardLimit );
			
			 *	startPage : 페이징 영역의 첫번째 값
			 *	pageLimit , currentPage
			int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
			
			int endPage = startPage + pageLimit-1;
			if(endPage > maxPage) {
				endPage = maxPage;
			}
*/







