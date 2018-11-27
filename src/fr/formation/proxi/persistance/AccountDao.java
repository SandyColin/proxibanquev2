package fr.formation.proxi.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Account;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}
