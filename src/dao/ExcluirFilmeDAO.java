package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import static java.lang.System.out;
public class ExcluirFilmeDAO {
	
	private Connection conexao;
	
	public ExcluirFilmeDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean excluirFilme(String idfilme){
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try{
			
			
			ps = conexao.prepareStatement("delete from filme where idfilme = ?");
			ps.setInt(1, Integer.parseInt(idfilme));
			
			ps.executeUpdate();
			ps.close();
			
			resultado = true;
			
		}catch(Exception e){
			
		}
		
		return resultado;
		
	}

}
