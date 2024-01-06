<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니에 상품을 추가</title>
</head>
<body>

<%
	ArrayList<String> cart=(ArrayList<String>)session.getAttribute("cart");

	if(cart == null){ // 첫구매라서 장바구니가 없었다면
		cart=new ArrayList<String>();
		session.setAttribute("cart",cart);
	}

	String product=request.getParameter("product");
	cart.add(product);
%>

<script>
	alert('<%=product%>이(가) 추가되었습니다! :D');
	history.go(-1);
</script>

</body>
</html>