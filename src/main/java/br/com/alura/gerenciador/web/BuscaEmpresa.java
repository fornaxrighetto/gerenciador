package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
*@author Danilo Righetto;
*@version 1.0
*Curso da Alura - Servlet 3
*@param 
* 
*/

public class BuscaEmpresa extends HttpServlet {

	/**Metodo 'doGet' para que a Servlet faca requisicoes para o Servidor
	*@param req
	*@param resp
	*
	*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>");
		writer.println("Resultado da Busca: </br>");
		writer.println("</body></html>");
	}
	
}
