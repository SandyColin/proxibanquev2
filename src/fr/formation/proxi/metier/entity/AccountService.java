package fr.formation.proxi.metier.entity;

import java.util.List;

import fr.formation.proxi.persistance.AccountDao;


/**
 * La classe AccountService regroupe les méthodes liées à la classe Account qui ne sont pas en lien direct avec le CRUD
 * @author Sandy&Laila
 *
 */
public class AccountService {

private static final AccountService INSTANCE = new AccountService(); 
	/**
	 * La méthode getInstance() permet de faire une seule instanciation de la classe AccountService
	 * @return AccountService un objet de type AccountService.
	 */
	public static AccountService getInstance() {
		return AccountService.INSTANCE;
	}
	
	
	private final AccountDao dao; 
	/**
	 * constructeur par défaut de la classe AccountService
	 */
	public AccountService() {
		this.dao = new AccountDao();
	}
	/**
	 * la méthode getAll permet de lire tout les comptes d'un client à partir de son identifiant.
	 * @param id l'identifiant du client
	 * @return un objet de type List<Account>.
	 */
	
	public List<Account> getAll(Integer id) {  
		return this.dao.read1(id); 
	}
    /**
     * Méthode permettant de faire un transfert d'un compte à un autre
     * @param iddebit numéro de compte à débiter
     * @param idcredit numéro de compte à créditer
     * @param montant le montant à créditer 
     * @return 
     */
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
