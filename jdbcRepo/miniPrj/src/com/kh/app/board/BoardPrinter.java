package com.kh.app.board;

import java.util.List;

public class BoardPrinter {
	
	//목록조회
	public void printBoardList(List<BoardData> list) {
		
		for(BoardData data : list) {
			System.out.print(data.getNo());
			System.out.print(" / ");
			System.out.print(data.getTitle());
			System.out.print(" / ");
			System.out.print(data.getNick());
			System.out.print(" / ");
			System.out.print(data.getEnrollDate());
			System.out.println();
		}
		
	}
	
	//상세조회
	public void printBoardOne(BoardData data) {
		System.out.print(data.getNo());
		System.out.print(" / ");
		System.out.print(data.getTitle());
		System.out.print(" / ");
		System.out.print(data.getContent());
		System.out.print(" / ");
		System.out.print(data.getNick());
		System.out.print(" / ");
		System.out.print(data.getEnrollDate());
	}

}
