package com.Filoteemo.tournamentapi;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Iterator;


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
		
		System.out.println("Metoden getCompetitors() kallet på");
		
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
	
	@POST
	@Path("competitors")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ArrayList<Competitor> createCompetitors(ArrayList<Competitor> competitors) { // method returns an arraylist of objects
		
		Iterator <Competitor> itr = competitors.iterator();
		while(itr.hasNext()) {
		Competitor c = itr.next();
		System.out.println(c.getId());
		System.out.println(c.getName());
		System.out.println(c.getWeight());
		System.out.println(c.getCountry());
		}
		dao.createCompetitors(competitors);
		return competitors;
	}
	
	@DELETE
	@Path("competitor/{id}")
	public Competitor deleteCompetitor(@PathParam("id")int id) {
		System.out.println("Metoden deleteCompetitor() kallet på");
		Competitor c = dao.getCompetitor(id);
		if(c.getId() != 0) {
			dao.deleteCompetitor(id);
		}
		return c;
	}
	
	@GET //type of call
	@Path("allcompetitors") //path to call from 
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) //what data method produces
	public List<Competitor> getAllCompetitors(){
		return dao.getCompetitors();
	}
}
