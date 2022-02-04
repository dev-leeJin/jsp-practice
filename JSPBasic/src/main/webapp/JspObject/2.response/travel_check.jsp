<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// radio는 여러 대상 중 하나만 선택할 수 있기 때문에 데이터가 무조건 하나만 넘어오는것이 담보됩니다.
	String cityName= request.getParameter("city");
	// 콘솔을 이용해 전달데이터 확인
	System.out.println(cityName);
	
	if(cityName.equals("Canada")){
		response.sendRedirect("travel_Canada.jsp");
	}else if(cityName.equals("Europe")){
		response.sendRedirect("travel_Europe.jsp");
	}else if(cityName.equals("States")){
		response.sendRedirect("travel_States.jsp");
	}else if(cityName.equals("Japan")){
		response.sendRedirect("travel_Japan.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>