<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.product.*,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 페이지</title>
</head>
<body>

<%
	ArrayList<ProductDTO> cart=(ArrayList<ProductDTO>)session.getAttribute("cart");

	if(cart == null){
		out.println("결제할 상품이 없습니다!");
		// 상품 구매 페이지로 이동
	}
	else{
		int total=0;
		for(ProductDTO data:cart){
			out.println(data.getName()+" "+data.getPrice()+"원 <br>");
			total+=data.getPrice();
		}
		out.println("<hr>");
		out.println("총 결제 금액 "+total+"원");
	}
%>

</body>
</html>