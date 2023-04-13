package br.com.estacio.gerenciador.ConexaoBanco;

import java.sql.*;


public class ConexaoMySQL {

	public static String status = "Não conectado ao banco de dados";
	
	public ConexaoMySQL() {
		
	}
	
	
	//MONTA A CONNECTION STRING QUE FAZ A CONEXÃO COM O BANCO DE DADOS
	public static java.sql.Connection getConexaoMySQL(){
		
		Connection connection = null;
		
		try {
			
			
			//Quando for executar precisa colocar o driver do connector mysql na pasta do tomcat
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String serverName = "continentalbank.cv8y9fpum0xa.us-east-1.rds.amazonaws.com:3306";
			
			String mydatabase = "ContinentalBank";	
			
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			
			String user = "admin";
			
			String password = "3VAJZlkQb3AhrPCvA6jZ";
			
			connection = DriverManager.getConnection(url, user, password);
			
			if (connection != null) {
				status = ("Status: Banco conectado com sucesso!");
			}
			return connection;
			
		}catch(ClassNotFoundException e) {
			
			System.out.println("O driver expecificado nao foi encontrado.");
			
			return null;
			
		}catch (SQLException e) {
			
			System.out.println("Não foi possivel conectar ao banco de dados.");
			
			return null;
			
		}		
	}
	
	//RETORNA O STATUS DA CONEXÃO
	public static String statusConection(){
		
		return status;
		
	}
	
	//FECHA A CONEXÃO COM O BANCO DE DADOS
	public static boolean FecharConexao() {		
		try {
			
			ConexaoMySQL.getConexaoMySQL().close();
			
			return true;
			
		}catch (SQLException e){
			
			return false;
					
		}
	}
	
	//REINICIAR CONEXÃO COM O BANCO DE DADOS
	public static java.sql.Connection ReiniciarConexao(){
		 
		FecharConexao();
		
		return ConexaoMySQL.getConexaoMySQL();
			
	}
}
