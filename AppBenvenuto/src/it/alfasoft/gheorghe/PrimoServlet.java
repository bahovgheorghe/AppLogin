package it.alfasoft.gheorghe;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PrimoServlet
 */
@WebServlet(description = "Questo è un esempio di Servlet", urlPatterns = { "/Percorso" })
public class PrimoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		HttpSession session = request.getSession(); 
		
		
		
		if (password.equals("123")){
			
			RequestDispatcher rd = request.getRequestDispatcher("Servlet2");
			rd.forward(request, response);
			
		} else {
			response.sendRedirect("index.html");
		}

	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();

		if (password.equals("123")) {
//			response.sendRedirect("Benvenuto.html");
//			session.setAttribute("usernameSalvatoSession", name);
//			session.setAttribute("usernameSalvatoSession", password);
			
			RequestDispatcher rd = request.getRequestDispatcher("Servlet2");
			rd.forward(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

}
