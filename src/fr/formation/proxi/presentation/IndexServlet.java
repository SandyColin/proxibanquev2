package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.ClientService;
/**
 * @author Adminl Laila Bouzidi et Sandy Colin
 * La classe IndexServlet est le point d'entrée lors de l'appel de la page index.html
 */
public class IndexServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	@Override
	/**
	 * La méthode doGet() permet l'affichage de la liste des clients 
	 * @param req, resp req représente la requete http d'entrée et resp la requete http de sortie(réponse)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClientService cs=ClientService.getInstance();
		req.setAttribute("clients", cs.getAll());
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
	}

	@Override
	/**
	 * La méthode doPost() reprend l'identifiant client donnée  afin de lire ses informations et 
	 * les redistribue à la page sélectionnée (via action)
	 * @param req, resp req représente la requete http d'entrée et resp la requete http de sortie(réponse)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id=Integer.parseInt(req.getParameter("id"));
		req.setAttribute("id", id);
		String action=req.getParameter("action1");
		switch(action) {
		case "edit" : 
			resp.sendRedirect(this.getServletContext().getContextPath() + "/edit.html?id="+id);
			break;
		case "account" :
			resp.sendRedirect(this.getServletContext().getContextPath() + "/account.html?id="+id);
			break;
		case "transfer" :
			resp.sendRedirect(this.getServletContext().getContextPath() + "/transfer.html?id="+id);
			break;
		}
		
	}


}
