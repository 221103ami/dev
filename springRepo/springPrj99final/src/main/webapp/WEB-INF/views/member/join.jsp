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

        <h1 align="center">회원가입</h1>

        <main>
            <form action="${root}/member/join" method="POST" enctype="multipart/form-data" onsubmit="return checkValidation();">
                <div id="form-area">
                    <div>
                        <input type="text" name="id" placeholder="아이디">
                        <input type="button" value="중복확인" onclick="checkDup();">
                    </div>
                    <div>
                        <input type="password" name="pwd"  placeholder="패스워드">
                    </div>
                    <div>
                        <input type="password" name="pwd2"  placeholder="패스워드 확인">
                    </div>
                    <div>
                        <input type="text" name="nick" placeholder="닉네임">
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
                        <input type="submit" value="회원가입">
                    </div>
                </div>
            </form>
        </main>
        

    </div>


</body>
</html>


<script>

    //아이디 중복확인
    function checkDup(){

        //1. 현재 입력된 아이디 준비
        //2. 서버한테 아이디 전달
        //3. 결과를 받아오기 (isDup , notDup)
        //4. 결과에 따라 , 중복 여부를 알려주기
        
        const id = document.querySelector("main input[name=id]").value;
        $.ajax({
            url : '/app/member/id-check' ,
            type : 'POST' ,
            data : {
                'id' : id
            } ,
            success : function(data){
                if(data == 'notDup'){
                    alert("사용 가능한 아이디 입니다.");
                }else{
                    alert("사용 불가한 아이디 입니다.");
                }
            } ,
            error : function(e){
                console.log(e);
            } ,
        });

    }

    //비밀번호 일치해야 제출 가능하게
    function checkValidation(){
        if(!isPwdOk()){
            alert("비밀번호가 일치하지 않습니다.");
            document.querySelector("main input[name=pwd]").focus();
            return false;
        }
        return true;
    }

    function isPwdOk(){
        const pwd1 = document.querySelector("main input[name=pwd]").value;
        const pwd2 = document.querySelector("main input[name=pwd2]").value;

        if(pwd1 != pwd2) return false;
        return true;
    }

</script>