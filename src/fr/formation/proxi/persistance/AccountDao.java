package fr.formation.proxi.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.entity.SqlQueries;

public class AccountDao implements Dao<Account>{
	
	private final MySqlConnection mySqlConn;
	
	public AccountDao() {
		this.mySqlConn = MySqlConnection.getInstance();
	}
	
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



	@Override
	public Account update(Account entity) {
		try {
            Statement st = this.mySqlConn.getConn().createStatement();
            String queryNumber = String.format(SqlQueries.UPDATE_ACCOUNT, "Number", entity.getNumber(), entity.getId());
            String queryBalance = String.format(SqlQueries.UPDATE_ACCOUNT, "Balance", entity.getBalance(), entity.getId());
            String querySavings = String.format(SqlQueries.UPDATE_ACCOUNT, "Savingsl", entity.isSavings(), entity.getId());
            st.execute(queryNumber);
            st.execute(queryBalance);
            st.execute(querySavings);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	
	
	return entity;
	}

	@Override
	public Account read(Integer id) {
		Account results = null;
		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.READ, id));
			while (rs.next()) {
				Integer id_account =rs.getInt("id");
				String number = rs.getString("number");
				float balance = rs.getFloat("balance");
				boolean saving = rs.getBoolean("saving");
				
		results = new Account(id_account,number,balance,saving);
			

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
		
	}

	
	

}
