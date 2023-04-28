package br.com.estacio.gerenciador.trabalhoModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/fecharConta")
public class fecharConta extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private static final String jdbcURL = "jdbc:mysql://continentalbank.cv8y9fpum0xa.us-east-1.rds.amazonaws.com:3306/ContinentalBank";
	private static final String username = "admin";
	private static final String password = "3VAJZlkQb3AhrPCvA6jZ";
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PrintWriter out = resp.getWriter();
		String numConta = req.getParameter("numConta");
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			
			String sqlGetConta = "SELECT * FROM ContaBanco WHERE NumConta = %s".formatted(numConta);
			
			Statement statementGetConta = connection.createStatement();
			
			ResultSet getConta = statementGetConta.executeQuery(sqlGetConta);
			
			if(getConta.next()) {
				String saldoConta = getConta.getString("Saldo");
				String statusAtual = getConta.getString("Status");
				
				if(Double.parseDouble(saldoConta) > 0) {
					
					out.println("Saque todo seu dinheiro antes de cancelar sua conta!");
					connection.close();
					
				}else if(statusAtual.equals("0")) {
					out.println("Conta já esta desativada!");
					connection.close();
				}else {
					String sqlclose = "UPDATE ContaBanco SET Status = false WHERE NumConta = %s".formatted(numConta); 
					
					Statement statement = connection.createStatement();
					
					int rows = statement.executeUpdate(sqlclose);
					
					if (rows > 0) {
						out.println("Sua conta foi cancelada com sucesso!");
					}
					
					connection.close();
				}
			}
			
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
}
