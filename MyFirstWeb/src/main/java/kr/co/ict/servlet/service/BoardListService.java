package kr.co.ict.servlet.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

// BoardListService는 boardList접속시 사용하는 로직을 관리합니다. 
public class BoardListService implements IBoardService {
	
	// BoardListServlet에서 바인딩까지 복사해오면 됩니다.
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = BoardDAO.getInstance();
		
		List<BoardVO> boardList= dao.getAllBoardList();
	

		request.setAttribute("boardList", boardList);
	}
}
