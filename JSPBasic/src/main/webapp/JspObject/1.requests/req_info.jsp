<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String protocol = request.getProtocol();
	String conPath = request.getContextPath();
	StringBuffer reqUrl = request.getRequestURL();
	String reqUri = request.getRequestURI();
	int serverPort = request.getServerPort();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 내장객체는 자동으로 생성되기 때문에 new키워드와 같이 따로 실행을 해주지 않아도 된다. -->
	<!-- request는 사용자자 무엇을 요청했는지를 확인하는 것이다. -->
	
	요청 프로토콜 : <%= protocol %><br/>
	요청 컨텍스트 경로 : <%= conPath %><br/>
	요청 URL : <%=reqUrl %><br/>
	요청 URI : <%=reqUri %><br/>
	서버 포트 : <%=serverPort %>
</body>
</html>