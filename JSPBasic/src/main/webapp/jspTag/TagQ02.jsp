<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		public int total = 0;
	
		int randomNum(){
			int result =(int)(Math.random() * 9) + 1;
			return result;
		}
	%>
		<h2>랜덤 구구단(<b><%=randomNum() %></b>)단</h2>
		
	<%
		out.println("페이지 누적 요청 수 :" + ++total);
		if(total == 10){
			out.println("</br>" +"매 10번째 방문자에게는 기프티콘을 드립니다." + "</br>" + "담청되셨습니다!!");
		}
		
		
	%> 
</body>
</html>