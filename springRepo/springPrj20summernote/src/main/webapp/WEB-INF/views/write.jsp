<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

<!-- 썸머노트 -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

</head>
<body>

	<h1>게시글 작성</h1>
	
	<form action="/app/write" method="post">
		<input type="text" name="title">
		
		<br>
		<br>
		
		<textarea id="summernote" name="content"></textarea>
		<br>
		<input type="submit" value="작성">
	</form>
	
	<script>
      $('#summernote').summernote({
        placeholder: 'Hello stand alone ui',
        tabsize: 2,
        height: 300,
        maxHeight : 600,
        minHeight : 200,
        width : 800,
        callbacks : {
        	onImageUpload : f01
        },
        toolbar: [
          ['style', ['style']],
          ['font', ['bold', 'underline', 'clear']],
          ['color', ['color']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['table', ['table']],
          ['insert', ['link', 'picture', 'video']],
          ['view', ['fullscreen', 'codeview', 'help']]
        ]
      });
      
      //썸머노트에 이미지 업로드가 발생하였을 때 동작하는 함수
      function f01(fileList){
    	  console.log(fileList);
    	  
        const fd = new FormData();

        for(let file of fileList){
          fd.append('fileList' , file);
        }

    	  $.ajax({
          url : '/app/upload' ,
          type : 'post' ,
          data : fd ,
          processData : false ,
          contentType : false ,
          dataType : 'json' ,
          success : function(changeNameList){
            console.log(changeNameList);

            for(let changeName of changeNameList){
              $("#summernote").summernote('insertImage' , '/app/resources/img/' + changeName);
            }

          } ,
          error : (error)=>{
            console.log(error);
          } ,
        });
      }
      
    </script>

</body>
</html>










