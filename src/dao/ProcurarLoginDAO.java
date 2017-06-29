package dao;

import java.sql.Connection;import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Usuario;

public class ProcurarLoginDAO {
	
	private Connection conexao;

	public ProcurarLoginDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public Usuario getUsuario(String nome, String senha){
		
		PreparedStatement ps = null;
		
		Usuario u = null;
		
		try{
			ps = conexao.prepareStatement("select idusuario, nome, senha, privilegio from usuario where usuario.nome = ? and usuario.senha = ?");
			ps.setString(1, nome);
			ps.setString(2, senha);
			
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				u = new Usuario(rs.getInt("idusuario"), rs.getString("nome"), rs.getString("senha"), rs.getInt("privilegio"));
			}
			
			ps.close();
			rs.close();
			
		}catch(Exception e){
			
		}
		return u;
	}

}
