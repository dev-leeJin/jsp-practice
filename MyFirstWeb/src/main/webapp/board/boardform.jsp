<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test = "${sId eq null }">
	<% response.sendRedirect("http://localhost:8181/MyFirstWeb/boardList.do"); %>
	<!-- 연속된 포워딩으로 에러가 뜨는걸 막기 위해 InsertFromService에 포워딩 대신 적는 코드 -->
</c:if>
<!DOCTYPE html>
<html>
<head>
	<!-- 로그인 안한 사람이 글쓰기페이지에 접근하면 리스트페이지로 날리기 -->
	<c:if test="${sessionScope.session_id eq null }">
		<script>
			location.href="http://localhost:8181/MyFirstWeb/boardList.do";
		</script>
	</c:if>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8181/MyFirstWeb/boardInsert.do" method ="post">
		<!-- 글쓴이는 로그인 한 사람 이름만 기입 가능 -->
		<input type="text" name="writer" value="${sessionScope.session_id }" readonly> <br/>
		<input type="text" name="title" placeholder="제목을 입력해주세요." required> <br/>
		<textarea rows="30" cols="50" name="content" placehorder="본문을 입력해주세요." required></textarea> <br/>
		<input type="submit" vlaue="글쓰기"><input type="reset" value="초기화">
	</form>
</body>
</html>