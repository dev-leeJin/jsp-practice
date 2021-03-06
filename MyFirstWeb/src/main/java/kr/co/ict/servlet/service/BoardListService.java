package kr.co.ict.servlet.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardDTO;
import kr.co.ict.BoardVO;

// BoardListService는 boardList접속시 사용하는 로직을 관리합니다. 
public class BoardListService implements IBoardService {
	
	// BoardListServlet에서 바인딩까지 복사해오면 됩니다.
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 페이지 번호를 get방식으로 가져옵니다. 저장받아 주세요(?pageNum = 번호 형식으로 받아옵니다.)
		//int pNum = Integer.parseInt(request.getParameter("pageNum"));
		String strpNum = request.getParameter("pageNum");
		int pNum =0;
		//if(strpNum == null) {
		//	pNum = 1;
		//}else {
		//	pNum = Integer.parseInt(strpNum);
		//}
		
		// 페이지 넘에 얼토당토 않은 것이 들어와도 넘어가게
		try {
			pNum = Integer.parseInt(strpNum);
		}catch(Exception e) {
			pNum = 1;
		}
		
		BoardDAO dao = BoardDAO.getInstance();
		
		// 페이징 처리에 따라 추가적으로 페이지 번호를 넣어줘야함
		List<BoardVO> boardList= dao.getAllBoardList(pNum);
	

		request.setAttribute("boardList", boardList);
		
		// 페이지 버튼 생성을 위한 글 개수 확인하기
		int boardCount = dao.getPageNum();
		// 아래에 DTO 생성 후 바인딩
		BoardDTO dto = new BoardDTO(boardCount , pNum);
		System.out.println("페이징 처리 정보 : " + dto);
		request.setAttribute("dto", dto);
		// 바인딩된 정보를 boardList.jsp 하단에 디버깅시켜주세요.
		
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
