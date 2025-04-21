package Domain.Dto;

public class Criteria {
	// 필터링 역할
	private int pageno; 	// 현재 페이지
	private int amount;		// 페이지 당 보여줄 게시물 건수
	private String type;	// 타입(도서명 , 도서코드 , 출판사) : 조건부 검색 때 사용, 어떤 열을 기준으로 검색할건지
	private String keyword;	// 키워드 : 일치, 포함 여부
	
	public Criteria() {
		// 최초 접속 시
		// 처음페이지로 들어왔을떄 기본값
		this.pageno = 1;
		this.amount = 10;
	}
	
	// 사용자가 페이지를 이동하려는 시도가 있는 경우, 검색을 실행할 경우
	public Criteria(String pageno, int amount, String type, String keyword) {
		super();
		this.pageno = Integer.parseInt(pageno);
		this.amount = amount;
		this.type = type;
		this.keyword = keyword;
	}
	
	// 단순 페이지 이동을 한 경우
	public Criteria(String pageno, int amount) {
		this.pageno = Integer.parseInt(pageno) ;
		this.amount = amount ;
	}

	// getter and setter
	public int getPageno() {
		return pageno;
	}
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "Criteria [pageno=" + pageno + ", amount=" + amount + ", type=" + type + ", keyword=" + keyword + "]";
	}

	//toString
	//getter and setter
	//생성자(디폴트,모든인자)
	
	
}
