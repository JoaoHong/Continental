package br.com.estacio.gerenciador.ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Teste {
	
	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://continentalbank.cv8y9fpum0xa.us-east-1.rds.amazonaws.com:3306/ContinentalBank";
		String username = "admin";
		String password = "3VAJZlkQb3AhrPCvA6jZ";
		
		try {
			int numConta = 1234; 
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			
String sqlclose = "UPDATE ContaBanco SET Saldo = %s, Status = false WHERE NumConta = %s".formatted(0, numConta); 
			
			Statement statement = connection.createStatement();
			
			int rows = statement.executeUpdate(sqlclose);
			
			if (rows > 0) {
				System.out.println("Sua conta foi cancelada com sucesso!");
			}
			
			connection.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
}
