<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board.board_num }번 글 상세페이지</h1>
	글제목 : <input type="text" value="${board.title }" readonly>
	글쓴이 : <input type="text" value="${board.writer }" readonly>
	조회수 : ${board.hit }<br/> 
	쓴날짜 : <input type="text" value="${board.bDate }" readonly>
	마지막 수정날짜 :${board.mDate }<br/>
	본문 : <textarea rows="15" cols="50">${board.content}</textarea>
	
	<a href="http://localhost:8181/MyFirstWeb/boardList.do">목록으로</a> <br/>
	
	<!-- c:if를 걸어 본인이 쓴 글에만 수정삭제가 보이게 한다.   -->
	<c:if test="${sessionScope.session_id eq board.writer }">
		<form action="http://localhost:8181/MyFirstWeb/boardDelete.do"" method="post">
			<!-- 내부를 조금 고쳐서 글 번호를 넘기도록 만들어 보내주세요.
			해당 서블릿에서 글 번호를 콘솔에 찍게도 만들어주세요. -->
			<input type="hidden" value="${board.writer }" name="writer">
			<input type="hidden" value= "${board.board_num }" name="board_num">
			<input type="submit" value="삭제하기">
		</form>
		<form action="http://localhost:8181/MyFirstWeb/boardUpdateForm.do" method="post">
			<input type="hidden" value= "${board.board_num }" name="board_num">
			<input type="submit" value="수정하기">
		</form>
	</c:if>
</body>
</html>