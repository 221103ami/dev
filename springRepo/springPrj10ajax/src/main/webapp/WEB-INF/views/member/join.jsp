<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>

	<h1>회원가입</h1>
	
    <form action="~~~~~" method="POST">

        <input type="text" name="id" placeholder="아이디">
        <button type="button" onclick="checkDup();">중복검사</button>
        <br>
        <input type="password" name="pwd" placeholder="비밀번호">
        <br>
        <input type="submit" value="가입하기">

    </form>
	

</body>
</html>


<script>

    //중복검사
    function checkDup(){
        //서버한테 요청 보내기
        //아이디를 포함해서
        //기대하는 응답결과는,,, 화면 ㄴㄴ   yes || no ㅇㅋ
        //순수하게 js의 ajax 를 사용해도 되지만,,,
        //제이쿼리의 ajax 메소드를 사용

        const str = document.querySelector("input[name=id]").value;

        $.ajax({
            url : "/app/member/idCheckklasjdghfjkgasdjk" , 
            method : "POST" ,
            data : {
                "mid" : str ,
            } ,
            success : function(data){
                console.log("통신성공!");
                console.log(data);

                if(data == 'good') {
                    alert('사용가능한 아이디입니다.');
                }else {
                    alert('사용불가한 아이디입니다.');
                }

            } ,
            error : function(e){
                console.log("통신 실패 ...");
                console.log(e);
            } ,
        });

    }
    

</script>