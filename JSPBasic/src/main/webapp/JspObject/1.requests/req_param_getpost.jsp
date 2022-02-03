<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// name "apple"에 딸려온 데이터 조회
	String id = request.getParameter("apple");
	// name "banana"에 딸려온 데이터를 변수 pw에 저장 후 body에 출력
	String pw = request.getParameter("banana");
	// checkbox에 딸려온 데이터를 변수 hobby에 저장 후 body에 출력
	//String hobby=request.getParameter("hobby");
	// getParameter은 단수로 하나만 가져오기 때문에 맨 앞에 하나만 인식하고
	// 나머지는 인식못한다는 문제점이 생긴다.
	// 배열로 복수를 가져올 수 있는 values를 사용한다.
	String[] hobby=request.getParameterValues("hobby");
	String gg=request.getParameter("gg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> <!-- 전송을 했을때 받을 곳 -->

	전송받은 아이디 : <%= id %> <br/>
	전송받은 비밀번호 : <%= pw  %> <br/>
	<!-- 참조형 변수이기 때문에 그냥 hobby만 작성하면 주소가 나온다. -->
	전송받은 취미 : <%= Arrays.toString(hobby) %> <br/>
	
	전송받은 전공 : <%= gg %> <br/>
	
	<hr>
	취미를 for문으로 출력하기<br/>
	<% for(String name : hobby){ %>
		<%= name %> &nbsp;
	<%} %>

</body>
</html>