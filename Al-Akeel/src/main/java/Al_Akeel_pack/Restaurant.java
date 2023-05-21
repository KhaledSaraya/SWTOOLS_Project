package Al_Akeel_pack;

public class Restaurant {
	
	private int Restaurant_ID;
	private String Restaurant_name;
	private int Restaurant_ownerId;
	private String list_of_meals [];
	
	
	public Restaurant(int restaurant_ID, String restaurant_name, int restaurant_ownerId, String[] list_of_meals) {
		super();
		Restaurant_ID = restaurant_ID;
		Restaurant_name = restaurant_name;
		Restaurant_ownerId = restaurant_ownerId;
		this.list_of_meals = list_of_meals;
	}
	
	public int getRestaurant_ID() {
		return Restaurant_ID;
	}
	public void setRestaurant_ID(int restaurant_ID) {
		Restaurant_ID = restaurant_ID;
	}
	public String getRestaurant_name() {
		return Restaurant_name;
	}
	public void setRestaurant_name(String restaurant_name) {
		Restaurant_name = restaurant_name;
	}
	public int getRestaurant_ownerId() {
		return Restaurant_ownerId;
	}
	public void setRestaurant_ownerId(int restaurant_ownerId) {
		Restaurant_ownerId = restaurant_ownerId;
	}
	public String[] getList_of_meals() {
		return list_of_meals;
	}
	public void setList_of_meals(String[] list_of_meals) {
		this.list_of_meals = list_of_meals;
	}

}
