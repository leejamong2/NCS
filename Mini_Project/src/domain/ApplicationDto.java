package domain;

public class ApplicationDto {
	// 글번호

	private int application_seq;
	private int emp_seq;
	private int location_seq;
	private int employ_type_seq;
	private int military_seq;
	private String license;
	private String school_name;
	private String department_name;
	private int hope_sal;
	
	
	
	public int getApplication_seq() {
		return application_seq;
	}
	public void setApplication_seq(int application_seq) {
		this.application_seq = application_seq;
	}
	public int getEmp_seq() {
		return emp_seq;
	}
	public void setEmp_seq(int emp_seq) {
		this.emp_seq = emp_seq;
	}
	public int getLocation_seq() {
		return location_seq;
	}
	public void setLocation_seq(int location_seq) {
		this.location_seq = location_seq;
	}
	public int getEmploy_type_seq() {
		return employ_type_seq;
	}
	public void setEmploy_type_seq(int employ_type_seq) {
		this.employ_type_seq = employ_type_seq;
	}
	public int getMilitary_seq() {
		return military_seq;
	}
	public void setMilitary_seq(int military_seq) {
		this.military_seq = military_seq;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public int getHope_sal() {
		return hope_sal;
	}
	public void setHope_sal(int hope_sal) {
		this.hope_sal = hope_sal;
	}
	   
	   
	

}
