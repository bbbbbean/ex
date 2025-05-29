package C09;

public class OrderDto4 {
	private String userid;
	private String addr;
	private Integer quantity;
	
	// 생성자
	public OrderDto4() {}
	public OrderDto4(String userid, String addr, Integer quantity) {
		super();
		this.userid = userid;
		this.addr = addr;
		this.quantity = quantity;
	}
	
	// getter and setter
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	//toString
	@Override
	public String toString() {
		return "OrderDto4 [userid=" + userid + ", addr=" + addr + ", quantity=" + quantity + "]";
	}
}
