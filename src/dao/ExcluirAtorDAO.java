package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import static java.lang.System.out;
public class ExcluirAtorDAO {
	
	private Connection conexao;
	
	public ExcluirAtorDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean excluirAtor(String ator){
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try{
			
			
			ps = conexao.prepareStatement("delete from ator where idator = ?");
			ps.setInt(1, Integer.parseInt(ator));
			
			ps.executeUpdate();
			ps.close();
			
			resultado = true;
			
		}catch(Exception e){
			
		}
		
		return resultado;
		
	}

}
