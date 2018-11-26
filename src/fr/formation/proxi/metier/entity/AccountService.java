package fr.formation.proxi.metier.entity;

import java.util.List;

import fr.formation.proxi.persistance.AccountDao;
import fr.formation.proxi.persistance.ClientDao;

public class AccountService {

private static final AccountService INSTANCE = new AccountService(); 
	
	public static AccountService getInstance() {
		return AccountService.INSTANCE;
	}
	
	
	private final AccountDao dao; 
	
	public AccountService() {
		this.dao = new AccountDao();
	}
	
	
	public List<Account> getAll() {  
		return this.dao.readAll(); 
	}
	
}
