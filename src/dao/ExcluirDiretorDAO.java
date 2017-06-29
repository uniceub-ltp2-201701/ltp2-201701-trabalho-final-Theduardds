package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import static java.lang.System.out;
public class ExcluirDiretorDAO {
	
	private Connection conexao;
	
	public ExcluirDiretorDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean excluirDiretor(String diretor){
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try{
			
			
			ps = conexao.prepareStatement("delete from diretor where iddiretor = ?");
			ps.setInt(1, Integer.parseInt(diretor));
			
			ps.executeUpdate();
			ps.close();
			
			resultado = true;
			
		}catch(Exception e){
			
		}
		
		return resultado;
		
	}

}
