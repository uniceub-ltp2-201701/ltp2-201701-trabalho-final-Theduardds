package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static Connection conexao = null;
	
	public static Connection getConexao(){
		
		if(conexao == null){
			
			try{

				Class.forName("com.mysql.jdbc.Driver");
				
				String url = "jdbc:mysql://localhost/filmes";
				String username = "root";
				String password = "root";
				
				conexao = DriverManager.getConnection(url,username,password);
				
			}catch(Exception e){
				
			}
		}
		
		return conexao;
		
	}

}
