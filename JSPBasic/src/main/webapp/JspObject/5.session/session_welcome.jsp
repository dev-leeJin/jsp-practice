<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// session은 폼을 안 쓰고도 다른 페이지로 데이터를 전송해줄 수 있는 하나의 수단입니다.(장점)
	String id = (String)session.getAttribute("session_id");
	String pw = (String)session.getAttribute("session_pw");
	String nickName = (String)session.getAttribute("session_nick");
	
	// 로그인 안 한 사용자가 오면 login페이지로 되돌려주세요.
	if(id == null){
		response.sendRedirect("session_login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=nickName %>(<%=id %>)님 로그인을 환영합니다.</h1>
	<a href="session_logout.jsp">로그아웃하기</a>
</body>
</html>