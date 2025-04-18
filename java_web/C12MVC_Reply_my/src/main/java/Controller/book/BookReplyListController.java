package Controller.book;

import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import Controller.SubController;
import Domain.Dto.BookReplyDto;
import Domain.Service.BookServiceImpl;

public class BookReplyListController implements SubController {

	private HttpServletRequest req;
	private HttpServletResponse resp;
	private BookServiceImpl bookService;
	
	public BookReplyListController() throws Exception{
		this.bookService = BookServiceImpl.getInstance();	
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] BookListController execute..");
		
		try {
			// 파라미터 : 페이지 수 받아야함
			String bookCode = req.getParameter("bookCode");
			
			// 입력값
			if(!isValid(bookCode)) {
				;
			}
			// 서비스
			// 해당 북코드에 해당하는 댓글 전부 조회
			List<BookReplyDto> serviceResponse = bookService.getAllBookReply(bookCode);
			long cnt = bookService.bookReplyCount(bookCode);
			
			Map<String,Object> responseEntity = new LinkedHashMap();
			responseEntity.put("replyCnt", cnt);
			responseEntity.put("replyList", serviceResponse);

			// 뷰 (data 전달 json)
			// json <-> java 객체 : 라이브러리를 연결해 변환
			// :: List로 받은 객체를 json으로 변환 해 전달해야하니까
			resp.setContentType("application/json"); // 작성 시 응답 받는 페이지가 아 Json 타입 데이터가 오는구나 알고 대비
			ObjectMapper objectMapper = new ObjectMapper();
			
			objectMapper.registerModule(new JavaTimeModule());
			objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			
			// JsonData == String 타입, 근데 key에 value가 저장됨
			String JsonData = objectMapper.writeValueAsString(responseEntity);
			
			PrintWriter out = resp.getWriter();
			out.write(JsonData);
			
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
