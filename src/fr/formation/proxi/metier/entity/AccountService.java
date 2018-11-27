package fr.formation.proxi.metier.entity;

import java.util.List;

import fr.formation.proxi.persistance.AccountDao;


public class AccountService {

private static final AccountService INSTANCE = new AccountService(); 
	
	public static AccountService getInstance() {
		return AccountService.INSTANCE;
	}
	
	
	private final AccountDao dao; 
	
	public AccountService() {
		this.dao = new AccountDao();
	}
	
	
	public List<Account> getAll(Integer id) {  
		return this.dao.read1(id); 
	}
<<<<<<< HEAD
	public boolean transfer() {
		float montant;
		if (Account.getBalance()-montant>0) return true;
=======
	public boolean transfer(Integer iddebit, Integer idcredit,Float montant) {
		this.dao.read(iddebit);
		if (this.dao.read(iddebit).getBalance()-montant<0) return false;
>>>>>>> f84a41918f180e973d87b7340159598bb3591060
				
		else {
			this.dao.read(iddebit).setBalance(this.dao.read(iddebit).getBalance()-montant);
			this.dao.read(iddebit).setBalance(this.dao.read(idcredit).getBalance()-montant);
			this.dao.update(this.dao.read(iddebit));
			this.dao.update(this.dao.read(idcredit));
			return true;
		}
		
		
	}
	public void updateAccount(Integer id, String number, Float balance, boolean savings) {
		Account account = new Account(id, number, balance, savings);
		 this.dao.update(account);
	}
}
