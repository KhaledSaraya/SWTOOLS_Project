package SWTOOLS;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Order_ID;
	
	private int Order_Price;
	private int order_fk_restaurantId;
	private int order_fk_runnerId;
	private String order_status;
	
	
	private User user;
	private Meal m;
	
	private Runner run;

	private double total_account=0.0;

	

	public Order() 
	{}
	
	public Order(int order_ID, int order_Price, int order_fk_restaurantId,int order_fk_runnerId,
			String order_status) {
		super();
		Order_ID = order_ID;
		Order_Price = order_Price;
		this.order_fk_restaurantId = order_fk_restaurantId;
		this.order_fk_runnerId = order_fk_runnerId;
		this.order_status = order_status;
	}
	
	public int getOrder_ID() {
		return Order_ID;
	}

	public void setOrder_ID(int order_ID) {
		Order_ID = order_ID;
	}

	public int getOrder_Price() {
		return Order_Price;
	}

	public void setOrder_Price(int order_Price) {
		Order_Price = order_Price;
	}

	public int getOrder_fk_restaurantId() {
		return order_fk_restaurantId;
	}

	public void setOrder_fk_restaurantId(int order_fk_restaurantId) {
		this.order_fk_restaurantId = order_fk_restaurantId;
	}

	public int getOrder_fk_runnerId() {
		return order_fk_runnerId;
	}

	public void setOrder_fk_runnerId(int order_fk_runnerId) {
		this.order_fk_runnerId = order_fk_runnerId;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	
	public double getTotal_account() {
		return total_account;
	}

	public void setTotal_account(double total_account) {
		this.total_account = total_account;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Meal getM() {
		return m;
	}

	public void setM(Meal m) {
		this.m = m;
	}


	public void setDeliveryFees(double deliveryFees) {
		// TODO Auto-generated method stub
		
	}

	public void setRunnerName(String runnerName) {
		// TODO Auto-generated method stub
		
	}

	public void setTotalReceiptValue(double totalReceiptValue) {
		// TODO Auto-generated method stub
		
	}

	public Runner getRun() {
		return run;
	}

	public void setRun(Runner run) {
		this.run = run;
	}
	
	

}
enum OrderStatus
{
	preparing, delivered, canceled
	
}


	
	
	
