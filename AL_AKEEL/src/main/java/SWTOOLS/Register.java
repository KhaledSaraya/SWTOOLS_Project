package SWTOOLS;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

@Path("Register")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

@Stateless
public class Register {
    
    @PersistenceContext(unitName = "Project")
    private EntityManager entityManager;
    
    
    @GET
    @Path("log/{email}/{pass}")
    public boolean login(@PathParam("email")String email, @PathParam("pass")String password) {
        try {
            Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email AND u.password = :password");
            query.setParameter("email", email);
            query.setParameter("password", password);
            
            query.getSingleResult(); 
            
            // login successful
            return true;
        } catch (NoResultException e) {
            // login failed
            return false;
        }
    }
    
    
    @POST
    @Path("signup/{name}/{pass}/{email}")
    public void Signup(@PathParam("name")String username, @PathParam("pass")String password,@PathParam("email") String email) {
        // Check if the user already exists in the database
        Query query = entityManager.createQuery("SELECT COUNT(u) FROM User u WHERE u.email = :email");
        query.setParameter("email", email);
        
        long userCount = (long) query.getSingleResult();
        
        if (userCount > 0) {
            // User already exists, handle appropriately (e.g., throw an exception or display an error message)
            throw new RuntimeException("User with the provided email already exists");
        }
        
        // Create a new User object
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setEmail(email);
        
        // Save the user to the database
        entityManager.persist(user);
        }
    };
