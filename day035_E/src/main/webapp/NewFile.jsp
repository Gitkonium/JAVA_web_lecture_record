<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기 처리 01</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$.ajax({
		type : "GET",
		url : "json/ex.json",
		dataType : "json",
		success : function(data){
			
			$("body").append("<img alt='더미 이미지 데이터' src=img/E1ZYP8DVkAAXoHD.jpg>");
			
		},
		error : function(){
			console.log("에러발생!");
		}
	});
</script>
	<table border="1">
        <tbody>
        </tbody>
	</table>
</body>
</html>