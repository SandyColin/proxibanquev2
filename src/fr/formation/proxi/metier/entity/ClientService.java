package fr.formation.proxi.metier.entity;

import java.util.List;

import fr.formation.proxi.persistance.ClientDao;


/**
 * @author Adminl Laila Bouzidi et Sandy Colin
 *La classe Client Service regroupe les méthodes liée à la classe Client 
 *qui ne sont pas en lien directement avec le CRUD
 */

public class ClientService {
	
	private static final ClientService INSTANCE = new ClientService(); 
	private final ClientDao dao; 
	
	/**
	 * La méthode getInstance() permet de faire une seule instanciation dans la classe
	 * @return ClientService Un objet de type ClientService
	 */
	public static ClientService getInstance() {
		return ClientService.INSTANCE;
	}
	
	
	
	/**
	 * Constructeur par défaut de la classe
	 */
	public ClientService() {
		this.dao = new ClientDao();
	}
	/**
	 * La méthode getAll() permet d'obtenir une liste de tous les clients qui 
	 * sont dans la base de données
	 * @return List<Client> Une liste de tous les clients avec leurs propriétés
	 */
	
	public List<Client> getAll() {  
		return this.dao.readAll(); 
	}
	/**
	 * Cette méthode permet de mettre à jour les informations du client 
	 * (elle fait appel à la méthode update du CRUD via ClientDao) 
	 * @param id identifiant unique du client
	 * @param firstname prénom du client
	 * @param lastname nom du client
	 * @param email adresse mail du client
	 * @param address adresse postale du client
	 */
	public void updateClient(Integer id, String firstname, String lastname, String email, String address) {
		Client  client=new Client(id, firstname,lastname,email,address);
		 this.dao.update(client);
	}
/**
 * La méthode GetOne() permet de lire les informations d'un client précis grâce à son identifiant
 * @param idclient identifiant du client
 * @return un objet de type Client (avec toutes les propriétés)
 */
	public Client getOne(Integer idclient) {
		return this.dao.read(idclient);
	}
}
