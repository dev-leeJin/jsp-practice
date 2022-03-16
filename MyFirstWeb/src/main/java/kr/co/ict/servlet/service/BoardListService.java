package kr.co.ict.servlet.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

// BoardListService는 boardList접속시 사용하는 로직을 관리합니다. 
public class BoardListService implements IBoardService {
	
	// BoardListServlet에서 바인딩까지 복사해오면 됩니다.
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = BoardDAO.getInstance();
		
		List<BoardVO> boardList= dao.getAllBoardList();
	

		request.setAttribute("boardList", boardList);
		
		// 로그인 여부는 세션값을 저장한 다음, 바인딩해서 확인합니다. 
		// 서블릿 내부에서 세션쓰는 법
		// 1. 세션 객체 생성(.jsp 내부에서는 자동으로 생성되는 "내장 객체" 이지만 서블릿 로직 하에서는 생성해줘야 쓸 수 있음.)
		HttpSession session = request.getSession();
		// 2. .jsp의 스크립트릿 내부와 동일하게 세션값 얻어오기 가능(setAttribute로 저장도 가능)
		String sId = (String)session.getAttribute("session_id");
		System.out.println("로그인 여부 : " + sId);
		// 세션값 체킹이 확인되면 바인딩해서 포워딩시 세션값이 같이 넘어가도록 처리
		request.setAttribute("sId", sId);
	}
}
