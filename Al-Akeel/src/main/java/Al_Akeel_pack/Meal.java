package Al_Akeel_pack;

public class Meal {
	
	private int Meal_ID;
	private String Meal_name;
	private int Meal_Price;
	private String fk_restaurantId;
	
	
	
	public Meal(int meal_ID, String meal_name, int meal_Price, String fk_restaurantId) {
		super();
		Meal_ID = meal_ID;
		Meal_name = meal_name;
		Meal_Price = meal_Price;
		this.fk_restaurantId = fk_restaurantId;
	}
	
	public int getMeal_ID() {
		return Meal_ID;
	}
	public void setMeal_ID(int meal_ID) {
		Meal_ID = meal_ID;
	}
	public String getMeal_name() {
		return Meal_name;
	}
	public void setMeal_name(String meal_name) {
		Meal_name = meal_name;
	}
	public int getMeal_Price() {
		return Meal_Price;
	}
	public void setMeal_Price(int meal_Price) {
		Meal_Price = meal_Price;
	}
	public String getFk_restaurantId() {
		return fk_restaurantId;
	}
	public void setFk_restaurantId(String fk_restaurantId) {
		this.fk_restaurantId = fk_restaurantId;
	}

}
