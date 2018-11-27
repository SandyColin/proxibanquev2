package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import fr.formation.proxi.metier.entity.AccountService;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.entity.ClientService;
/**
 * @author Adminl Laila Bouzidi et Sandy Colin
 * La classe TransfertServlet est le point d'entrée lors de l'appel de la page transfer.html
 */
public class TransferServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(TransferServlet.class);
	
	/**
	 * La méthode doGet() reprend l'identifiant client donnée par la page index.html afin de lire ses informations et 
	 * les redistribue à la page transfer.html pour pouvoir lire les informations concernant les comptes
	 * @param  req, resp req représente la requete http d'entrée et resp la requete http de sortie(réponse)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idclient =Integer.parseInt(req.getParameter("id"));
		Client transfer =ClientService.getInstance().getOne(idclient);
		req.setAttribute("client", transfer);
		AccountService as=AccountService.getInstance();
		req.setAttribute("accounts", as.getAll(idclient));
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/transfer.jsp").forward(req, resp);
	}

	/**
	 * La méthode doPost() reprend l'identifiant des comptes selectionnées par "le conseiller" afin de lire ses informations et le montant du transfert
	 * pour vérifier si ce virement est possible. Selon le montant le virement est effectué ou on revient sur la même page
	 * 
	 * @param req, resp req représente la requete http d'entrée et resp la requete http de sortie(réponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Integer iddebit = Integer.parseInt(req.getParameter("iddebit"));
	Integer idcredit = Integer.parseInt(req.getParameter("idcredit"));
	Float montant=Float.parseFloat(req.getParameter("montant"));
	AccountService as=AccountService.getInstance();
	req.setAttribute("iddebit", iddebit);
	req.setAttribute("idcredit", idcredit);
	req.setAttribute("montant", montant);
	String message = "Le virement ne peut pas avoir lieu. Soit le montant est supérieur au solde disponible, soit vous avez mis le même compte en débiteur et créditeur ";
	
	if (!as.transfer(iddebit, idcredit, montant)) {
		TransferServlet.LOGGER.info(message);
		req.setAttribute("message", message);
		this.doGet(req, resp);
	}
	else 
	{
		this.doGet(req, resp);
	}
	}
}
