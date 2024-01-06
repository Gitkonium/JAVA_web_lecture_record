<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="calc.CalcBean" id="cb" />
<%--
	new를 대신하는 JSP 문법
	calc.CalcBean cb=new calc.CalcBean();
	그래서 웹에서는 기본 생성자를 사용함!
--%>
<jsp:setProperty name="cb" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두 번째 실습</title>
</head>
<body>
<% cb.calc(); %>

	<form method="POST">
		<input type="text" name="num1">
		<select name="op">
			<option>+</option>
			<option>-</option>1
		</select>
		<input type="text" name="num2">
		<input type="submit" value="계산하기">
	</form>

<hr>

	<h2>계산결과 : <jsp:getProperty name="cb" property="result" /></h2>

</body>
</html>