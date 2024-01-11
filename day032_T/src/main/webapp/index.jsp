<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.sendRedirect("main.do");
	// controller.jsp?action=main
	// .do 가 이미 C 를 호출
	// 파라미터를 절약하기위해 main.do 로 호출
%>