package com.Filoteemo.tournamentapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sindr
 * Klasse for å aksessere data.
 */
public class CompetitorDao {
	
	Connection connect = null;
	
	ArrayList <Competitor> Competitors;
	
		   public CompetitorDao() { // db connector constructor
			
			String url = "jdbc:mysql://localhost:3306/competition";
			String username = "root";
			String password = "EayfruRm";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connect = DriverManager.getConnection(url, username, password);
				
			} catch (SQLException | ClassNotFoundException e) {
				System.out.println(e);
			}
		}
		
		public List<Competitor> getCompetitors() { // metode for å hente alle rader i tabellen
			
			ArrayList<Competitor> Competitors = new ArrayList<>(); // lager ny liste med objekter basert på rader fra  db
			
			String sql = "select * from competitor"; // spørring som leser alle rader fra tabell i db
			try {
			Statement st = connect.createStatement(); 
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) { //looper igjennom tabellen så lenge det er rader med data
				Competitor c = new Competitor();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setWeight(rs.getInt(3));
				c.setCountry(rs.getString(4));
				
				Competitors.add(c); // legger til objekt c i liste
			}
		}
			catch(Exception e) {
				System.out.println(e);
			}
			return Competitors;
		}
		
		public Competitor getCompetitor(int id) { // reads from table in database based on chosen id
			
			List<Competitor> Competitor = new ArrayList<>();
					
					String sql = "select * from competitor where id="+id;
					Competitor c = new Competitor();
					try {
					Statement st = connect.createStatement();
					ResultSet rs = st.executeQuery(sql);
					if(rs.next()) {
						c.setId(rs.getInt(1));
						c.setName(rs.getString(2));
						c.setWeight(rs.getInt(3));
						c.setCountry(rs.getString(4));
						
						Competitor.add(c);
					    }
				    }
					catch(Exception e) {
						System.out.println(e);
					}
					
					return c;
				}
		
		public void createCompetitor(Competitor c) { // method for creating new competitor
			String sql = "insert into competitor values (?,?,?,?)";
			
			try {
				PreparedStatement st = connect.prepareStatement(sql);
				
				st.setInt(1, c.getId());
				st.setString(2, c.getName());
				st.setInt(3, c.getWeight());
				st.setString(4, c.getCountry());
				st.executeUpdate();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		
		public void deleteCompetitor(int id) {
			String sql = "delete from competitor where id=?";
			try {
			PreparedStatement st = connect.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		   }
			catch(Exception e) {
				System.out.println(e);
			}
		}
		
}
