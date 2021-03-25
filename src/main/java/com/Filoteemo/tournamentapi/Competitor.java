package com.Filoteemo.tournamentapi;
/**
 * @author sindr
 * 
 * Modellen for API. Hver utøver har en id, et navn, en vektklasse og et land. 
 */
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Competitor {
		
	private int id;
	private String name;
	private int weight;
	private String country;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Competitor [id=" + id + ", name=" + name + ", weight=" + weight + ", country="+country+"]";
	}
	
	
}
