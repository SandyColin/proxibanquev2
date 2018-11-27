package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.AccountService;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.entity.ClientService;

public class TransferServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idclient =Integer.parseInt(req.getParameter("id"));
		Client transfer =ClientService.getInstance().getOne(idclient);
		req.setAttribute("client", transfer);
		AccountService as=AccountService.getInstance();
		req.setAttribute("accounts", as.getAll(idclient));
		this.getServletContext().getRequestDispatcher("/WEB-INF/transfer.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Integer iddebit = Integer.parseInt(req.getParameter("iddebit"));
	Integer idcredit = Integer.parseInt(req.getParameter("idcredit"));
	Float montant=Float.parseFloat(req.getParameter("montant"));
	AccountService as=AccountService.getInstance();
	req.setAttribute("iddebit", iddebit);
	req.setAttribute("idcredit", idcredit);
	req.setAttribute("montant", montant);
	
	if (!as.transfer(iddebit, idcredit, montant)) {
		System.out.println("Le montant est supérieur ");
	}
		
	//resp.sendRedirect(this.getServletContext().getContextPath() + "/account.html?id="+id);
	
	
	}
}
