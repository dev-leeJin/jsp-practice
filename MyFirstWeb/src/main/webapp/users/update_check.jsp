<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	// 0. 한글 깨지는 문제 해결
	request.setCharacterEncoding("utf-8");
	// 1. form에서 보낸 비번, 이름, 이메일을 변수로 저장해주세요.
	String pw = request.getParameter("fpw");
  	String name = request.getParameter("fname");
  	String email = request.getParameter("femail");
	
	// 2. session에 저장된 아이디를 변수로 저장해주세요.
	String sId= (String)session.getAttribute("session_id");
	System.out.println(sId);
	// 3. DB접속정보 변수로 관리
		String dbType = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/jdbcprac1";
		String dbId = "root";
		String dbPw = "mysql";
		
		try{
	// 4. 연결
			Class.forName(dbType);
			Connection con = DriverManager.getConnection(dbUrl, dbId, dbPw);
	// 5. pstmt생성 및 ?에 값 세팅
	// 쿼리문 :
			String sql = "UPDATE userinfo SET upw = ?, uname = ?, uemail= ?  WHERE uid = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, sId);
		
	// 6. pstmt 실행 및 자원 회수
			pstmt.executeUpdate(); //조회구문(SELECT)이 아니면 executeUpdate();
			
			con.close();
			pstmt.close();
	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
	// 7. body 태그에 XXX 회원의 정보가 수정되었습니다. 라고 안내해주고
	// 웰컴페이지로 돌아갈 수 있는 링크 넣어주기.
		}
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%= sId %>회원의 정보가 수정되었습니다.</h1>
	<a href="login_form.jsp">로그인창으로 돌아가기</a>
	
</body>
</html>