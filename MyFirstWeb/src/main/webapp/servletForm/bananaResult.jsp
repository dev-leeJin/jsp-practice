<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- get방식일때 리다이렉트로 bananaResult 페이지로 올 경우 -->
	<h1>ServletCustom을 통해 건너온 페이지입니다.</h1>
	<h2>get 방식</h2>
	<!-- 해당 페이지 내에 선언구문이 없는 자료 출력시는 EL을 씁니다. -->
	<p>jsp변수에 들어있던 값: ${jsp }</p>
	<p>boot변수에 들어있던 값: ${boot }</p>
	<p>jpa변수에 들어있던 값: ${jpa }</p>
	
	<!-- 폼에서 서블릿으로 넘어갈때는 데이터가 존재하지만 서블릿에서 결과페이지로 넘어갈때
	데이터가 소실된다. 그래서 데이터는 나오지 않는다.  -->
	<!-- #리다이렉트 방식은 페이지만 이동하고 변수(데이터)는 전송하지 않는다. 
	데이터까지 전송하려면 forward포워드를 해줘야 한다.  -->
</body>
</html>