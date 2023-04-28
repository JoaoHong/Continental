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

@WebServlet(urlPatterns="/abrirConta")
public class abrirConta extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String jdbcURL = "jdbc:mysql://continentalbank.cv8y9fpum0xa.us-east-1.rds.amazonaws.com:3306/ContinentalBank";
	private static final String username = "admin";
	private static final String password = "3VAJZlkQb3AhrPCvA6jZ";
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		String tipo = req.getParameter("tipo");
		String dono = req.getParameter("dono");
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
						
			// VERIFICA O NUMERO DA ULTIMA CONTA
			String sqlLastConta = "SELECT * FROM ContaBanco ORDER BY Id DESC limit 1";
			
			Statement statementGetConta = connection.createStatement();
			
			ResultSet lastConta = statementGetConta.executeQuery(sqlLastConta);
			if(lastConta.next()) {
				
			}
			String lastNum = lastConta.getString("NumConta");
			
			//ADD CONTA
			
			boolean status = true;
			double saldo;
			
			if(tipo.equals("CC")) {
				saldo = 50.00;
			}else if(tipo.equals("CP")){
				saldo = 150.00;
			}else {
				saldo = 0;
			}
			
			int numSoma = Integer.parseInt(lastNum);
			
			int numConta = numSoma + 1;
			
			String sqlAdd = "INSERT INTO ContaBanco (NumConta, TipoConta, DonoConta, Saldo, Status) VALUES(%s, '%s' , '%s' , %s , %s)".formatted(numConta, tipo, dono, saldo, status);
			
			Statement statement = connection.createStatement();
			
			int rows = statement.executeUpdate(sqlAdd);
			
			if (rows > 0) {
				out.println("Nova conta adicionada com sucesso!");
			}
			
			connection.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
}
