package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.ClientService;

public class EditServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD
	
	
=======
	Integer id = Integer.parseInt(req.getParameter("id"));
	req.setAttribute("id", id);
	ClientService.getInstance();
	this.getServletContext().getRequestDispatcher("/WEB-INF/edit.jsp").forward(req, resp);
>>>>>>> 6fe010a073eff22d497959cd26e6dead226d8796
	
}

}
