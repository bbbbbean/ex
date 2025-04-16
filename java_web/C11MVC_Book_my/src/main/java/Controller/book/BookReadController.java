package Controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.UserDto;
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
			String uri = req.getMethod();
			if(uri.equals("GET")) {
				req.getRequestDispatcher("/WEB-INF/view/book/read.jsp").forward(req, resp);
				return;
			}
		}catch(Exception e) {
			exceptionHandler(e);
		}
	}
	
	// 유효성 함수
	private boolean isValid(UserDto userDto) {

		return true;
	}
	
	// 예외처리함수
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}

}
