package SWTOOLS;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Restaurant_ID;
	
	private String Restaurant_name;
	private int Restaurant_ownerId;
	private Meal list_of_meals [];
	
	public Restaurant()
	{}
	
	public Restaurant(int restaurant_ID, String restaurant_name, int restaurant_ownerId, Meal[] list_of_meals) {
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
	public Meal[] getList_of_meals() {
		return list_of_meals;
	}
	public void setList_of_meals(Meal[] list_of_meals) {
		this.list_of_meals = list_of_meals;
	}

}

