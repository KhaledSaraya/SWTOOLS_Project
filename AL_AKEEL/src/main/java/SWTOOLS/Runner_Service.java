package SWTOOLS;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("Run_Service")

@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Runner_Service {

	    @PersistenceContext(unitName = "Project")
	    private EntityManager entityManager;

	    public void markOrderDelivered(@PathParam("ord_id")int orderId,@PathParam("run_id")int runnerId) {
	        // Retrieve the order and runner from the database
	        Order order = entityManager.find(Order.class, orderId);
	        Runner runner = entityManager.find(Runner.class, runnerId);

	        if (order != null && runner != null && order.getRun() != null && order.getRun().equals(runner)) {
	            // Update order status to "DELIVERED" and runner status to "AVAILABLE"
	            order. setOrder_status("delivered");
	            runner.setRunner_status("Available");

	            // Save the updated order and runner to the database
	            entityManager.merge(order);
	            entityManager.merge(runner);
	        }
	    }
	    
	    public int getNumberOfTripsCompleted(@PathParam("run_id")int runnerId) {
	        TypedQuery<Runner> query = entityManager.createQuery("SELECT COUNT(o) FROM Order o WHERE o.runner.id = :runnerId AND o.status = :status", Runner.class);
	        query.setParameter("runnerId", runnerId);
	        query.setParameter("runner_status", "COMPLETED");

	        
	        return query.getFirstResult();
	    }

};
