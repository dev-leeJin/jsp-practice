<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// post방식으로 전송된 한글이 깨지는 경우 한 줄 아래 코드로 인코딩하면 됩니다.
	// (get방식은 깨지지 않음)
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
	<%if(id.equals("dlckdgns")){ %>
	<h1>중복된 아이디로 가입할 수 없습니다.</h1>
	<%}else{ %>
	<h1><%=id %>(<%=name %>)님 회원가입을 축하드립니다.</h1>
	<%} %>
</body>
</html>