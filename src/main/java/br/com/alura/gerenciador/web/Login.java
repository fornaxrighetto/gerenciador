package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

/** 
*@author Danilo Righetto;
*@version 1.0
*Curso da Alura - Servlet 3
*Pagina de Login
*/

@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*O usuario vai LOGAR com Email e Senha*/
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		PrintWriter writer = resp.getWriter();
		/*Vamos validar se o usuario existe ou nao*/
		if(usuario == null){
			writer.println("<html><body>Usuario Invalido!</body></html>");
		}else{
			/*Vamos trabalhar com SESSION para o nosso Login e Logout*/
			HttpSession session = req.getSession();
			session.setAttribute("usuario.logadp", usuario);
			
			
			/*Se o usuario existir mostre o email do usuario logado*/
			writer.println("<html><body>Usuario Logado: "+ usuario.getEmail() +" </body></html>");
		}
	}
}
