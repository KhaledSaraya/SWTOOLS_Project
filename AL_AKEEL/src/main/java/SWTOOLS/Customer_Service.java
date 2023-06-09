package SWTOOLS;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;
import java.util.Random;

@Path("Cust_Service")

@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class Customer_Service {


	    @PersistenceContext(unitName = "Project")
	    private EntityManager entityManager;

	    @GET
	    @Path("get_ord_by_id/{ord_id}")
	    public Order getOrderById(@PathParam("ord_id")int orderId) {
	        return entityManager.find(Order.class, orderId);
	    }
	    
	    @GET
	    @Path("get_all_orders")
	    public List<Order> getAllOrders() {
	        TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o", Order.class);
	        return query.getResultList();
	    }
	    
	    @GET
	    @Path("get_all_res")
	    public List<Restaurant> getAllRestaurants() {
	        TypedQuery<Restaurant> query = entityManager.createQuery("SELECT r FROM Restaurant r", Restaurant.class);
	        List<Restaurant> allres = query.getResultList();
	       
	       return allres;
	    }
	    
	    @POST
	    @Path("create_order/{user_id}/{res_id}/{meals}/{run_obj}/{fees}/{run_name}")
	    public void createOrder(@PathParam("user_id")int UserId, @PathParam("res_id")int restaurantid, @PathParam("meals")Meal[] Meals_Ordered,@PathParam("run_obj")Runner R,@PathParam("fees")double deliveryFees,@PathParam("run_name") String runnerName) {
	        // Create a new order
	    	Restaurant res = new Restaurant();
	        Order order = new Order();
	        order.setOrder_fk_restaurantId(restaurantid);
	        order.setOrder_status("delivered");

	        // Add order meals
	        res.setList_of_meals(Meals_Ordered);

	        // Calculate total receipt value
	        double totalReceiptValue = calculateTotalReceiptValue(Meals_Ordered, deliveryFees);
	        order.setTotalReceiptValue(totalReceiptValue);

	        // Set delivery fees and runner name
	        R.setDelivery_fees(deliveryFees);
	        R.setRunner_Name(runnerName);
	        
	        order.setDeliveryFees(deliveryFees);
	        order.setRunnerName(runnerName);

	        // Save the order to the database
	        entityManager.persist(order);
	        entityManager.persist(R);
	    }
	    
	    @POST
	    @Path("calc_total/{calc_meals}/{fees}")
		public double calculateTotalReceiptValue(@PathParam("calc_meals") Meal[] meals_Ordered,@PathParam("fees")double deliveryFees ) {
	    	double total = 0.0;
	        for (Meal  Meals : meals_Ordered) {
	            total += Meals.getMeal_Price();
	        }
	        return total + deliveryFees;

			
		}

	    @POST
	    @Path("select_random_run")
		public Runner selectRandomAvailableRunner() {
			
	        // Query available runners from the database
	        TypedQuery<Runner> availableRunners = entityManager.createQuery("SELECT r FROM Runner r WHERE r.status = :status",Runner.class);
	        		availableRunners.setParameter("runner_status","Available");
	        		availableRunners.getResultList();
	        		
	        if (availableRunners != null) {
	            // Select a random runner from the available runners
	            Random random = new Random();
	            int index = random.nextInt(((List<Runner>) availableRunners).size());
	            return ((List<Runner>) availableRunners).get(index);
	        }

	        return null;
	    }



	};

