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

	String  firstname= req.getParameter("firstname");
	req.setAttribute("firstname",firstname);
	String  lastname= req.getParameter("lastname");
	req.setAttribute("lastname",firstname);
	String  email= req.getParameter("email");
	req.setAttribute("email",email);
	String  address= req.getParameter("address");
	req.setAttribute("address",address);
	ClientService service=ClientService.getInstance();
	service.update(client);
	resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
	this.getServletContext().getRequestDispatcher("/WEB-INF/edit.jsp").forward(req, resp);

	
}

}
