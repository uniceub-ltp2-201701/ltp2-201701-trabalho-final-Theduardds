package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Categoria;

public class ListarCategoriasDAO {
	
	private Connection conexao;
	
	public ListarCategoriasDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Categoria> getTodasCategorias(){
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();

		
		PreparedStatement ps = null;
		
		try{
			
			ps = conexao.prepareStatement("select idcategoriasfilme, idfilme, nome from categoriasfilme group by nome");
			
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
