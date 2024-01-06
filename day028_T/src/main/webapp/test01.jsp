<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫 번째 실습</title>
</head>
<body>
<%
	int result=0;

// 처음 페이지를 보여달라는 요청은 GET(디폴트 요청)
if(request.getMethod().equals("POST")){
	// 웹에서의 모든 데이터는 String 타입!
	int num1=Integer.parseInt(request.getParameter("num1"));
	String op=request.getParameter("op");
	int num2=Integer.parseInt(request.getParameter("num2"));
	
	if(op.equals("+")){
		result=num1+num2;
	}
	else{
		result=num1-num2;
	}
}
%>

	<form method="POST">
		<input type="text" name="num1">
		<select name="op">
			<option>+</option>
			<option>-</option>
		</select>
		<input type="text" name="num2">
		<input type="submit" value="계산하기">
	</form>

<hr>

	<h2>계산결과 : <%=result%></h2>

</body>
</html>