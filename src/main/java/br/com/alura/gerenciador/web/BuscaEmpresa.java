package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

/** 
*@author Danilo Righetto;
*@version 1.0
*Curso da Alura - Servlet 3
* 
*/

/*A annotation (WebServlet) diz que essa classe pode ser acessada atraves da URL '/busca' */
@WebServlet(urlPatterns="/busca")

public class BuscaEmpresa extends HttpServlet {

	/**Metodo 'doGet' para que a Servlet faca requisicoes para o Servidor
	*@param req
	*@param resp
	*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>");
		writer.println("Resultado da Busca: </br>");
		/*Vamos inserir o filtro de busca das empresas*/
		String filtro = req.getParameter("filtro");
		/*A Classe EmpresaDAO é uma implementação simulada de Banco de Dados*/
		Collection<Empresa> empresas =  new EmpresaDAO().buscaPorSimilaridade(filtro);
		writer.println("<ul>");
		for (Empresa empresa : empresas){
			writer.println("<li>" + empresa.getId() + ": " + empresa.getNome() + "</li>");
		}
		writer.println("</ul>");
		writer.println("</body></html>");
	}
	
}
