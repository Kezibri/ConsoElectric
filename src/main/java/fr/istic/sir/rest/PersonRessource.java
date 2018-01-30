package fr.istic.sir.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entities.Person;
import jpa.JpaTest;

@Path("/persons")
public class PersonRessource {
	
	JpaTest test ;
	
	private List<Person> persons = new ArrayList<Person>();
	
	public PersonRessource()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		test = new JpaTest(manager);
	}
	
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Person> list() {
        return persons;
    }
    
    @GET 
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Person findById(@PathParam("id") long arg0) {
        return test.getPerson(arg0);
    }

    @DELETE 
    @Path("delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Person deleteById(@PathParam("id") String arg0) {
        return persons.remove(Integer.parseInt(arg0));
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
      return "Hello Jersey";
    }
}
