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
	//주소를 공요하는 getInstance()메서드를 생성
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
			String sql = "SELECT * FROM boardTbl" ;
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

}
