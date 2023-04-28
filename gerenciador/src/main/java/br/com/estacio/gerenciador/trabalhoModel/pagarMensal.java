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

@WebServlet(urlPatterns="/pagarMensal")
public class pagarMensal extends HttpServlet{
	
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
			
			String saldoConta;
			String tipoConta;
			if(getConta.next()) {
				
				double valorMensal;
				
				saldoConta = getConta.getString("Saldo");
				
				tipoConta = getConta.getString("TipoConta");
				
				String statusConta = getConta.getString("Status");
				
				if(Integer.parseInt(statusConta) == 1) {
					
					if(tipoConta.equals("CC")) {
						valorMensal = 12.00;
					}
					else if(tipoConta.equals("CP")) {
						valorMensal = 20.00;
					}else {
						valorMensal = 0.00;
					}
										
					double valorSaldo = Double.parseDouble(saldoConta);
					
					double resultadoSaldo = valorSaldo - valorMensal;
					
					String sqlPagarMensal = "UPDATE ContaBanco SET Saldo = %s WHERE NumConta = %s".formatted(resultadoSaldo, numConta);
					
					Statement statement = connection.createStatement();
					
					int rows = statement.executeUpdate(sqlPagarMensal);
					
					if (rows > 0){
						out.println("Mensalidade paga com sucesso! Seu novo saldo é: " + resultadoSaldo);
					}
					
					connection.close();
				}else {
					out.println("Conta está desativada!");
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
