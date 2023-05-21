package Al_Akeel_pack;

public class Runner {
	
	private int Runner_ID;
	private int delivery_fees;
	
	private String Runner_Name;
	private String Runner_status;
	
	
	public Runner(int runner_ID, int delivery_fees, String runner_Name, String runner_status) {
		super();
		Runner_ID = runner_ID;
		this.delivery_fees = delivery_fees;
		Runner_Name = runner_Name;
		Runner_status = runner_status;
	}
	
	public int getRunner_ID() {
		return Runner_ID;
	}
	public void setRunner_ID(int runner_ID) {
		Runner_ID = runner_ID;
	}
	public int getDelivery_fees() {
		return delivery_fees;
	}
	public void setDelivery_fees(int delivery_fees) {
		this.delivery_fees = delivery_fees;
	}
	public String getRunner_Name() {
		return Runner_Name;
	}
	public void setRunner_Name(String runner_Name) {
		Runner_Name = runner_Name;
	}
	public String getRunner_status() {
		return Runner_status;
	}
	public void setRunner_status(String runner_status) {
		Runner_status = runner_status;
	}
	

}
