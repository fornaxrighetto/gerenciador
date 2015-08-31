package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Danilo Righetto
 * Filtro de Auditoria
 * @version 1.0
 * Curso da Alura - Servlet 3
 */

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		/*Como estamos trabalhando com HTTP vamos usar o request e o responde do HTTPServlet*/
		HttpServletRequest req = (HttpServletRequest) request;
		/*Agora quero saber qual e a URI que o cliente esta requisitando*/
		String uri = req.getRequestURI();
		/*Vamos pegar o nome do usuario pelo Cookie*/
		String usuario = getUsuario(req);
		
		System.out.println("Usuario"+ usuario +" acessando a URI: " + uri);
		
		/*Depois que ele imprimiu no console continue com a requisicao*/
		chain.doFilter(request, response);
	}

	private String getUsuario(HttpServletRequest req) {
		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		if(cookie == null) return "<deslogado>";
		return cookie.getValue();
		
		/*
		String usuario = "<deslogado>";
		Cookie[] cookies = req.getCookies();
		if(cookies == null) return usuario;
		//Vamos usar o FOR para encontrar o valor dos nomes dos cookies
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("usuario.logado")){
				usuario = cookie.getValue();
			}
		}
		return usuario;
		*/
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	
}
