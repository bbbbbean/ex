package Controller.book;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.BookDto;
import Domain.Dto.Criteria;
import Domain.Dto.PageDto;
import Domain.Dto.UserDto;
import Domain.Service.BookServiceImpl;

public class BookListController implements SubController{

	// 리스트 형식으로 보여준 다음 생성, 조회로 빠짐
	// 조회에서 수정, 삭제로 빠짐
	// 제일 처음 보여지는 페이지인셈
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private BookServiceImpl bookService;
	
	public BookListController() throws Exception{
		this.bookService = BookServiceImpl.getInstance();	
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] BookListController execute..");
		
		try {
			// GET 방식일 경우 페이지 이동 - 여기는 get으로 오면 바로 처리 -> 해당 get 필요없음
			//String uri = req.getMethod();
			//if(uri.equals("GET")) {
			//	req.getRequestDispatcher("/WEB-INF/view/book/list.jsp").forward(req, resp);
			//	return;
			//}
			
			// 파라미터 : 페이지 수 받아야함
			String pageno = req.getParameter("pageno");
			String amount = req.getParameter("amount");
			String type = req.getParameter("type");
			String keyword = req.getParameter("keyword");
			
			
			
			Criteria criteria=null;
			if(pageno==null) {
				// 첫번째 접근
				criteria = new Criteria();	// pageno=1, amount=10, type=null, keyword=null
			}else {
				// 페이지를 누른 뒤 판단
				//criteria = new Criteria(pageno,10);
				criteria = new Criteria(pageno,10,type,keyword);
				
				long totalcount;
				PageDto page = new PageDto(totalcount,criteria);
				
				if(pageno>page.getTotalpage()) {
					pageno=page.getEndPage();
				}
			}
			
			
			
			// 입력값
			
			// 서비스
			//Map<String,Object> serviceResponse = bookService.getAllBooks(criteria);
			// 타입과 키워드가 들어오면 
			Map<String,Object> serviceResponse = bookService.getAllBooks(criteria);
			// Object들이라 형변환 필요 -> 다운캐스팅
			Boolean status = (Boolean) serviceResponse.get("status");
			PageDto pageDto = (PageDto)serviceResponse.get("pageDto");

			// 뷰
			if(status) {
				List<BookDto> list = (List<BookDto>)serviceResponse.get("list");
				req.setAttribute("list", list);
				req.setAttribute("pageDto", pageDto);
			}
			
			req.getRequestDispatcher("/WEB-INF/view/book/list.jsp").forward(req, resp);
			
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

