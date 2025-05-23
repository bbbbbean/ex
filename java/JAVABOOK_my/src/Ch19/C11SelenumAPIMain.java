package Ch19;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//크롬서버.jar 다운로드 경로(셀레니움 공식 홈페이지)
//https://www.selenium.dev/downloads/

//크롬드라이브 다운로드 경로
//https://googlechromelabs.github.io/chrome-for-testing/#stable

public class C11SelenumAPIMain {
	
	private static final String WEB_DRIVER_ID="webdriver.chrome.driver";
	private static final String WEB_DRIVER_PATH="src/Drivers/chromedriver.exe";
	
	public static void main(String[] args) throws Exception {
		// 사람이 하는 거랑 동일 = 봇처리 피할 수 있음..?
		
		// 브라우저 옵션
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");		// 눈에 보이지 않지만 처리하기 위한 옵션, 백그라운드 실행 옵션
//		options.addArguments("--no-sendbox");	// 가상화 도구 사용시 다른 자원과의 연결 시 문제가 생길 수 있음 -> 격리화 과정, 리눅스 환경 sendbox 사용 여부 
		
		// 브라우저 동작
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://www.naver.com");
		
		// 특정 위치 요소 선택(키워드 입력하기)
		WebElement searchEl = driver.findElement(By.id("query"));
		
		// 키워드 입력
		searchEl.sendKeys("노트북");
		
		// 엔터키 전달
		searchEl.sendKeys(Keys.RETURN);
		
		// 노트북 검색 이후 쇼핑 파트 클릭
		WebElement shoppingBtnEl = driver.findElement(By.cssSelector(".api_pcpg_wrap .tab:nth-child(1)"));
		
		// 탭이 새로 열리면 작업권한이 이관됨 -> 한 탭에서 작동하도록 만들 것
		// 새창 열리기 삭제
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].removeAttribute('target')", shoppingBtnEl);
		
		shoppingBtnEl.click();
		
		//네이버포털 -> '노트북'검색 -> 쇼핑 클릭-> 삼성 노트북(엔터)
//		WebElement itemsHeaderEl =  driver.findElement(By.cssSelector("._searchInput_search_text_3CUDs"));
//		itemsHeaderEl.sendKeys("삼성 노트북");
//		itemsHeaderEl.sendKeys(Keys.RETURN);
				
				
		//네이버포털 -> '노트북'검색 -> 쇼핑 클릭-> 삼성 노트북(엔터) -> 리뷰 많은순 클릭
		List<WebElement> Els = driver.findElements(By.cssSelector(".subFilter_sort_box__FpfWA a"));
		Els.forEach(el->{
			if(el.getText().contains("리뷰 많은순"))
				el.click();
		});
				
		//영역내 모든 정보 긁어오기 basicList_list_basis__uNBZx
		List<WebElement> El2s =  driver.findElements(By.cssSelector(".basicList_list_basis__uNBZx"));
				
				
		//파일로 저장
		Writer out = new FileWriter("C:\\IOTEST\\index.html");
			
		//css link 빼내오기
		List<WebElement> cssLinks = driver.findElements(By.tagName("link"));
		for(WebElement link : cssLinks) {
			String rel = link.getAttribute("rel");
			if(rel.equals("stylesheet")){
				String href = link.getAttribute("href");
				System.out.println("CSS 링크 : " + href);
			}
		}
				
		//본문내용
		for(WebElement el :El2s) {
			String elHTML = el.getAttribute("outerHTML");
			out.write(elHTML+"\n");
		}
		out.flush();
		out.close();
		
	}
}
