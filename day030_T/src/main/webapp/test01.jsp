<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.product.*,java.util.ArrayList" %>
<jsp:useBean class="model.product.ProductDAO" id="pDAO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>

<%
	String member=(String)session.getAttribute("member");
	if(member==null){
%>
	<a href="test04.jsp">로그인</a> | <a href="test05.jsp">회원가입</a>
<%
	}
	else{
%>
	<a href="test06.jsp">로그아웃</a>
<%		
	}
%>

<hr>

<form method="POST" action="test02.jsp">
	 <select name="pid">
	 	<%
	 		ProductDTO pDTO=new ProductDTO();
	 		ArrayList<ProductDTO> datas=pDAO.selectAll(pDTO);
	 		for(ProductDTO data:datas) {
	 	%>
	 			<option value="<%=data.getPid()%>"><%=data.getName()%></option>
	 	<%
	 		}
	 	%>
	 </select>
	 <input type="submit" value="장바구니에 추가">
</form>
<hr>
<a href="test03.jsp">결제하기</a>

</body>
</html>