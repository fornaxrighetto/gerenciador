package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

/**
 * @author Danilo Righetto
 * Servlet NovaEmpresa
 */

@WebServlet(urlPatterns="/novaEmpresa")
public class NovaEmpresa extends HttpServlet {
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * Dentro do nosso doGet estamos adicionando uma NovaEmpresa
	 * Porem o GET nao e o melhor metodo para o nosso uso pois o GET possui limite de envio para o servidor
	 * Por isso vamos trocar o doGet para doPost
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>Empresa Adicionada com Sucesso: "+ empresa.getNome() +"</body></html>");
	}
	/* O HTTP suporta alem do GET e do POST os metodos:
	 * delete, head, trace entre outros.
	 * Mas os Navegadores apenas suportam os metodos: GET, POST e o HEAD 
	 */
}
