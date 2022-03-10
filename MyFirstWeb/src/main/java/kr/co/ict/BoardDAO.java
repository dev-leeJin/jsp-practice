package kr.co.ict;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	
	//DB접속에 필요한 변수들
	private DataSource ds = null;
	
	//멤버변수로 BoardDAO를 하나 생성
	private static BoardDAO dao = new BoardDAO();
	
	//Connection Pool 을 사용하여 생성자 생성
	private BoardDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//static 키워드를 이용해서 단 한번만 실행하고, 그 이후로는
	//주소를 공유하는 getInstance()메서드를 생성
	public static BoardDAO getInstance() {
		if(dao != null) {
			dao = new BoardDAO();
		}
		return dao;
	}

	// 전체 데이터(게시판 전체 목록)을 가져오기 위해 코드 로직 대체
	// 회원 전체 목록을 가져오는 getAllUserList를 수정해 getAllBoardList()를 생성
	// 1. boarTbl에 맞춰서 처리하기 위해 UserVO를 BoardVO로 변경
	// 2. 쿼리문 변경
	// 3. while문 내부에서 BoardVO 세팅이 가능하도록 rs에서 데이터 가져오는 부분을 수정
	public List<BoardVO> getAllBoardList(){ 
		ResultSet rs = null;  
		Connection con = null;
		PreparedStatement pstmt = null;
		
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			//String sql = "SELECT * FROM boardTbl" ;
			//최근 게시물이 맨 위로 올라오는 쿼리문
			String sql = "SELECT * FROM boardTbl ORDER BY board_num DESC" ;
			pstmt = con.prepareStatement(sql);
		
			rs = pstmt.executeQuery();

			while(rs.next()){
				// 7개의 컬럼 값을 받아서 변수로 저장
				int boardNum = rs.getInt("board_num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date bDate = rs.getDate("bDate");
				Date mDate = rs.getDate("mDate");
				int hit = rs.getInt("hit");
				
				// int board_num, String title, String content, String writer, Date bDate, Date mDate, int hit
				// 해당 변수를 이용해 BoardVO를 생성
				BoardVO boardData = new BoardVO(boardNum, title, content, writer, bDate, mDate, hit);
				boardList.add(boardData);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
					pstmt.close();
					rs.close();
				}catch(SQLException se) {
					se.printStackTrace();
				}
				
			}
		return boardList; 
	}
	
	// 글쓰기 기능
	// insertBoard 내부 쿼리문 실행시 필요한 3개 요소인 글제목, 본문, 글쓴이를 입력해야만 실행할 수 있게 설계합니다.
	//#INSERT기능을 사용하기 위해서는 3개의 정보가 필요
	public void insertBoard(String title, String content, String writer) {
		// DB 연결구문을 작성
		//셀렉트 구문이 아니기 때문에 resultset은 필요없다.
		//ResultSet rs = null;  
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			// INSERT의 경우 두 가지 유형이 있음
			// 전체 컬럼 요소 다 넣기 -INSERT INTO boardTbl VALUES(null, ?, ?, ?, now(), now(), 0)
			// 일부요소만 넣기 - INSERT INTO boardTbl(title, content, writer) VALUES (?, ?, ?)
			String sql = "INSERT INTO boardTbl(title, content, writer) VALUES (?, ?, ?)" ;
			pstmt = con.prepareStatement(sql);
			// 실행 전 상단 쿼리문 ? 채워넣기
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, writer);
			// 실행하기
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
			
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	// 글 한개가 필요한 상황이므로 BoardVO 하나만 처리 가능
	// SELECT * FROM boardTbl WHERE board_num = ?
	public BoardVO getBoardDetail(int board_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO board = null;
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM boardTbl WHERE board_num = ?" ;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			
			rs = pstmt.executeQuery();
			// 프라이머리키를 가진 보드넘은 있거나 없거나 둘 중 하나이기 때문에 if문을 사용해도 무방하다
			if(rs.next()) {
				int boardNum = rs.getInt("board_num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date bDate = rs.getDate("bdate");
				Date mDate = rs.getDate("mdate");
				int hit = rs.getInt("hit");
				
				board = new BoardVO(boardNum, title, content, writer, bDate, mDate, hit);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		return board;
	  }
	
	// deleteBoard 메서드를 만들어서 삭제처리가 되게 만들어주시고 
	// 서블릿에서 해당 메서드를 호출해 실제로 삭제버튼을 누르면 DB에서 해당 번호 글이 삭제되게 해주세요.
	// 비 select 구문이므로 리턴자료형 void
	
	public void deleteBoard(int boardNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			String sql = "DELETE FORM boardTbl WHERE board_num=?" ;
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, boardNum);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				con.close();
				pstmt.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
	}
	}
