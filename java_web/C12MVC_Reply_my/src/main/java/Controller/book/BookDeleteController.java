package Controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.UserDto;
import Domain.Service.BookServiceImpl;

public class BookDeleteController implements SubController {

	private HttpServletRequest req;
	private HttpServletResponse resp;
	private BookServiceImpl bookService;
	
	public BookDeleteController() throws Exception{
		bookService = BookServiceImpl.getInstance();	
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] BookDeleteController execute..");
		
		try {
			// 파라미터
			String bookCode = req.getParameter("bookcode");
			String pageno = req.getParameter("pageno")!=null?req.getParameter("pageno"):"1";
			// 추가적으로 판별해주기
			if(pageno.isEmpty())
				pageno = "1";

			// 유효성
			if(!isValid(bookCode)) {
				resp.sendRedirect(req.getContextPath()+"/book/read?bookcode="+bookCode);
			}
			
			// 서비스
			boolean isDelete = bookService.removeBook(bookCode);
			
			
			// 뷰
			resp.sendRedirect(req.getContextPath()+"/book/list?pageno="+pageno);

			
		}catch(Exception e) {
			exceptionHandler(e);
		}
	}
	
	// 유효성 함수
	private boolean isValid(String bookCode) {

		return true;
	}
	
	// 예외처리함수
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
}
