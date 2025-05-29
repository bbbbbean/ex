package C09;

import java.time.format.DateTimeFormatter;

public class OrderDto {
	private String Category;
	private Integer Sum;

	// 생성자
	public OrderDto() {}
	public OrderDto(String category, Integer sum) {
		super();
		Category = category;
		Sum = sum;
	}

	// getter and setter
	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public Integer getSum() {
		return Sum;
	}

	public void setSum(Integer sum) {
		Sum = sum;
	}

	// toString
	@Override
	public String toString() {
		return "OrderDto [Category=" + Category + ", Sum=" + Sum + "]";
	}
	
	
	
	
	/*
	 * private String product_id; private String userid; private String
	 * product_name; private String category; private Integer price; private Integer
	 * quantity; private LocalDate order_date;
	 * 
	 * // 생성자 public OrderDto() {}
	 * 
	 * public OrderDto(String product_id, String userid, String product_name, String
	 * category, Integer price, Integer quantity, LocalDate order_date) { super();
	 * this.product_id = product_id; this.userid = userid; this.product_name =
	 * product_name; this.category = category; this.price = price; this.quantity =
	 * quantity; this.order_date = order_date; }
	 * 
	 * // getter and setter public String getProduct_id() { return product_id; }
	 * 
	 * public void setProduct_id(String product_id) { this.product_id = product_id;
	 * }
	 * 
	 * public String getUserid() { return userid; }
	 * 
	 * public void setUserid(String userid) { this.userid = userid; }
	 * 
	 * public String getProduct_name() { return product_name; }
	 * 
	 * public void setProduct_name(String product_name) { this.product_name =
	 * product_name; }
	 * 
	 * public String getCategory() { return category; }
	 * 
	 * public void setCategory(String category) { this.category = category; }
	 * 
	 * public Integer getPrice() { return price; }
	 * 
	 * public void setPrice(Integer price) { this.price = price; }
	 * 
	 * public Integer getQuantity() { return quantity; }
	 * 
	 * public void setQuantity(Integer quantity) { this.quantity = quantity; }
	 * 
	 * public LocalDate getOrder_date() { return order_date; }
	 * 
	 * public void setOrder_date(LocalDate order_date) { this.order_date =
	 * order_date; }
	 * 
	 * // toString
	 * 
	 * @Override public String toString() { return "OrderDto [product_id=" +
	 * product_id + ", userid=" + userid + ", product_name=" + product_name +
	 * ", category=" + category + ", price=" + price + ", quantity=" + quantity +
	 * ", order_date=" + order_date + "]"; }
	 */
	
}
