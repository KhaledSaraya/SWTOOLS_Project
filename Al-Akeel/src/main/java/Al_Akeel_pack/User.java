package Al_Akeel_pack;

public class User {
	
	private int ID;
	private String name;
	private String role;
	
	
	public User(int iD, String name, String role) {
		super();
		ID = iD;
		this.name = name;
		this.role = role;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
