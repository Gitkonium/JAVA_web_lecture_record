<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제해결방법 03</title>
</head>
<body>

가장 처음 사용하던 방식
기능을 수행하는 로직을 Servlet 클래스에 작성하고,
action 속성에 그 Servlet 경로를 작성하는 방식
 +) 서블릿에 직접 로직이 작성 x
    로직이 모듈화된 클래스를 서블릿에서 호출하여 사용 O

★ .jsp 파일이 컴파일되면 Servlet .java 가 된다!!!!!
서블릿은 클래스의 한 종류이며,
not POJO 이다!

</body>
</html>