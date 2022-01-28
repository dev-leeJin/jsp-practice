<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script>
		// 자바스크립트를 중간에 이렇게 삽입 했었듯이 스크립트릿도 똑같이 한다.
	</script>
<meta charset="UTF-8">
<title>JSP 1일차 공부</title>
</head>
<body>
	<!-- JSP에서는 스크립트릿이라는 태그(꺽쇠 퍼센트)를 이용해서
	JS의 script태그처럼 내부에 자바 구문을 작성할 수 있습니다. -->
	<!-- jsp문법은 html이나 다른 확장자에서는 사용이 불가능하다. -->
	<% for(int i=0; i<3; i++){ %>
	<h2>이클립스와 톰캣으로 페이지 렌더링</h2>
	<p>
		안녕하세요. 오늘은 2022년 1월 28일 금요일입니다.<br/>
		개발환경 설정 후 페이지 실행여부를 테스트 중입니다.
	</p>
	<% } %>
</body>
</html>