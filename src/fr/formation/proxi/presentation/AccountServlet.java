package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.AccountService;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.entity.ClientService;

/**
 * @author Adminl Laila Bouzidi et Sandy Colin
 * La classe AccountServlet est le point d'entrée lors de l'appel de la page account.html
 */

public class AccountServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	@Override
	/**
	 * La méthode doGet() reprend l'identifiant client donnée par la page index.html afin de lire ses informations et 
	 * les redistribue à la page account.html pour pouvoir lire els informations concernant les comptes
	 * @param  req,  resp req représente la requete http d'entrée et resp la requete http de sortie(réponse)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idclient =Integer.parseInt(req.getParameter("id"));
		Client modify =ClientService.getInstance().getOne(idclient);
		req.setAttribute("client", modify);
		AccountService as=AccountService.getInstance();
		req.setAttribute("accounts", as.getAll(idclient));
		this.getServletContext().getRequestDispatcher("/WEB-INF/account.jsp").forward(req, resp);
	}
	
	

}
