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
 * Servlet implementation class Servlet2
 */
@WebServlet(description = "Questo è un ricchiamo tramite un altro servlet", urlPatterns = { "/Servlet2" })
public class Servlet2 extends HttpServlet {
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

//qui stampo la session 
				writer1.println("Benvenuto " +session.getAttribute("usernameSalvatoSession") +"<br>" );

				
//qui rispondo con la servlet con servlet in html		
				response.setContentType("text/html");
				
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//qui sto dicendo al browser che sto scrivendo un file .html	
		response.setContentType("text/html");

//qui prendo i dati dal input della pagina login.html
		String name = request.getParameter("username");
	
//dicchiaro una sessione e un context	
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
//controllo se il campo e valido 	
		if (!name.isEmpty() && name != null) {
//questo serve per salvare il cookie del utente e lo ricorda per 30
//minuti di default
			session.setAttribute("usernameSalvatoSession", name);
//context vive per tutta la vita dell'aplicazione.	
			context.setAttribute("usernameSalvatoContext", name);
		}
//dicchiaro il writer che ci permete di stampare		
			PrintWriter writer1 = response.getWriter();

//qui stampo la session 
		writer1.println("Benvenuto " +session.getAttribute("usernameSalvatoSession") +"<br>" );

		
//qui rispondo con la servlet con servlet in html		
		response.setContentType("text/html");

	}

}
