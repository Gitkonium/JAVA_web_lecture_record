<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="border" %>
<%@ attribute name="bgColor" %>

<h1><jsp:doBody /></h1>
<h2>커스텀 태그의 외부에서 설정한 태그바디값을 가져오는 태그</h2>
<table border="${border}" bgColor="${bgColor}">
	<tr>
		<td>번호</td><td>이름</td>
	</tr>
	<tr>
		<td>101</td><td>작은 티모</td>
	</tr>
</table>