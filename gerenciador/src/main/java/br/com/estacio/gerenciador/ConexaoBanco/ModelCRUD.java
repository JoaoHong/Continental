package br.com.estacio.gerenciador.ConexaoBanco;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModelCRUD extends HttpServlet {
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws ServletException, IOException {
	    String param1 = request.getParameter("param1");
	    String param2 = request.getParameter("param2");

	    // faça algo com os parâmetros recebidos

	    response.setContentType("text/plain");
	    response.getWriter().write("Parâmetros recebidos: " + param1 + ", " + param2);
	  }
	}