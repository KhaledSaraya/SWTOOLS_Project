package SWTOOLS;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Runner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Runner_ID;
	
	private double delivery_fees;
	private String Runner_Name;
	private String runner_status;
	
	public Runner()
	{}
	
	public Runner(int delivery)
	{
		this.delivery_fees = delivery;
	}
	public Runner(int runner_ID, int delivery_fees, String runner_Name, String status) {
		super();
		Runner_ID = runner_ID;
		this.delivery_fees = delivery_fees;
		Runner_Name = runner_Name;
		runner_status = status;
	}
	
	public int getRunner_ID() {
		return Runner_ID;
	}
	public void setRunner_ID(int runner_ID) {
		Runner_ID = runner_ID;
	}
	public double getDelivery_fees() {
		return delivery_fees;
	}
	public void setDelivery_fees(double deliveryFees) {
		this.delivery_fees = deliveryFees;
	}
	public String getRunner_Name() {
		return Runner_Name;
	}
	public void setRunner_Name(String runner_Name) {
		Runner_Name = runner_Name;
	}
	public String getRunner_status() {
		return runner_status;
	}
	

	public void setRunner_status(String runner_status) {
		this.runner_status = runner_status;
	}


	

}
enum RunnerStatus
{Available , Busy }
