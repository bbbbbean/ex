package Utils;

public class ResultDto {
	private String m_no;
	private String m_name;
	private String m_count;
	
	public ResultDto() {}

	public ResultDto(String m_no, String m_name, String m_count) {
		super();
		this.m_no = m_no;
		this.m_name = m_name;
		this.m_count = m_count;
	}

	public String getM_no() {
		return m_no;
	}

	public void setM_no(String m_no) {
		this.m_no = m_no;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_count() {
		return m_count;
	}

	public void setM_count(String m_count) {
		this.m_count = m_count;
	}

	@Override
	public String toString() {
		return "ResultDto [m_no=" + m_no + ", m_name=" + m_name + ", m_count=" + m_count + "]";
	}
	
}
