<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #notice-area{
        width: 600px;
        margin: auto;
        display: grid;
        grid-template-columns: repeat(2, 100px 200px);
        grid-template-rows: 30px 30px 300px;
    }

    #notice-area > div:not(:nth-child(2) , :last-child) {
        text-align: center;
    }

    #notice-area > div:nth-child(2) ,
    #notice-area > div:last-child
    {
        grid-column: span 3;
    }

    #notice-area > div {
        border: 1px solid black;
    }
</style>
</head>
<body>

    <div id="wrap">

        <%@ include file="/WEB-INF/views/common/header.jsp" %>
        
        <main>

            <h1 align="center">공지사항 상세조회</h1>

            <div id="notice-area">
                <div>제목</div>
                <div>${vo.title}</div>
                <div>작성일자</div>
                <div>${vo.enrollDate}</div>
                <div>조회수</div>
                <div>${vo.hit}</div>
                <div>내용</div>
                <div>${vo.content}</div>
            </div>

        </main>

    </div>

</body>
</html>