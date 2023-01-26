package com.kh.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class TestList {
	
	public void test() {
		
		ArrayList list = new ArrayList();
		
		list.add(10);
		list.add(22);
		list.add(33);
		list.add(44);
		
		int x = (int) list.get(3);
		System.out.println(x);
		
	}//method
	
	//ArrayList
	public void m01() {
		
		//List 의 구현체 ArrayList
		ArrayList list = new ArrayList();
		
		//데이터 추가
		list.add("apple");
		list.add("banana");
		list.add("orange");
		
		//모든 데이터 확인
		System.out.println(list);
		
		//데이터 꺼내기
		list.get(0);
		
		//데이터 삭제 (0번 인덱스의 데이터 삭제)
		list.remove(0);
		
		System.out.println(list);
		
	}
	
	//LinkedList
	public void m02() {
		LinkedList list = new LinkedList();
		
		//데이터 추가
		list.add("apple");
		
		//데이터 꺼내기
		list.get(0);
		
		//데이터 삭제
		list.remove(0);
	}
	
	//Set
	public void m03() {
		
		HashSet set = new HashSet();
		
		//데이터 추가
		set.add("apple");
		
		//모든 데이터 출력
		System.out.println(set);
		
		//데이터 삭제
		set.remove("apple");
		
		//모든 데이터 출력
		System.out.println(set);
	}
	
	//Map
	public void m04() {
		HashMap map = new HashMap();
		
		//데이터 추가
		map.put("one", "apple");
		
		//데이터 꺼내기
		String x = (String) map.get("one");
		System.out.println(x);
		
		//데이터 삭제
		map.remove("one");
		
		//데이터 꺼내기
		String y = (String) map.get("one");
		System.out.println(y);
	}

}//class



























