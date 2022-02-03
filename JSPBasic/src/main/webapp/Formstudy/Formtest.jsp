<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 테스트</title>
</head>
<body>
	<h1>회원 가입 양식</h1>
	<form action="" method="post">
		<input type="text" name="id" placeholder="아이디" /><br/>
		<input type="password" name="pw" placeholder="비밀번호"/><br/>
		<input type="submit" value="제출">
		<!-- 데이터를 전송할 때 쓰는 방식 2가지 -->
		
		<!-- get방식은 제출버튼을 누르면 주소창에 입력한 아이디와 비밀번호가 적혀져 나오는 것이다.
		네이버 검색창에 뭘 검색했을때 주소창에 나오는 것이 get방식이다(주소창으로 검색을 할 수도 있음) 
		(get방식은 기록이 남아 보안이 취약하기 때문에 아이디 비밀번호 정보를 담지않고 신상과 관련없는 정보를 
		쓸 때 기록을 보고 더 빨리 정보를 가져올 때 사용한다.)
		(html form태그가 반드시 필요하지는 않다(주소창에서 검색이 가능하므로)  -->
		
		<!-- post방식은 전달은 됐어도 뭐가 전달됐는지 나오지 않아 기록이 남지 않고 보안성이 우수하다.
		(아이디,비밀번호,카드번호 등과 같이 털리면 안되는 민감한 부분에 사용)
		주소창 입력이 불가능하고 form을 만들어야만 post방식을 쓸 수 있다.  -->
	</form>
</body>
</html>