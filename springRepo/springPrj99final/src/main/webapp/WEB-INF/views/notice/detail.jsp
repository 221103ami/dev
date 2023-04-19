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

    #notice-area input ,
    #notice-area textarea {
        width: 100%;
        height: 100%;
        resize: none;
    }

    .view-area{display: none;}
    .form-area{display: none;}

    .active{
        display: block;
    }

</style>
</head>
<body>

    <div id="wrap">

        <%@ include file="/WEB-INF/views/common/header.jsp" %>
        
        <main>

            <h1 align="center">공지사항 상세조회</h1>

            <div class="view-area active">
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
                <div id="notice-btn-area">
                    <button onclick="toggleActive();">수정하기</button>
                    <button onclick="location.href='${root}/notice/delete?num=${vo.no}'">삭제하기</button>
                </div>
            </div>


            <div class="form-area">
                <form action="${root}/notice/edit" method="POST">
                    <input type="hidden" name="no" value="${vo.no}">
                    <div id="notice-area">
                        <div>제목</div>
                        <div><input type="text" name="title" value="${vo.title}"></div>
                        <div>작성일자</div>
                        <div>${vo.enrollDate}</div>
                        <div>조회수</div>
                        <div>${vo.hit}</div>
                        <div>내용</div>
                        <div><textarea name="content">${vo.content}</textarea></div>
                    </div>
                    <input type="submit" value="공지사항수정하기">
                </form>
            </div>


            

        </main>

    </div>

</body>
</html>

<script>

    //수정하기 버튼 클릭 시 동작하는 내용
    function toggleActive(){
        const viewArea = document.querySelector(".view-area");
        const formArea = document.querySelector(".form-area");

        viewArea.classList.remove('active');
        formArea.classList.add("active");
    }

</script>