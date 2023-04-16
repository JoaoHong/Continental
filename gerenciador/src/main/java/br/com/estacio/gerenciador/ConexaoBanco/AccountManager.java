package br.com.estacio.gerenciador.ConexaoBanco;

import java.sql.*;

public class AccountManager {
	
	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://continentalbank.cv8y9fpum0xa.us-east-1.rds.amazonaws.com:3306/ContinentalBank";
		String username = "admin";
		String password = "3VAJZlkQb3AhrPCvA6jZ";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			
			int numConta = 1038;
			String tipoConta = "'CC'";
			String donoConta = "'Pedro Parro'";
			double saldo = 600.00;
			boolean status = false;
			
			
			String sqlAdd = "INSERT INTO ContaBanco (NumConta, TipoConta, DonoConta, Saldo, Status) VALUES(%s, %s , %s , %s , %s)".formatted(numConta, tipoConta, donoConta, saldo, status);
			
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
	
}
