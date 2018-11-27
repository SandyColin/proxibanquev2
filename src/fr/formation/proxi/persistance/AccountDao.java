package fr.formation.proxi.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.SqlQueries;

/**
 * {@InheritDoc}
 * La classe AccountDao implémente l'interface Dao.
 * @author Sandy&laila
 *
 */
public class AccountDao implements Dao<Account>{
	
	private final MySqlConnection mySqlConn;
	/**
	 * Constructeur par défaut.
	 */
	public AccountDao() {
		this.mySqlConn = MySqlConnection.getInstance();
	}
	/**
	 * Méthode permettant d'afficher tout les comptes
	 * @return une liste de compte avec toute les propriétees 
	 */
	public List<Account> readAll() {
		List<Account> results = new ArrayList<>();
		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(SqlQueries.READ_ALL_ACCOUNT);
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String number = rs.getString("number");
				Float balance = rs.getFloat("balance");
				boolean savings = rs.getBoolean("savings");
				results.add(new Account(id, number, balance, savings));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

/**
 * Méthode permettant d'afficher la liste des comptes d'un client à partir de son identifiant.
 * @param idclient l'identifiant du client.
 * @return un objet de type List<Account> qui represente la liste des comptes d'un client.
 */

	public List<Account> read1(Integer idclient) {
		List<Account> results = new ArrayList<>();
		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.READ_ACCOUNT, idclient));
			while (rs.next()) {
				Integer id=rs.getInt("id");
				String number = rs.getString("number");
				Float balance = rs.getFloat("balance");
				boolean savings = rs.getBoolean("savings");
				results.add(new Account(id, number, balance, savings));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

/**
 * Méthode permettant de mettre à jour un compte.
 * @param entity représente le compte qu'on veut mettre à jour.
 * @return un objet de type Account (compte mise à jour)
 */

	
	public Account update(Account entity) {
		try {
            Statement st = this.mySqlConn.getConn().createStatement();
            String query = String.format(SqlQueries.UPDATE_ACCOUNT, entity.getNumber(),entity.getBalance(), entity.isSavings() ? "1" : "0", entity.getId());
            st.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	
	
	return entity;
	}

/**
 * Méthode permettant de lire un compte à partir d'un identifiant de compte.
 * @param id c'est l'identifiant du compte qu'on souhaite lire.
 * @return un objet de type Account.
 */
	public Account read(Integer id) {
		Account results = null;
		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.READ, id));
			
				rs.next();
				String number = rs.getString("number");
				Float balance = rs.getFloat("balance");
				boolean savings = rs.getBoolean("savings");
				
		results = new Account(id,number,balance,savings);
				
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
		
	}

	
	

}
