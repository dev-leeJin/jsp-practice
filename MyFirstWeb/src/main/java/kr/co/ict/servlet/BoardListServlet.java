package kr.co.ict.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/boardList")// 이건 프론트컨트롤러 도입 전 파일이라 신경 안쓰셔도 됩니다.
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 접속시 BoardDAO생성 
			BoardDAO dao = BoardDAO.getInstance();
			System.out.println("DAO생성완료");
			// 구문 하나마다 콘솔에 찍으면 어디까지 실행되고 막히는지
			// 파악할 수 있다. (디버깅)
			
		//2. BoardDAO의 getAllBoardList() 호출해 전체 게시글 정보 받아오기
			//List<BoardVO> boardList= dao.getAllBoardList();
			//System.out.println(boardList);
			
		//3. request.setAttribute로 바인딩하기
		//List<BoardVO> boardList를 바로 바운딩할수도 있습니다.	
			//request.setAttribute("boardList", boardList);
			
		//4. /board/boardlist.jsp로 포워딩하기
		// 포워딩 후 el로 바인딩한 자료를 화면에 뿌려보세요.
		//#포워딩용 주소와 리다이렉트용 주소가 다름(포워딩은 앞에부분 생략)
			RequestDispatcher dp= request.getRequestDispatcher("/board/boardlist.jsp");
			dp.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
