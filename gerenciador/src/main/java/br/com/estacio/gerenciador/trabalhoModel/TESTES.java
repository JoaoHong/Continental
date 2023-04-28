package br.com.estacio.gerenciador.trabalhoModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TESTES {
	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://continentalbank.cv8y9fpum0xa.us-east-1.rds.amazonaws.com:3306/ContinentalBank";
		String username = "admin";
		String password = "3VAJZlkQb3AhrPCvA6jZ";
		String tipo = "CC";
		String dono = "TESTE";
		String numConta = "1001";
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			
			String sqlGetConta = "SELECT * FROM ContaBanco WHERE NumConta = %s".formatted(numConta);
			
			Statement statementGetConta = connection.createStatement();
			
			ResultSet getConta = statementGetConta.executeQuery(sqlGetConta);
			
			if(getConta.next()) {
				String saldoConta = getConta.getString("Saldo");
				
				if(Double.parseDouble(saldoConta) > 0) {
					
					System.out.println("Saque todo seu dinheiro antes de cancelar sua conta!");
					connection.close();
					
				}else {
					String sqlclose = "UPDATE ContaBanco SET Status = false WHERE NumConta = %s".formatted(numConta); 
					
					Statement statement = connection.createStatement();
					
					int rows = statement.executeUpdate(sqlclose);
					
					if (rows > 0) {
						System.out.println("Sua conta foi cancelada com sucesso!");
					}
					
					connection.close();
				}
			}
			
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
}
