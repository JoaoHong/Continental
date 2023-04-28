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

@WebServlet(urlPatterns="/sacar")
public class sacar extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static final String jdbcURL = "jdbc:mysql://continentalbank.cv8y9fpum0xa.us-east-1.rds.amazonaws.com:3306/ContinentalBank";
	private static final String username = "admin";
	private static final String password = "3VAJZlkQb3AhrPCvA6jZ";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		String numConta = req.getParameter("numConta");
		String valorSaque = req.getParameter("valorSaque");
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			
			String sqlGETCONTA = "SELECT * FROM ContaBanco WHERE NumConta = %s".formatted(numConta);
			
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery(sqlGETCONTA);
			
			if(result.next()) {
				String saldoRes = result.getString("Saldo");
				
				double valorSaldo = Double.parseDouble(saldoRes);
				
				if(valorSaldo < Double.parseDouble(valorSaque)) {
					out.println("Valor não disponivel para saque.");
					connection.close();
				}else {
					double resultadoSaldo = valorSaldo - Double.parseDouble(valorSaque);
					
					String sqlSaqueConta = "UPDATE ContaBanco SET Saldo = %s WHERE NumConta = %s".formatted(resultadoSaldo, numConta);
					
					Statement statementUpdate = connection.createStatement();
					
					int rows = statementUpdate.executeUpdate(sqlSaqueConta);
					
					if (rows > 0){
						out.println("Saque realizado com sucesso! Seu novo saldo é: " + resultadoSaldo);
					}
				}
				
				connection.close();
			}else {
				out.println("Nenhuma conta encontrada.");
				connection.close();
			}
			
			
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
}
