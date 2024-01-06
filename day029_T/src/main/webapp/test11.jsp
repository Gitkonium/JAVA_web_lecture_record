<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>결제 페이지</h1>

<%
	ArrayList<String> cart=(ArrayList<String>)session.getAttribute("cart");

	if(cart == null){
		out.println("결제할 상품이 없습니다!");
		// 상품 구매 페이지로 이동
	}
	else{
		for(String data:cart){
			out.println(data+"<br>");
		}
	}
%>

</body>
</html>