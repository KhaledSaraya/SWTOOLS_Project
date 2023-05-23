package SWTOOLS;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("Res_Service")

@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Restaurant_Service {

    @PersistenceContext(unitName = "Project")
    private EntityManager entityManager;

    @GET
    @Path("get_res_id/{res_id}")
    public Restaurant getRestaurantById(@PathParam("res_id")int restaurantId) {
        return entityManager.find(Restaurant.class, restaurantId);
    }
    
    @GET
    @Path("get_all_res")
    public List<Restaurant> getAllRestaurants() {
        TypedQuery<Restaurant> query = entityManager.createQuery("SELECT r FROM Restaurant r", Restaurant.class);
        List<Restaurant> allres = query.getResultList();
       
       return allres;
    }
    
    @POST
    @Path("get_res_id/{res_id}/{listofmeals}")
    public void createMenu(@PathParam("res_id")int restaurantId, @PathParam("listofmeals") Meal[] meals ) {
        Restaurant restaurant = entityManager.find(Restaurant.class, restaurantId);
        if (restaurant != null) 
        {
        	meals = restaurant.getList_of_meals();
            
            entityManager.persist(meals);
        }
        }
    
    public void editRestaurantMenu(@PathParam("res_id")int restaurantId,@PathParam("listofmeals") Meal[] newMeals) {
        Restaurant restaurant = entityManager.find(Restaurant.class, restaurantId);
        if (restaurant != null) {
                restaurant.setList_of_meals(newMeals);
                entityManager.merge(restaurant);
            }
        }
    
    public void generateRestaurantReport(@PathParam("res_id")int restaurantId) {
        // Calculate total earnings
        TypedQuery<Order> OQuery = entityManager.createQuery("SELECT SUM(o.total_account) FROM Order o WHERE o.order_fk_restaurantId = :restaurantId AND o.order_status = :delivered", Order.class);
        OQuery.setParameter("order_fk_restaurantId", restaurantId);
        OQuery.setParameter("order_status", "delivered");


        // Calculate number of completed orders
        TypedQuery<Order>  completedOrdersQuery = entityManager.createQuery("SELECT COUNT(o) FROM Order o WHERE o.restaurant.id = :restaurantId AND o.status = :delivered",Order.class);
        completedOrdersQuery.setParameter("order_fk_restaurantId", restaurantId);
        completedOrdersQuery.setParameter("order_status", "delivered");


        // Calculate number of canceled orders
        TypedQuery<Order> canceledOrdersQuery = entityManager.createQuery("SELECT COUNT(o) FROM Order o WHERE o.restaurant.id = :restaurantId AND o.status = :canceled",Order.class);
        canceledOrdersQuery.setParameter("order_fk_restaurantId", restaurantId);
        canceledOrdersQuery.setParameter("order_status", "canceled");


        System.out.println("Restaurant Report:");
        System.out.println("Restaurant ID: " + restaurantId);
        System.out.println("Total Earnings: " + OQuery.getSingleResult());
        System.out.println("Number of Completed Orders: " + completedOrdersQuery.getSingleResult());
        System.out.println("Number of Canceled Orders: " + canceledOrdersQuery.getSingleResult());

    }


};