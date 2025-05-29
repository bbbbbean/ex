package Domain.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;

import file.Properties;

public class FileServiceImpl {
	
	//싱글톤 패턴
	private static FileServiceImpl instance;
	private FileServiceImpl() throws Exception {
		System.out.println("[SERVICE] UserServiceImpl init...");
	};
	public static FileServiceImpl getInstance() throws Exception {
		if(instance==null)
			instance = new FileServiceImpl();
		return instance ;
	}
	
	// 업로드 완료 여부만 확인 예정 - boolean형으로 만들기
	public boolean upload(HttpServletRequest req, XHttpServletResponse resp) throws IOException, ServletException {
		
		LocalDateTime now = LocalDateTime.now();
		// yyyyMMdd_HHmmss : 폴더명
		String folderName = now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		
		// 업로드 경로 설정
		// import 경로 조심
		String UploadPath = Properties.ROOT_PATH
							+File.separator	// "/"
							+Properties.UPLOAD_PATH
							+File.separator
							+folderName
							+File.separator;
		// 상단 경로, 이름으로 폴더 생성
		// 디렉토리 생성
		// c:\\upload\\20250421_102939\\
		File dir = new File(UploadPath);
		if(!dir.exists()) {
			// 해당 경로가 존재하지 않는다면? 디렉토리를 생성
			// make Dirs < s가 있어야 상위 폴더도 함께 만들어짐
			// mkdir : 해당 폴더만 생성
			// mkdirs : 상위 폴더가 없다면 상위 폴더도 생성
			dir.mkdirs();
		}
		
		Collection<Part> parts = req.getParts();
		for(Part part : parts) {
			System.out.println("Part's Name : "+part.getName());
			System.out.println("Part's Size : "+part.getSize());
			
			String contentDisp = part.getHeader("content-disposition");
			System.out.println("contentDisp : "+contentDisp);
			// contentDisp : form-data; name="files"; filename="1_3.PNG"
			// 우리가 추출 하려는 부분 filename의 1_3.PNG 부분 => ;으로 구분됨 : split 사용
			String [] tokens = contentDisp.split(";");
			System.out.println("tokens[2] : "+tokens[2]);
			// tokens[2] :  filename="1_3.PNG"
			// 쌍따옴표 안의 문자만 꺼내도록 2차 가공
			// 1. 문자열의 공백 제거
			// 2. filename="1_4.PNG"의 filename="는 고정 -> 시작 인덱스 10으로 지정
			// 3. 마지막 따옴표의 인덱스 번호 = 전체 길이 -1
			String filename = tokens[2].trim().substring(10,tokens[2].trim().length()-1);
			System.out.println("filename : "+filename);
			
			// 파일 업로드
			part.write(UploadPath+filename);
		}
		
		return true;
	}
	
	// 파일 리스트 확인
	public Map<String,List<File>> getFileList() {
		
		// 폴더
		Map<String,List<File>> map = new LinkedHashMap();
		
		// 경로 들고오기
		String UploadPath = Properties.ROOT_PATH
				+File.separator	// "/"
				+Properties.UPLOAD_PATH;
		
		File dir = new File(UploadPath);
		if(dir.exists()&&dir.isDirectory()) {
			// 존재하고 폴더인지 판별
			File [] folders = dir.listFiles();
			Arrays.stream(folders).forEach(System.out::println); // 폴더 경로들 전부 출력됨 (yyyyMMdd_hhmmss)
			for(File folder : folders) { // 각 폴더들 접근
				File[] list = folder.listFiles();	// 폴더 내 파일
				// map.put("폴더명","파일리스트");
				// 컬렉션으로 다듬어 넣기
				map.put(folder.getName(),Arrays.stream(list).collect(Collectors.toList()));
				// 폴더 명과 개별 파일 출력 확인
				// System.out.println("dir : "+folder.getName());
				// Arrays.stream(list).forEach(System.out::println);
				
				
			}
		}
		
		return map;
	}
	public boolean download(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// 파라미터 받기
		String folder = req.getParameter("folder");
		String filename = req.getParameter("filename");
		System.out.println("filename : "+filename+" folder : "+folder );
		
		String downloadPath = ""; 	// ROOTPATH + / + UPLOAD_PATH + / +FOLDER + / + FILENAME
		downloadPath = Properties.ROOT_PATH
					   + File.separator
					   + Properties.UPLOAD_PATH
					   + File.separator
					   + folder
					   + File.separator
					   + filename;
		
		//Response Header 지정!!!!
		resp.setHeader("Content-Type","application/octet-stream;charset-utf-8");
		resp.setHeader("Content-Disposition","attachment; filename="+URLEncoder.encode(filename,"UTF-8").replaceAll("\\+",""));
		
		FileInputStream fin = new FileInputStream(downloadPath);
		ServletOutputStream bout = resp.getOutputStream();
		
		byte[] buff = new byte[4096];
		while(true){
			int data = fin.read(buff);
			if(data==-1)
				break;
			bout.write(buff,0,data);
			bout.flush();
		}
		bout.close();
		fin.close();
		
		
		return false;
	}
	
	
	
}
