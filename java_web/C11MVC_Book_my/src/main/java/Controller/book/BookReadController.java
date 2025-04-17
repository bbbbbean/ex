package Controller.book;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Service.BookServiceImpl;

public class BookReadController implements SubController{

	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	private BookServiceImpl bookService;
	
	public BookReadController() throws Exception{
		bookService = BookServiceImpl.getInstance();	
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] BookReadController execute..");
		
		try {
			// GET 방식일 경우 페이지 이동 
			//String uri = req.getMethod();
			//if(uri.equals("GET")) {
			//	req.getRequestDispatcher("/WEB-INF/view/book/read.jsp").forward(req, resp);
			//	return;
			//}
			
			// 파라미터
			String bookcode = req.getParameter("bookcode");
			String pageno = req.getParameter("pageno");
			
			// 유효성
			if(!isValid(bookcode)) {
				resp.sendRedirect(req.getContextPath()+"/book/list");
			}
			
			// 서비스
			// 애매하면 일단 다 Map<String,Object>로 받기
			Map<String,Object> serviceResponse = bookService.getBook(bookcode);
			
			
			Boolean status = (Boolean)serviceResponse.get("status");
			if(status)
				req.setAttribute("bookDto", serviceResponse.get("bookDto"));
			req.setAttribute("pageno", pageno);
			
			// 뷰
			req.getRequestDispatcher("/WEB-INF/view/book/read.jsp").forward(req, resp);
			
			
		}catch(Exception e) {
			exceptionHandler(e);
		}
	}
	
	// 유효성 함수
	private boolean isValid(String bookcode) {
		if(bookcode.isEmpty()) {
			req.setAttribute("message", "bookCode 유효성 오류");
		}
		return true;
	}
	
	// 예외처리함수
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}

}
