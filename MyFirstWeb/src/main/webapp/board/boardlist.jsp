<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${boardList }
	<hr/>
	<!-- 출력방법: 인덱싱이나 c:forEach를 이용해서 하나하나 꺼내준 다음
	.변수명 을 적으면 출력됩니다. -->
	전체 데이터 : ${boardList[0] }><br/>
	글번호 : ${boardList[0].board_num }<br/>
	글제목 : ${boardList[0].title }<br/>
	
	<!--# 서블릿에서 결과를 날려줘서 화면에 표출되기 때문에 결과페이지가 아닌 서블릿 페이지를 열어야 한다 -->	
</body>
</html>