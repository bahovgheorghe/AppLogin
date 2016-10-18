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
		PrintWriter writer = response.getWriter();
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();


		if (password.equals("123")) {
			//qui ricchiamo una seconda servlet che mi gestisce la stampa del Benvenuto			
			RequestDispatcher rd = request.getRequestDispatcher("Servlet2");
			writer.println("Loghin eseguito ");
//con questo codice permeto il collegamento con la mia seconda Servlet(Servlet2)			
			//rd.forward(request, response); //quando facciamo forward i dati della prima servlet muoiono
			rd.include(request, response);

		} else {

			RequestDispatcher rd2 = request.getRequestDispatcher("login.html");

			
		
			writer.println("Username o password sono errate");
			rd2.forward(request, response);
		}

	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();

		if (password.equals("123")) {
			//qui ricchiamo una seconda servlet che mi gestisce la stampa del Benvenuto			
			RequestDispatcher rd = request.getRequestDispatcher("Servlet2");

//con questo codice permeto il collegamento con la mia seconda Servlet(Servlet2)			
			rd.forward(request, response); //quando facciamo forward i dati della prima servlet muoiono
			

		} else {

			RequestDispatcher rd2 = request.getRequestDispatcher("login.html");

			
			PrintWriter writer = response.getWriter();
			writer.println("<h3 style="+"color:red"+">"+"Username o password sono errate</h3>");
			rd2.include(request, response);
		}
	}

}
