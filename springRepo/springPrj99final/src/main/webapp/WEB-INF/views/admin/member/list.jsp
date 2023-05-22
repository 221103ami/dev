<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	tr > td ,
	tr > th {
		border : 1px solid black;
	}
</style>
</head>
<body>

	<div id="wrap">
	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			
			<table>
				<thead>
					<tr>
						<th>회원번호</th>
						<th>아이디</th>
						<th>닉네임</th>
						<th>상태</th>
						<th>가입일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${voList}" var="vo">
						<tr>
							<td>${vo.no}</td>
							<td>${vo.id}</td>
							<td>${vo.nick}</td>
							<td>${vo.status}</td>
							<td>${vo.enrollDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</main>
	
	</div>

</body>
</html>
























