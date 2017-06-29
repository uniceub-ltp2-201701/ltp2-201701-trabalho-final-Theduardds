package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegistrarUsuarioDAO {
	
	private Connection conexao;
	
	public RegistrarUsuarioDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean addUsuario(String nome, String senha){
		
		PreparedStatement ps = null;
		
		boolean resultado = false;
		
		try{
			
			ps = conexao.prepareStatement("insert into usuario (nome, senha, privilegio) values (?,?,0)");
			ps.setString(1, nome);
			ps.setString(2, senha);
			
			ps.executeUpdate();

			ps.close();
			resultado = true;
			
		}catch(Exception e){
			
		}
		
		return resultado;
		
	}

}
