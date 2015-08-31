package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

/** 
*@author Danilo Righetto;
*@version 1.0
*Curso da Alura - Servlet 3
*Pagina de Login
*/

public class Cookies {

	private final Cookie[] cookies; 
	
	public Cookies(Cookie[] cookies) {
		this.cookies = cookies;
	}

	public Cookie buscaUsuarioLogado() {
		if(cookies == null) return null;
		//Vamos usar o FOR para encontrar o valor dos nomes dos cookies
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("usuario.logado")){
				return cookie;
			}
		}
		return null;
	}
	
	
}
