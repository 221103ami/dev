package com.kh.app.member;

public class MemberPrinter {

	public void printMember(MemberData data) {
		
		if(data.getNo() == null) {data.setNo("-");}
		if(data.getId() == null) {data.setId("-");}
		if(data.getPwd() == null) {data.setPwd("-");}
		if(data.getNick() == null) {data.setNick("-");}
		if(data.getEnrollDate() == null) {data.setEnrollDate("-");}
		if(data.getQuitYn() == null) {data.setQuitYn("-");}
		
		System.out.print(data.getNo());
		System.out.print(" / ");
		System.out.print(data.getId());
		System.out.print(" / ");
		System.out.print(data.getPwd());
		System.out.print(" / ");
		System.out.print(data.getNick());
		System.out.print(" / ");
		System.out.print(data.getEnrollDate());
		System.out.print(" / ");
		System.out.print(data.getQuitYn());
		System.out.println();
	}
	
}
