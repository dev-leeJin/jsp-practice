<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/*
		application은 application 객체를 사용해서 저장하거나
		데이터값을 받아올 수 있습니다.
		
		getAttribute() 메서드와 setAttribute() 메서드를 사용할 수 있고
		
		application에 한 번 저장된 객체는
		서버 종료 전까지 계속 유지됩니다.
		
		# session같은 경우는 크롬과 엣지 (브라우저)별로 하나 하나 별개인데 application
		은 한 쪽에서 얻은 결과가 브라우저 상관없이 똑같이 반영된다.
	*/
	
	int visitCnt = 0;

	Integer temp = (Integer)application.getAttribute("visit");
	if(temp != null){
		visitCnt = temp;
	}
	visitCnt++;
	
	application.setAttribute("visit", visitCnt);
%>
<hr/>
	<h3>방문자수 : <%=visitCnt %></h3>
<hr/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>