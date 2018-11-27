package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.AccountService;

public class TransferServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idclient =Integer.parseInt(req.getParameter("idclient"));
		AccountService as=AccountService.getInstance();
		req.setAttribute("accounts", as.getAll(idclient));
		this.getServletContext().getRequestDispatcher("/WEB-INF/transfer.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
