<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가고싶은 여행지들</title>
</head>
<body>
	<%--
		form태그를 만들어주시고 목적지는 travel_check.jsp, post방식입니다.
		라디오 버튼을 최소 4개 만들어주세요.
		각 라디오버튼에는 속성으로 value= 이라고 해서 뭘 선택했는지 식별할 수 있도록
		각 버튼별로 다른 value값을 지정해주세요.
		
		submit버튼도 하나 만들어주세요.
	 --%>
	 <form action="travel_check.jsp" method="post">
	 	캐나다<input type="radio" name="city" value="Canada"/> <br/>
	 	유럽<input type="radio" name="city" value="Europe"/> <br/>
	 	미국<input type="radio" name="city" value="States"/><br/>
	 	일본<input type="radio" name="city" value="Japan"/><br/>
	 	<input type="submit" value="여행가기">
	 </form>
</body>
</html>