package in.co.rays.bean;



public class Marksheet2Bean {
	
	private int id;
	private String rollNo;
	private String fname;
	private String lname;
	private int physics;
	private int chemistry;
	private int maths;
	private int total;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getRollNo() {
		return rollNo;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFname() {
		return fname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLname() {
		return lname;
	}
	
	public void setPhysics(int physics) {
		this.physics = physics;
	}
	public int getPhysics() {
		return physics;
	}
	
	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}
	public int getChemistry() {
		return chemistry;
	}
	
	public void setMaths(int maths) {
		this.maths = maths;
	}
	public int getMaths() {
		return maths;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal() {
		return total;
	}

}
