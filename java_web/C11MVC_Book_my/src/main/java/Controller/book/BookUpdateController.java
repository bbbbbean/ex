package Controller.book;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.BookDto;
import Domain.Service.BookServiceImpl;

public class BookUpdateController implements SubController{
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	private BookServiceImpl bookService;
	
	public BookUpdateController() throws Exception{
		bookService = BookServiceImpl.getInstance();	
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] BookUpdateController execute..");
		
		try {
			// 파라미터
			String bookCode = req.getParameter("bookcode");
			String bookName = req.getParameter("bookname");
			String publisher = req.getParameter("publisher");
			String isbn = req.getParameter("isbn");
			// 페이지 넘버가 있으면 해당 페이지, 아니면 1페이지
			// 폼에서 빈값이어도 무조건 값이 넘어옴 -> null 체크 말고 빈문자열 판별 필요
			String pageno = req.getParameter("pageno")!=null?req.getParameter("pageno"):"1";
			// 추가적으로 판별해주기
			if(pageno.isEmpty())
				pageno = "1";
			
			BookDto bookDto = new BookDto(bookCode,bookName,publisher,isbn);
			
			// 유효성
			if(!isValid(bookDto)) {
				resp.sendRedirect(req.getContextPath()+"/book/read?bookcode="+bookCode);
			}
			// 서비스
			// boolean으로 고쳐 한 경우
			// boolean isUpdate = bookService.modifyBook(bookDto);
			
			Map<String,Object> serviceResponse = bookService.modifyBook(bookDto);
			
			Boolean status = (Boolean)serviceResponse.get("status");
			if(status)
				req.setAttribute("bookDto", serviceResponse.get("bookDto"));
			
			// 뷰
			resp.sendRedirect(req.getContextPath()+"/book/list?pageno="+pageno);
			
		}catch(Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/book/error.jsp").forward(req, resp);
			}catch(Exception e2) {}
		}
	}
	
	// 유효성 함수
	private boolean isValid(BookDto bookDto) {
		if(bookDto.getBookName().isEmpty()) {
			req.setAttribute("message", "bookName을 입력해주세요");
		}
		if(bookDto.getPublisher().isEmpty()) {
			req.setAttribute("message", "Publisher을 입력해주세요");
		}
		if(bookDto.getIsbn().isEmpty()) {
			req.setAttribute("message", "Isbn을 입력해주세요");
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
