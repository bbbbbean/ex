package Domain.Dto;

import java.time.LocalDateTime;

public class BookReplyDto {
	private int no;	// 자동으로 받아옴
	private String bookcode;	// read session에서 받아옴 프론트
	private String username;	// 로그인 이후 session에서 받아욤
	private String contents;	// 프론트에서 받아옴
	private LocalDateTime createAt;	// 백에서 처리
	
	public BookReplyDto() {}

	public BookReplyDto(int no, String bookcode, String username, String contents, LocalDateTime createAt) {
		super();
		this.no = no;
		this.bookcode = bookcode;
		this.username = username;
		this.contents = contents;
		this.createAt = createAt;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getBookcode() {
		return bookcode;
	}

	public void setBookcode(String bookcode) {
		this.bookcode = bookcode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return "BookReplyDto [no=" + no + ", bookcode=" + bookcode + ", username=" + username + ", contents=" + contents
				+ ", createAt=" + createAt + "]";
	}
	
}
