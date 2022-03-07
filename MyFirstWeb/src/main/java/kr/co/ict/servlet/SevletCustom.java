package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SevletCustom
 */
@WebServlet("/banana")
public class SevletCustom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SevletCustom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("/banana 최초 접속!");
	}

	/**
	 * @see Servlet#destroy()
	 */
	// 생성될 때, 파기될 때 둘 다 관리가 가능. (서버가 꺼지기 전에 메모리에서 삭제)
	public void destroy() {
		System.out.println("/banana 접속시 생성된 객체는 서버 종료에 인해 파기됩니다.");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// get방식으로 해당 주소에 접속할 때마다 실행해주는 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/banana 주소 접속 확인");
		// 상단에 request가 선언이 되어있기 때문에 가능.
		// request.getParameter() 를 이용해 
		// "jsp", "boot" 라는 이름으로 들어온 요소를 콘솔에 찍도록 아래 코드를 작성하고
		// doGet메서드를 복사해서 보내세요.
		// 확인하는 방법은 ?jsp=값1&boot=값2 를 주소 뒤에 붙입니다.
		String jsp= request.getParameter("jsp");
		String boot= request.getParameter("boot");
		System.out.println(jsp + ", " + boot);
		// "jpa"라는 이름으로 들어온 요소를 콘솔에 찍도록 추가해주세요.
		String jpa = request.getParameter("jpa");
		System.out.println(jpa);
		
		//get방식이면 네이버로 리다이렉트
		//response.sendRedirect("http://www.naver.com");
		
		// 상단 변수를 함께 전달하 뒤해 forward를 대신 사용.
		// 포워딩 하기 전 request에 setAttribute()를 이용해 데이터를 저장합니다.(데이터 바인딩(보낼 데이터 묶기))
		// request.setAttribute("보낼이름", 자료);
		request.setAttribute("jsp", jsp);
		request.setAttribute("boot", boot);
		request.setAttribute("jpa", jpa);
		// 목적지 주소는 localhost:포트번호/프로젝트명/이후경로에서 /이후경로만 적어주면 된다. 
		RequestDispatcher dp= request.getRequestDispatcher("/servletForm/bananaResult.jsp");
		dp.forward(request, response);
				
		// 포워딩 : 서블릿에서 .jsp파일로 데이터를 보내기 위해 활용.
		// 보내기 전 request.setAttribute("변수명", 보낼자료)를 이용해 데이터 바인딩을 해 준 다음
		// RequestDispatcher를 생성해 목적지 기입 후 forward 실행시
		// 넘어간 jsp페이지에서 해당 자료를 활용할 수 있습니다. 
		// 포워딩은 일회용이라 한번만 전달되고 다른 페이지로 또 전달되지 않는다.
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost는 현재까지 배운 내용만 놓고 봤을때는 form에서 post방식으로 제출될 때 호출됩니다.
		System.out.println("/banana 주소 post방식으로 접속함");
		// servletForm 내부에 있던 bananaForm.jsp의 목적지는 그대로 두시고
		// 전송방식만 post로 바꿔서 데이터를 날려주시고
		// 받아서 처리해주세요.
		// 대신 post방식으로 전송됨을 구분하기 위해서
		// System.out.println("post방식:" + 변수명);
		request.setCharacterEncoding("utf-8");
		String jsp = request.getParameter("jsp");
		String boot = request.getParameter("boot");
		String jpa = request.getParameter("jpa");
		System.out.println("post방식으로 제출 : " + jsp + ", " + boot+ ", " + jpa );
		
		//post방식이면 네이트로 리다이렉트
		//response.sendRedirect("www.nate.com");
		
		// 아래 redirect방식 대신, bananaPostResult.jsp를 생성해주신 다음
		// post방식 처리시 포워딩으로 jsp, boot, jpa 변수가 화면에 표출되도록 해주세요.
		
		request.setAttribute("jsp", jsp);
		request.setAttribute("boot", boot);
		request.setAttribute("jpa", jpa);
		RequestDispatcher dp= request.getRequestDispatcher("/servletForm/bananaPostResult.jsp");
		dp.forward(request, response);
	
		
	}

}
