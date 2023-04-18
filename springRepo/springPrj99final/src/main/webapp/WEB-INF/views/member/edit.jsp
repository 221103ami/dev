<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

    #form-area {
        border: 1px solid black;
        width: 80%;
        height: 600px;
        margin: auto;
    }

</style>
</head>
<body>

    <div id="wrap">

        <%@ include file="/WEB-INF/views/common/header.jsp" %>

        <h1 align="center">마이페이지</h1>

        <main>
            <form action="${root}/member/edit" method="POST">
                <input type="hidden" name="no" value="${loginMember.no}">
                <div id="form-area">
                    <div>
                        <input type="text" name="id" placeholder="아이디" value="${loginMember.id}">
                        
                    </div>
                    <div>
                        <input type="password" name="pwd"  placeholder="패스워드">
                    </div>
                    <div>
                        <input type="password" name="pwd2"  placeholder="패스워드 확인">
                    </div>
                    <div>
                        <input type="text" name="nick" placeholder="닉네임" value="${loginMember.nick}">
                    </div>
                    <div>
                        프로필사진 : <input type="file" name="profile">
                    </div>
                    <div>
                        <span>취미 (다중선택가능) : </span>
                        <label>
                            코딩 <input type="checkbox" name="hobby" value="20">
                        </label>
                        <label>
                            게임 <input type="checkbox" name="hobby" value="30">
                        </label>
                        <label>
                            운동 <input type="checkbox" name="hobby" value="40">
                        </label>
                        <label>
                            요리 <input type="checkbox" name="hobby" value="50">
                        </label>
                    </div>
                    <div>
                        <input type="submit" value="수정하기">
                    </div>
                </div>
            </form>
        </main>
        

    </div>


</body>
</html>


<script>
	
    const hobby = '${loginMember.hobbyStr}';
    const arr = hobby.split(",");
    
    for(let i = 0 ; i < arr.length; i++){
        const str = "input[value='" + arr[i] + "']";
        document.querySelector(str).checked = true;
    }
	
</script>














