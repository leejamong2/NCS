package domain;

public class CompanyDto {

	// field, attribute, property, 속성
	
	private int comp_seq;       	// not null number        
	private String comp_id;         // not null nvarchar2(8)  
	private String comp_email;      // not null nvarchar2(10) 
	private int indust_seq;   		// not null number        
	private String comp_name;       // not null nvarchar2(20) 
	private String comp_scale;      // not null nvarchar2(10) 
	private String comp_est_date;   // not null date          
	private String comp_addr;       // not null nvarchar2(30) 
	private String comp_ceo;        // not null nvarchar2(15) 
	private int comp_emp_cnt;       // not null number        
	private int comp_capital;       // not null number        
	private int comp_sales;         // not null number        
	private String comp_insurance;  // not null nvarchar2(1)  
	private int status;             // not null number(1)  
	
	
	
	
	// method, operation, 기능
	
	
	public int getComp_seq() {
		return comp_seq;
	}
	public void setComp_seq(int comp_seq) {
		this.comp_seq = comp_seq;
	}
	public String getComp_id() {
		return comp_id;
	}
	public void setComp_id(String comp_id) {
		this.comp_id = comp_id;
	}
	public String getComp_email() {
		return comp_email;
	}
	public void setComp_email(String comp_email) {
		this.comp_email = comp_email;
	}
	public int getIndust_seq() {
		return indust_seq;
	}
	public void setIndust_seq(int indust_seq) {
		this.indust_seq = indust_seq;
	}
	public String getComp_name() {
		return comp_name;
	}
	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}
	public String getComp_scale() {
		return comp_scale;
	}
	public void setComp_scale(String comp_scale) {
		this.comp_scale = comp_scale;
	}
	public String getComp_est_date() {
		return comp_est_date;
	}
	public void setComp_est_date(String comp_est_date) {
		this.comp_est_date = comp_est_date;
	}
	public String getComp_addr() {
		return comp_addr;
	}
	public void setComp_addr(String comp_addr) {
		this.comp_addr = comp_addr;
	}
	public String getComp_ceo() {
		return comp_ceo;
	}
	public void setComp_ceo(String comp_ceo) {
		this.comp_ceo = comp_ceo;
	}
	public int getComp_emp_cnt() {
		return comp_emp_cnt;
	}
	public void setComp_emp_cnt(int comp_emp_cnt) {
		this.comp_emp_cnt = comp_emp_cnt;
	}
	public int getComp_capital() {
		return comp_capital;
	}
	public void setComp_capital(int comp_capital) {
		this.comp_capital = comp_capital;
	}
	public int getComp_sales() {
		return comp_sales;
	}
	public void setComp_sales(int comp_sales) {
		this.comp_sales = comp_sales;
	}
	public String getComp_insurance() {
		return comp_insurance;
	}
	public void setComp_insurance(String comp_insurance) {
		this.comp_insurance = comp_insurance;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	  
	
	

	
	

	
	
	
	

	
	
	
	
	
	
	
}		
