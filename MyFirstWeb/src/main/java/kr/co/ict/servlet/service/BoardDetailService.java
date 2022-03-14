package kr.co.ict.servlet.service;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

public class BoardDetailService implements IBoardService{

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String sbNum = request.getParameter("board_num");
		
		// 번호가 아무것도 없으면 에러가 뜨기 때문에 번호를 하나 주고 시작
		int bNum = 0;
		if(sbNum != null) {
		bNum = Integer.parseInt(sbNum);
		//System.out.println(bNum);
		}else {
			bNum=1;
		}
		
		// dao생성
		BoardDAO dao = BoardDAO.getInstance();
		// dao에서 해당 글번호에 대한 정보를 가져오고
		BoardVO board = dao.getBoardDetail(bNum);
		
		
		// 데이터 바인딩
		request.setAttribute("board", board);
		
	}
}
