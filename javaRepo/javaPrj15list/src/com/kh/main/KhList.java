package com.kh.main;

public class KhList {
	
	int[] arr = new int[3];
	int empty = 0;
	
	
	public int get(int n) {
		return arr[n];
	}
	
	
	public void add(int value) {
		increaseArr();
		arr[empty] = value;
		empty++;
	}//method
	
	
	public void increaseArr() {
		if(arr.length == empty) {
			
			int[] tempArr = new int[arr.length * 2];
			
			//arr -> tempArr
			for(int i = 0 ; i < arr.length; ++i) {
				tempArr[i] = arr[i];
			}
			
			arr = tempArr;
		}
	}//method

}//class


























