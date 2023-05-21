package Al_Akeel_pack;

public class Order {
	
	private int Order_ID;
	private int Order_Price;
	
	private String order_fk_restaurantId;
	private String order_fk_runnerId;
	private String order_status;
	
	public Order(int order_ID, int order_Price, String order_fk_restaurantId, String order_fk_runnerId,
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

	public String getOrder_fk_restaurantId() {
		return order_fk_restaurantId;
	}

	public void setOrder_fk_restaurantId(String order_fk_restaurantId) {
		this.order_fk_restaurantId = order_fk_restaurantId;
	}

	public String getOrder_fk_runnerId() {
		return order_fk_runnerId;
	}

	public void setOrder_fk_runnerId(String order_fk_runnerId) {
		this.order_fk_runnerId = order_fk_runnerId;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	
	

}
