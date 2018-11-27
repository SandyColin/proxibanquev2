package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.entity.ClientService;
/**
 * @author Adminl Laila Bouzidi et Sandy Colin
 * La classe EditServlet est le point d'entrée lors de l'appel de la page edit.html
 */
public class EditServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
@Override
/**
 * La méthode doGet() reprend l'identifiant client donnée par la page index.html afin de lire ses informations et 
 * les redistribue à la page edit.html 
 * @param req, resp req représente la requete http d'entrée et resp la requete http de sortie(réponse)
 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Integer  id= Integer.parseInt(req.getParameter("id"));
	Client modify =ClientService.getInstance().getOne(id);
	req.setAttribute("client", modify);
	this.getServletContext().getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(req, resp);
	}

@Override
/**
 * La méthode doPost() reprend toutes les informations du client et les met à jour 
 * les redistribue à la page account.html pour pouvoir lire els informations concernant les comptes
 * @param req, resp req représente la requete http d'entrée et resp la requete http de sortie(réponse)
 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	ClientService service=ClientService.getInstance();
	Integer  id= Integer.parseInt(req.getParameter("id"));
	req.setAttribute("id",id);
	String  firstname= req.getParameter("firstname");
	req.setAttribute("firstname",firstname);
	String  lastname= req.getParameter("lastname");
	req.setAttribute("lastname",firstname);
	String  email= req.getParameter("email");
	req.setAttribute("email",email);
	String  address= req.getParameter("address");
	req.setAttribute("address",address);
	
	service.updateClient(id, firstname,lastname,email,address);
	resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");


	
}

}
