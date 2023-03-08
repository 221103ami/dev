<%@ 
	page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList"
%>
    
    <%
    	new ArrayList();
    
    	//자바코드주석 ㅋㅋ
		String memberId = (String)request.getAttribute("memberId");
    
    	m01();
	%>
	
	<%!
		private String name;
		private String age;
	
	    public void m01(){
			
		}
	%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- HTML 주석 ㅋㅋ -->

	<h1> <%= memberId %> 님 회원가입 성공 !</h1>
	
	<%-- JSP 주석 ㅎㅎ --%>
	
	<%-- <%@ include file="/WEB-INF/views/member/joinForm.jsp" %> --%>

</body>
</html>






