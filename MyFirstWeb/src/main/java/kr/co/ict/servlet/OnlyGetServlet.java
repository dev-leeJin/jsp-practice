package kr.co.ict.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getServlet")
public class OnlyGetServlet extends HttpServlet {
       
    public OnlyGetServlet() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("/getServlet 최초 접속");
	}


	public void destroy() {
		System.out.println("/getServlet 접속시 생성된 객체는 서버 종료로 인해 파기됩니다.");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/getServlet 으로 get방식 접속에 성공했습니다.");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
