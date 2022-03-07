<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		
	<%-- el_obj_ok.jsp에는 폼에서 보낸 데이터를 받아서 
	body태그 내에 표현식< %= % >을 이용해
	el.obj.jsp에서 보낸 자료를 표출해주세요. --%>

<%
	String name = request.getParameter("name"); 
	String nick = request.getParameter("nick");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름 : <%= name %>
별명 : <%= nick %>

--------------------EL식 출력 방법------------------<br/>
이름 : ${param.name }<br/>  <!-- 위의 getParameter대신 쓰는 것 (자바코드 없이도 파라미터를 받을 수 있게 해줌) -->
별명 : ${param.nick }<br/>
</body>
</html>