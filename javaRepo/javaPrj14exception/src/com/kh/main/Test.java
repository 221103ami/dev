package com.kh.main;

public class Test {
	
	public void m01() {
		System.out.println("m01 start...");
		
		int[] arr = new int[3];
		
		try 
		{
			System.out.println(arr[9]);
		}
		catch(ArrayIndexOutOfBoundsException x)
		{
			System.out.println(x);
		}
		catch(Exception y) 
		{
			System.out.println(y);
		}
		
		System.out.println("m01 end ...");
	}
	
	public void m02() throws Exception {
		System.out.println("m02 start");
		
		int x = 1 / 0;
		
		System.out.println("m02 end");
	}

	public boolean join(String id, String pwd) throws Exception {
		
		//아이디 2글자 이상인지
		if(id.length() < 2) {
			throw new Exception("아이디가 2글자 미만입니다.");
		}
		
		//패스워드 4글자 이상인지
		if(pwd.length() < 4) {
			throw new Exception("패스워드가 4글자 미만입니다.");
		}
		
		//위 조건 다 ㅇㅋ => 회원가입 진행
		return true;
	}

}//class
























