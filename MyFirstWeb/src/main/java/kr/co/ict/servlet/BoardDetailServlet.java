package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/boarddetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.getParameter를 이용해 글번호부터 가져옵니다.
		// board_num으로 가져옵니다. int로 자료형도 바꿔주세요,
		String sbNum = request.getParameter("board_num");
		int bNum = Integer.parseInt(sbNum);
		//System.out.println(bNum);
		
		// dao생성
		BoardDAO dao = BoardDAO.getInstance();
		
		// dao에서 해당 글번호에 대한 정보를 가져오고
		BoardVO board = dao.getBoardDetail(bNum);
		
		// 정보가 제대로 들어왔는지 디버깅 해보기
		// 페이지 주소 뒤에 ?board_num=숫자 넣어서 확인
		//System.out.println(board);
		
		// 데이터 바인딩
		request.setAttribute("board", board);
		
		// 디테일페이지로 포워딩
		RequestDispatcher dp= request.getRequestDispatcher("/board/boarddetail.jsp");
		dp.forward(request, response);
	}

}
