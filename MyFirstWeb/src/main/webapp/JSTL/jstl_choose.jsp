<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- c태그라이브러리 쓸수있도록 지시자(디렉티브)를 작성해주세요 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//한글이 깨지지 않도록 설정
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:choose>
	<c:when test="${param.lang eq '자바'}">
		당신은 자바로 웹 개발을 합니다.
	</c:when>
	<c:when test="${param.lang eq '파이썬'}">
		당신은 파이썬으로 웹 개발을 합니다.
	</c:when>
	<c:otherwise>
		당신은 php로 웹 개발을 합니다.
	</c:otherwise>
</c:choose>


</body>
</html>