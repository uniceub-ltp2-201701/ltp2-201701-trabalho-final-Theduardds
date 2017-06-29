package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Categoria;

public class PegarCategoriasDAO {
	
	private Connection conexao;
	
	public PegarCategoriasDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Categoria> pegarCategorias(String idfilme){
		
		PreparedStatement ps = null;
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		
		try{
			
			ps = conexao.prepareStatement("select * from categoriasfilme where idfilme = ?");
			ps.setInt(1, Integer.parseInt(idfilme));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				categorias.add(new Categoria(rs.getInt("idcategoriasfilme"), rs.getInt("idfilme"), rs.getString("nome")));
			}
			
			ps.close();
			rs.close();
			
		}catch(Exception e){
			
		}
		
		return categorias;
	}

}
