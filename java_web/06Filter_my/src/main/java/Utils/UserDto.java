package Utils;

public class UserDto {
	private String userid;
	private String password;
	private String role;
	private String addr;
	
	public UserDto() {}

	public UserDto(String userid, String password, String role, String addr) {
		super();
		this.userid = userid;
		this.password = password;
		this.role = role;
		this.addr = addr;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "UserDto [userid=" + userid + ", password=" + password + ", role=" + role + ", addr=" + addr + "]";
	}
	
}
