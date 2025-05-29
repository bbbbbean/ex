package Controller.book;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain.Dto.BookDto;
import Domain.Dto.BookReplyDto;
import Domain.Service.BookServiceImpl;

public class BookReplyCreateController implements SubController {
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	private BookServiceImpl bookService;
	
	public BookReplyCreateController() throws Exception{
		this.bookService = BookServiceImpl.getInstance();	
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] BookReplyCreateController execute..");
		
		try {
			// 파라미터 받아와서 객체 생성
			String bookCode = req.getParameter("bookCode");	// 프론트 jsp에서 정보뺀 후 js로 넘김. 비동기 처리, 주소에다가 인자 던짐
			String username = null;							// 로그인 후 세션에서 빼오기
			String contents = req.getParameter("contents");	// 프론트 jsp에서 정보뺀 후 js로 넘김. 비동기 처리, 주소에다가 인자 던짐
			LocalDateTime createAt= LocalDateTime.now();	// 백
			
			// 로그인 시 세션에 저장된 username 꺼내오기
			HttpSession session = req.getSession();
			username = (String) session.getAttribute("username");
			if(username==null) {
				throw new ServletException("로그인이 필요합니다.");
			}
			
			BookReplyDto dto = new BookReplyDto(-1,bookCode,username,contents,createAt);
			
			// 유효성
			if(!isValid(dto)) {
				;
			}
			
			// 서비스
			boolean isAdded = bookService.bookReplyAdd(dto);
			
			// 뷰
			// 지금은 JSON 타입으로 메세지 전달
			// 스프링 넘어가면 상태 코드 전달
			if(isAdded) {
				PrintWriter out = resp.getWriter();
				out.println("{\"message\":\"success!\"}");	// JSON data 전달
			}else {
				PrintWriter out = resp.getWriter();
				out.println("{\"message\":\"fail!\"}");	// JSON data 전달
			}
			
		}catch(Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/book/error.jsp").forward(req, resp);
			}catch(Exception e2) {}
		}
		
	}
	
	// Tx + 비즈니스 유효성 검사 (도서 추가)
	private boolean isValid(BookReplyDto dto) {
		// 일단 true 넣어둠 나중에 유효성 체크 해보기		
		return true;
	}
	
	// 예외처리함수
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
	
}
