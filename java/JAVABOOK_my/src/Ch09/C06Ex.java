package Ch09;


class Profile{
	//속성
	String name;
	String addr;
	String job;
	String major;
	//생성자
	
	//1)디폴트생성자 삽입
	public Profile(){	// 퍼블릭 : 다른 패키지에서도 접근 가능
		
	}
	
	//2)모든 인자 받는 생성자 삽입 -> 각멤버에 대입
	public Profile(String name, String addr, String job, String major) {
		super();
		this.name = name;
		this.addr = addr;
		this.job = job;
		this.major = major;
	}
	
	//3)모든 인자 받는 생성자 삽입(가변인자사용할것) -> , 를기준으로 잘라내어 각속성에 저장
	//ex, "홍길동,대구,프로그래머,컴퓨터공학" ->[홍길동,대구,프로그래머,컴퓨터공학]
	public Profile(String...arg) {
		for(String result:arg) {
			String [] obj = result.split(",");
			this.name = obj[0];
			this.addr = obj[1];
			this.job = obj[2];
			this.major = obj[3];
		}

	}
	
	//기능
	//1) getter and setter 삽입
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	//2) toString  재정의 
	@Override
	public String toString() {
		return "Profile [name=" + name + ", addr=" + addr + ", job=" + job + ", major=" + major + "]";
	}
	
	//3) boolean isContain(String findstr) 함수 완성하기
	boolean isContain(String findstr) {
		//findstr의 문자열이 각멤버인 name,addr,job,major 중 하나라도 포함되어 있으면 true 리턴
		//아니면 false 리턴
		
//		if(name.contains(findstr) || addr.contains(findstr) || job.contains(findstr) || major.contains(findstr)) {
//			return true;
//		}else {
//			return false;
//		}
		
		// 하나씩 각각 else if 넣어도 됨
		if(name.contains(findstr)) {
			return true;
		}else if(addr.contains(findstr)){
			return true;
		}else if(job.contains(findstr)) {
			return true;
		}else if(major.contains(findstr)) {
			return true;
		}else {
			return false;
		}
	}
	
	//4)
	boolean isEquals(String str) {
		//all로 받은 문자열을 , 단위로 잘라내어(split(",")) 각각 나눠진 문자열이
		//name,addr,job,major 와 일치 하면 true
		//아니면 false 를 리턴
		String [] all = str.split(",");
		
		if(all[0].equals(name) && all[1].equals(addr) && all[2].equals(job) && all[3].equals(major)) {
			return true;
		}else {
			return false;
		}

	}
	
}


public class C06Ex {
	public static void main(String[] args) {
		
		Profile hong = new Profile("홍길동,대구,프로그래머,컴퓨터공학");
		System.out.println(hong.toString());
		System.out.println("길동 포함여부 : " + hong.isContain("길동"));	//true
		System.out.println("컴퓨터 포함여부 : " + hong.isContain("컴퓨터"));	//true
		System.out.println("프로필 일치여부 : " + hong.isEquals("홍길동,대구,프로그래머,컴퓨터공학"));//false
		System.out.println("프로필 일치여부 : " + hong.isEquals("홍길동,울산,프로그래머,컴퓨터공학"));//false

	}
}
