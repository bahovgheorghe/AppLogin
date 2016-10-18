package it.alfasoft.gheorghe;

import java.io.IOException;
import java.io.PrintWriter;

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
		
	//qui sto dicendo al browser che sto scrivendo un file .html	
		response.setContentType("text/html");
	
	//qui prendo i dati dal input della pagina login.html
		String name = request.getParameter("username");
	
	//dicchiaro una sessione e un context	
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
	//controllo se il campo e valido 	
		if (!name.isEmpty() && name != null) {
		// questo serve per salvare il cookie del utente e lo ricorda per 30
		// minuti di default
			session.setAttribute("usernameSalvatoSession", name);
		//context vive per tutta la vita dell'aplicazione.	
			context.setAttribute("usernameSalvatoContext", name);
		}
//dicchiaro il writer che ci permete di stampare		
			PrintWriter writer1 = response.getWriter();
//	qui stampa dar writer
			writer1.println("Ciao " +name+ "<br>" );
//qui stampo la session 
		writer1.println("Ciao da session " +session.getAttribute("usernameSalvatoSession") +"<br>" );
//qui stampo da context 		
		writer1.println("Ciao da Context " +context.getAttribute("usernameSalvatoContext") +"<br>" );
		
//qui rispondo con la servlet con servlet in html		
		response.setContentType("text/html");
		
//torna indietro un PrintWriter		

	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter writer1 = response.getWriter();

		if (password.equals("123")) {
			writer1.println("<h1>" + "Benvenuto " + username+ " hai la password " + password + "</h1>");

		} else {
			response.sendRedirect("login.html");
		}
	}

	

}
