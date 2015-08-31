package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
*@author Danilo Righetto;
*@version 1.0
*Curso da Alura - Servlet 3
*Pagina de Login
*/

@WebServlet(urlPatterns="/logout")
public class Logout extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*Vamos matar o cookie do usuario
		 * Dizendo que o tempo do cookie = 0*/
		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		PrintWriter writer = resp.getWriter();
		if(cookie == null){
			writer.println("<html><body>Usuario nao estava logado</body></html>");
			return;
		}
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		writer.println("<html><body>Deslogado com sucesso</body></html>");
	}
}