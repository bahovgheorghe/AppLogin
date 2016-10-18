package it.alfasoft.gheorghe;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StampaTabella
 */
@WebServlet(description = "questo stampa una tabella come risponse", urlPatterns = { "/StampaTabella" })
public class StampaTabella extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");//questo bisogna sempre mettere perche se non lo metto non mi stampa la rensponse
		
		PrintWriter writer = response.getWriter();//dicchiaro il metodo per scrivere
		
//meto una table in una stringa		
		String tabela=("<table><th>A</th><th>B</th>"
				       +"<tr><td> 1</td><td> 2</td></tr>"
				       +" <tr><td> 3</td><td> 4</td></tr>"+" </table>");
		
		writer.println(tabela);//stampo la tabella
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
}
