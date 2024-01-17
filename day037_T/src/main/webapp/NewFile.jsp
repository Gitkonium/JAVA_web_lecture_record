<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="kim" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커스텀 태그 실습</title>
</head>
<body>

	<h1><kim:printMsg /></h1>
	<hr>
	<kim:attributeTag border='5' bgColor='lightpink'>태그바디</kim:attributeTag>

</body>
</html>