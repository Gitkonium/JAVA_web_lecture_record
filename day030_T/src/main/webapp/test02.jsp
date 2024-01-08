<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.product.*,java.util.ArrayList" %>
<jsp:useBean class="model.product.ProductDAO" id="pDAO" />
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니에 상품을 추가</title>
</head>
<body>

<%
	ArrayList<ProductDTO> cart=(ArrayList<ProductDTO>)session.getAttribute("cart");

	if(cart == null){
		cart=new ArrayList<ProductDTO>();
		session.setAttribute("cart",cart);
	}

	ProductDTO pDTO=new ProductDTO();
	int pid=Integer.parseInt(request.getParameter("pid"));
	pDTO.setPid(pid);
	pDTO=pDAO.selectOne(pDTO);
	cart.add(pDTO);
%>

<script>
	alert('추가되었습니다! :D');
	history.go(-1);
</script>

</body>
</html>