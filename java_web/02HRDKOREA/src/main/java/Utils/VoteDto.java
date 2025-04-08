package Utils;

public class VoteDto {
	// 액션 태그로 한번에 받아내고 싶다면? input의 name과 일치해야함
	private String v_jumin;
	private String v_name;
	private String m_no;
	private String v_time;
	private String v_area;
	private String v_comfirm;
	
	// 액션 태그로 한번에 받아내고 싶다면? 생성자과 getter and setter 필수, toString 선택
	// 생성자
	public VoteDto() {}
	public VoteDto(String v_jumin, String v_name, String m_no, String v_time, String v_area, String v_comfirm) {
		super();
		this.v_jumin = v_jumin;
		this.v_name = v_name;
		this.m_no = m_no;
		this.v_time = v_time;
		this.v_area = v_area;
		this.v_comfirm = v_comfirm;
	}
	
	// getter and setter
	public String getV_jumin() {
		return v_jumin;
	}
	public void setV_jumin(String v_jumin) {
		this.v_jumin = v_jumin;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public String getM_no() {
		return m_no;
	}
	public void setM_no(String m_no) {
		this.m_no = m_no;
	}
	public String getV_time() {
		return v_time;
	}
	public void setV_time(String v_time) {
		this.v_time = v_time;
	}
	public String getV_area() {
		return v_area;
	}
	public void setV_area(String v_area) {
		this.v_area = v_area;
	}
	public String getV_comfirm() {
		return v_comfirm;
	}
	public void setV_comfirm(String v_comfirm) {
		this.v_comfirm = v_comfirm;
	}
	
	// toString
	@Override
	public String toString() {
		return "VoteDto [v_jumin=" + v_jumin + ", v_name=" + v_name + ", m_no=" + m_no + ", v_time=" + v_time
				+ ", v_area=" + v_area + ", v_comfirm=" + v_comfirm + "]";
	}
}
