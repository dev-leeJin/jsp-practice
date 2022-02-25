<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- el같은 경우는 없으면 없는대로 있으면 있는대로 출력(오류를 최대한 안냄) -->
	<!-- 스크립트릿 없이도 바로 출력 가능 (달러 중괄호 안에있는 내용 출력)-->
	${10}<br/>
	${3.14 }<br/>
	${"hello" }<br/>
	${true }<br/>
	${a + 20 }<br/> <!-- a가 존재하지 않는데 에러를 표출하지 않고 a를 0으로 판단 (실제로 더함) -->
	a + 20 <br/> <!-- 더하지 않고 화면에 그대로 표출 -->
	<hr/>
	${a } <br/> <!--  없으면 출력을 안함 -->
	${a < 10 } <br/> 
	${(a==15) ? "a는 15와 같다" : "a는 15와 다르다" } <br/> <!-- 3항 연산자도 가능 -->
	${(a>10)||(a!=15) } 
</body>
</html>