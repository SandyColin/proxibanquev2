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

	public boolean transfer(Integer iddebit, Integer idcredit,Float montant) {
		Account debit = this.dao.read(iddebit);
		Account credit = this.dao.read(idcredit);
		Float soldeDispo = debit.getBalance();
		Float soldeCredit= credit.getBalance();
		if (soldeDispo-montant<0) return false;
		else {
			debit.setBalance(soldeDispo-montant);
			credit.setBalance(soldeCredit+montant);
			
			this.updateAccount(debit);
			this.updateAccount(credit);
			return true;
		}
		
		
	}
	public void updateAccount(Account account) {
		 this.dao.update(account);
	}
}
