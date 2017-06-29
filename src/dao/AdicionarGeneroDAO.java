package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionarGeneroDAO {
	
	private Connection conexao;
	
	public AdicionarGeneroDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public void adicionarCategoria(String idfilme, String categoria){
		PreparedStatement ps = null;

		try{
			
			ps = conexao.prepareStatement("insert into categoriasfilme (idfilme, nome) values (?, ?)");
			ps.setInt(1, Integer.parseInt(idfilme));
			ps.setString(2, categoria);
			
			ps.executeUpdate();
			
			ps.close();

		}catch(Exception e){
			
		}
		
	}

}
