package fr.formation.proxi.persistance;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.entity.SqlQueries;

public class ClientDao implements Dao<Client>{

	
private final MySqlConnection mySqlConn;
	
	public ClientDao() {
		this.mySqlConn = MySqlConnection.getInstance();
	}
	public List<Client> readAll() {
		List<Client> results = new ArrayList<>();
		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(SqlQueries.READ_ALL_CLIENT);
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String address = rs.getString("address");
				results.add(new Client(id,firstname, lastname, email, address));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	public Client update(Client entity) {
		   try {
	            Statement st = this.mySqlConn.getConn().createStatement();
	            String queryFirstname = String.format(SqlQueries.UPDATE_CLIENT, "firstname", entity.getFirstname(), entity.getId());
	            String queryLastname = String.format(SqlQueries.UPDATE_CLIENT, "lastname", entity.getLastname(), entity.getId());
	            String queryEmail = String.format(SqlQueries.UPDATE_CLIENT, "email", entity.getEmail(), entity.getId());
	            String queryAddress = String.format(SqlQueries.UPDATE_CLIENT, "address", entity.getAddress(), entity.getId());
	            st.execute(queryFirstname);
	            st.execute(queryLastname);
	            st.execute(queryEmail);
	            st.execute(queryAddress);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
		return entity;
	}
	
	
	@Override
	public List<Client> read(Integer id) {
		
		return null;
	}
	
}
