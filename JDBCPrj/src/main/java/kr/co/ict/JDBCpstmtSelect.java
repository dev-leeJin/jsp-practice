package kr.co.ict;
import java.sql.*;
import java.util.Scanner;

public class JDBCpstmtSelect {

	public static void main(String[] args) {
		// DB지정, 연결까지 직접 해 보세요.
		// DB종류, 스키마주소, 계정명, 비번은 변수로 관리합니다. 
		String dbType = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/jdbcprac1";
		String dbId = "root";
		String dbPw = "mysql";
		
		try {
			// 0. 사용자한테 조회할 아이디 입력받기
			Scanner scan = new Scanner(System.in);
			System.out.println("조회하고 싶은 아이디를 입력해주세요.");
			String uId = scan.nextLine();
			
			// 1. DB종류 지정
			Class.forName(dbType);
			// 2. DB연결
			Connection con = DriverManager.getConnection(dbUrl, dbId, dbPw);
			// 3. PreparedStatment구문은 먼저 SQL쿼리문을 만들어놓고 적용합니다. (반대)
			//    중간에 사용자 입력 정보를 받는 부분을 전부 ? 로만 치환해서 처리합니다.
			//    ?는 2개 이상 쓸 수도 있습니다.
			String sql = "SELECT * FROM userinfo WHERE uid = ?";
			
			// 	  pstmt 변수를 만들어 세팅합니다. <prepared 와 prepare의 구분> 
			PreparedStatement pstmt = con.prepareStatement(sql);
			//    ?에 들어갈 자료를 정의해줍니다.
			pstmt.setString(1, uId); // 1번째 ? 자리에 uId를 넣어주겠다는 의미
			// 4. 쿼리문 실행
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
