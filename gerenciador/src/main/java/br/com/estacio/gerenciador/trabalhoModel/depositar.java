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

@WebServlet(urlPatterns="/depositar")
public class depositar extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String jdbcURL = "jdbc:mysql://continentalbank.cv8y9fpum0xa.us-east-1.rds.amazonaws.com:3306/ContinentalBank";
	private static final String username = "admin";
	private static final String password = "3VAJZlkQb3AhrPCvA6jZ";
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PrintWriter out = resp.getWriter();
		
		String numConta = req.getParameter("numConta");
		String valorDeposito = req.getParameter("valorDeposito");
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
						
			// VERIFICA O NUMERO DA ULTIMA CONTA
			String sqlGetConta = "SELECT * FROM ContaBanco WHERE NumConta = %s".formatted(numConta);
			
			Statement statementGetConta = connection.createStatement();
			
			ResultSet getConta = statementGetConta.executeQuery(sqlGetConta);
			
			String saldoConta;
			
			if(getConta.next()) {
				
				saldoConta = getConta.getString("Saldo");
				
				String statusConta = getConta.getString("Status");
				if(statusConta.equals("1")) {
					
					double valorSaldo = Double.parseDouble(saldoConta);
					
					double resultadoSaldo = valorSaldo + Double.parseDouble(valorDeposito);
					
					String sqlDepositar = "UPDATE ContaBanco SET Saldo = %s WHERE NumConta = %s".formatted(resultadoSaldo, numConta);
					
					Statement statement = connection.createStatement();
					
					int rows = statement.executeUpdate(sqlDepositar);
					
					if (rows > 0){
						out.println("Valor depositado com sucesso! Seu novo saldo é: " + resultadoSaldo);
					}
					
					connection.close();
				}else {
					out.println("Conta desativada!");
					connection.close();	
				}
				
				
			}else {
				out.println("Conta não existente!");
				connection.close();			
			}
						
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
}
