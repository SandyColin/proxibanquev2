package fr.formation.proxi.persistance;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.entity.SqlQueries;

/**
 * {@InheritDoc}
 * @author Adminl Laila Bouzidi et Sandy Colin
 *La classe ClientDao permet d'effectuer les opérations du CRUD sur la table Client de la BDD
 */
public class ClientDao implements Dao<Client>{

	
private final MySqlConnection mySqlConn;
	/**
	 * Constructeur par défaut
	 */
	public ClientDao() {
		this.mySqlConn = MySqlConnection.getInstance();
	}
	/**
	 * La méthode readAll() permet de créer une liste avec tous les clients de la base de données sur l'appli
	 * @return List<Client> une liste de clients avec toutes ses propriétés
	 */
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
/**
 * La méthode update() permet de mettre à jour le cleint dans la base de donnée
 * @param entity Une entité de type Client
 * @return Un objet de type client
 */
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
	
	
	/** 
	 * La méthode read() permet d'obtenir les informations d'un client grâce à son identifiant
	 *@param idclient identifiant du client
	 *@return Un objet de type client avec toutes se propriétés
	 */
	public Client read(Integer idclient) {
		Client results = null;
		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.READ_CLIENT, idclient));
			while (rs.next()) {
				Integer id=rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String address = rs.getString("address");
		results = new Client(id,firstname, lastname, email, address);
			

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;

	}
	
}
