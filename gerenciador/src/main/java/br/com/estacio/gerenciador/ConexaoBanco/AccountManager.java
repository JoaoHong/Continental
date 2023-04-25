package br.com.estacio.gerenciador.ConexaoBanco;

import java.sql.*;
public class AccountManager {	
	public static void sacar(String numConta, String valorSaque) {
		String jdbcURL = "jdbc:mysql://continentalbank.cv8y9fpum0xa.us-east-1.rds.amazonaws.com:3306/ContinentalBank";
		String username = "admin";
		String password = "3VAJZlkQb3AhrPCvA6jZ";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			
			String sqlAdd = "UPDATE ContaBanco SET saldo = %s WHERE numConta = %s".formatted(valorSaque, numConta);
			
			Statement statement = connection.createStatement();
			
			int rows = statement.executeUpdate(sqlAdd);
			
			if (rows > 0) {
				System.out.println("Nova conta adicionada com sucesso!");
			}
			
			connection.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	public static void fecharconta(int numConta) {
		String jdbcURL = "jdbc:mysql://continentalbank.cv8y9fpum0xa.us-east-1.rds.amazonaws.com:3306/ContinentalBank";
		String username = "admin";
		String password = "3VAJZlkQb3AhrPCvA6jZ";
		
		try {
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
