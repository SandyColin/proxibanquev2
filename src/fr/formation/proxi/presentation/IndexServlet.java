package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.ClientService;

public class IndexServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClientService cs=ClientService.getInstance();
		req.setAttribute("clients", cs.getAll());
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		req.setAttribute("id", id);
		String action=req.getParameter("action1");
		
		
		switch(action) {
		case "edit" : 
			resp.sendRedirect(this.getServletContext().getContextPath() + "/edit.html");
			break;
		case "account" :
			resp.sendRedirect(this.getServletContext().getContextPath() + "/account.html");
			break;
		case "transfer" :
			resp.sendRedirect(this.getServletContext().getContextPath() + "/transfer.html");
			break;
		}
		
	}


}
