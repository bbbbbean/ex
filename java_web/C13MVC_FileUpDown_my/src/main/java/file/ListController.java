package file;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Service.FileServiceImpl;

// 업로드 할 파일 리스트 보여주기
public class ListController implements SubController{

	private FileServiceImpl fileService;
	
	public ListController() throws Exception {
		fileService = FileServiceImpl.getInstance();
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		try {
			// GET
			//if(req.getMethod().equals("GET")) {
			//	req.getRequestDispatcher("/WEB-INF/view/file/list.jsp").forward(req, resp);
			//	return;
			//}
			
			// 파라미터
			
			// 유효성
			
			
			// 리스트를 꺼내 저장 후 해당 목록 list.jsp로 던짐
			// 서비스 - domain
			Map<String,List<File>> map = fileService.getFileList();
			
			
			// 뷰
			req.setAttribute("map", map);
			req.getRequestDispatcher("/WEB-INF/view/file/list.jsp").forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
