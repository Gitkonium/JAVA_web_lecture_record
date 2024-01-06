<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String mid=request.getParameter("mid");
	session.setAttribute("mid", mid);
%>

<h1>상품목록</h1>
<hr>
<%=session.getAttribute("mid")%>님, 안녕하세요! :D
<hr>
<form action="test12.jsp" method="POST">
	<select name="product">
		<option>탕후루</option>
		<option>붕어빵</option>
		<option>마라탕</option>
		<option>민트초코</option>
		<option>파인애플피자</option>
	</select>
	<input type="submit" value="장바구니에 추가">
</form>
<hr>
<a href="test11.jsp">최종 결제하기</a>

</body>
</html>