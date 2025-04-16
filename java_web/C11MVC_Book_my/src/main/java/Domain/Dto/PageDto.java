package Domain.Dto;

public class PageDto {
	private static final long serialVersionUID = 5L;
	// Criteria의 결과물
	
	
	//페이지정보(전체페이지,현재페이지)
	private int totalpage;			// 총게시물건수 / amount
	private Criteria criteria;		// 현재페이지,한페이지당 읽을 게시물의 건수가 저장되어있음
	
	//블럭정보
	private int pagePerBlock;		// 블럭에 표시할 페이지개수(15건 지정)
	private int totalBlock;			// totalpage / pagePerBlock
	private int nowBlock;			// 현재페이지번호 /pagePerBlock
	
	//표시할 페이지(블럭에표시할 시작페이지-마지막페이지)
	private int startPage;
	private int endPage;
	
	//NextPrev 버튼 표시여부
	private boolean prev,next;
	
	
	public PageDto() {}
	
	public PageDto(long totalcount,Criteria criteria) {
		
		
		this.criteria = criteria;
		
		// 전체페이지 계산 : 전체 게시물 건수 / 페이지당 게시물의 건수
			// 올림 처리 : 소수점을 버리고 무조건 올림 처리
			// 100.X 페이지가 나온 경우 101페이지로 만들어 목록 표기
		totalpage =(int)Math.ceil((1.0*totalcount)/criteria.getAmount());
		
		// 블럭계산
			// 하단 페이지네이션의 숫자 단위
			// < 1~15 >
		pagePerBlock=15;
			// 현재 만들어진 페이지 수 / 한번에 표시할 페이지 수
			// 소수점을 버리고 올림
		totalBlock = (int)Math.ceil( (1.0*totalpage) / pagePerBlock );
			// 현재 블럭 : 이동한 블럭의 현재 위치
		nowBlock =  (int)Math.ceil ((1.0*criteria.getPageno()) / pagePerBlock);
		
		// Next,Prev 버튼 활성화 유무
		prev=nowBlock>1;	// 첫번째 페이지에서는 이전 버튼이 나타나면 안됨
		next=nowBlock<totalBlock;	// 마지막 페이지에서는 이후 버튼이 나타나면 안됨
		
		// 블럭에 표시할 페이지 번호 계산
			// 전체 건수를 기준으로 페이지 수 나옴 -> 페이지 수를 기준으로 블럭 수 나옴
			// 블럭의 시작 번호와 마지막 번호 지정
		this.endPage = (nowBlock * pagePerBlock<totalpage) ? nowBlock * pagePerBlock : totalpage ;
		
		this.startPage=nowBlock * pagePerBlock -pagePerBlock + 1;
		 
		
	}

	@Override
	public String toString() {
		return "PageDto [totalpage=" + totalpage + ", criteria=" + criteria + ", pagePerBlock=" + pagePerBlock
				+ ", totalBlock=" + totalBlock + ", nowBlock=" + nowBlock + ", startPage=" + startPage + ", endPage="
				+ endPage + ", prev=" + prev + ", next=" + next + "]";
	}
	

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	public int getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}

	public int getNowBlock() {
		return nowBlock;
	}

	public void setNowBlock(int nowBlock) {
		this.nowBlock = nowBlock;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
}
