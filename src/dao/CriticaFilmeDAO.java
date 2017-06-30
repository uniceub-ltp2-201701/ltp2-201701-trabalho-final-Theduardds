package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Critica;
import model.Usuario;

public class CriticaFilmeDAO {
	
	private Connection conexao;
	
	public CriticaFilmeDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean adicionarCritica(String idfilme, String idusuario, String critica){
		PreparedStatement ps = null;
		
		boolean resultado = false;
		
		try{
			
			ps = conexao.prepareStatement("insert into criticafilmes (idfilme, idusuario, critica) values (?,?,?)");
			ps.setInt(1, Integer.parseInt(idfilme));
			ps.setInt(2, Integer.parseInt(idusuario));
			ps.setString(3, critica);
			
			ps.executeUpdate();
			
			ps.close();
			
			resultado = true;
		}catch(Exception e){
			
		}
		
		return resultado;
	}
	
	public ArrayList<Critica> pegarCriticasPorFilme(String idfilme){
		
		ArrayList<Critica> criticas = new ArrayList<Critica>();
		
		PreparedStatement ps = null;
		
		try{
			
			ps = conexao.prepareStatement("select * from criticafilmes where idfilme = ?");
			ps.setInt(1, Integer.parseInt(idfilme));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				criticas.add(new Critica(rs.getInt("idcriticafilmes"), rs.getInt("idfilme"), rs.getInt("idusuario"), rs.getString("critica")));
			}
			
			ps.close();
			rs.close();
			
		}catch(Exception e){
			
		}
		
		return criticas;
	}
	
	public ArrayList<Usuario> pegarTodosUsuarios(){
		ArrayList<Usuario> u = new ArrayList<Usuario>();
		
		PreparedStatement ps = null;
		
		try{
			
			ps = conexao.prepareStatement("select * from usuario, criticafilmes where usuario.idusuario = criticafilmes.idusuario");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				u.add(new Usuario(rs.getInt("idusuario"), rs.getString("nome"), rs.getString("senha"), rs.getInt("privilegio")));
			}
			
			ps.close();
			rs.close();
			
		}catch(Exception e){
			
		}
		
		return u;
	}

}
