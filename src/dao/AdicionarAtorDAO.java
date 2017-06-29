package dao;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class AdicionarAtorDAO {
	
	private Connection conexao;
	
	public AdicionarAtorDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean adicionarAtor(String idfilme, String nome, String biografia, Date nasc, String url){
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try{
			
			ps = conexao.prepareStatement("insert into ator (idfilme, nome, biografia, datanasc, url)"
					+ "values (?, ?, ?, ?, ?)");
			ps.setInt(1, Integer.parseInt(idfilme));
			ps.setString(2, nome);
			ps.setString(3, biografia);
			ps.setDate(4, nasc);
			ps.setString(5, url);
			
			ps.executeUpdate();
			ps.close();
			resultado = true;
		}catch(Exception e){
			
		}
		
		return resultado;
	}

}
