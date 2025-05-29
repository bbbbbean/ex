package Utils;

public class TeacherClassDto {
	private String teacher_code;
	private String class_name;
	private String teacher_name;
	private int sumTuition;
	
	public TeacherClassDto(){}

	public TeacherClassDto(String teacher_code, String class_name, String teacher_name, int sumTuition) {
		super();
		this.teacher_code = teacher_code;
		this.class_name = class_name;
		this.teacher_name = teacher_name;
		this.sumTuition = sumTuition;
	}

	public String getTeacher_code() {
		return teacher_code;
	}

	public void setTeacher_code(String teacher_code) {
		this.teacher_code = teacher_code;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public int getSumTuition() {
		return sumTuition;
	}

	public void setSumTuition(int sumTuition) {
		this.sumTuition = sumTuition;
	}

	@Override
	public String toString() {
		return "TeacherClassDto [teacher_code=" + teacher_code + ", class_name=" + class_name + ", teacher_name="
				+ teacher_name + ", sumTuition=" + sumTuition + "]";
	}
	
}
