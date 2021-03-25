package com.Filoteemo.tournamentapi;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * 
 * @author sindr
 * Klassen håndterer GET, PUT, POST, DELETE
 */

@Path("competitors") // default path
public class CompetitorController {
	
	CompetitorDao dao = new CompetitorDao(); // kobler til db gjennom constructor

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) // mediatyper som kan vises 
	public List<Competitor> getCompetitors() { // GET metode som returnerer alle objekter i liste
		
		System.out.println("Metoden getCompetitors kallet på");
		
		return dao.getCompetitors();
	}
	
	@GET
	@Path("competitor/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Competitor getCompetitor(@PathParam("id")int id) { // GET method which returns a specific object given by the id
		return dao.getCompetitor(id);
	}
	
	@POST
	@Path("competitor")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Competitor createCompetitor(Competitor c) { // method returns an object
		System.out.println(c); // prints the result from the insert in the console
		dao.createCompetitor(c);
		return c;
	}
}
