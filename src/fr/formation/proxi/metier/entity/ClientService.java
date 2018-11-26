package fr.formation.proxi.metier.entity;

import java.util.List;

import fr.formation.proxi.persistance.ClientDao;


public class ClientService {
	
	private static final ClientService INSTANCE = new ClientService(); 
	
	public static ClientService getInstance() {
		return ClientService.INSTANCE;
	}
	
	
	private final ClientDao dao; 
	
	public ClientService() {
		this.dao = new ClientDao();
	}
	
	
	public List<Client> getAll() {  
		return this.dao.readAll(); 
	}
	public void updateClient(Client client) {
		this.dao.update(client );
	}
	

}
