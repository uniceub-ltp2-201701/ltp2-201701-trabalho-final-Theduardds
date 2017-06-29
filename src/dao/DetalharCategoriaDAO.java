package dao;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Filme;
public class DetalharCategoriaDAO {
	
	private Connection conexao;
	public String categoria;

	public DetalharCategoriaDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Filme> getTodosFilmesPorCategoria(String categoria){
		
		PreparedStatement ps = null;
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		String c = this.getNomeCategoria(Integer.parseInt(categoria));

		try{
			ps = conexao.prepareStatement("select filme.idfilme,filme.titulo,filme.sinopse,filme.classificacao,filme.avaliacao,filme.duracao,filme.data_lancamento,filme.url from filme, categoriasfilme where categoriasfilme.nome like ? and filme.idfilme = categoriasfilme.idfilme");
			ps.setString(1, "%" + c + "%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){	
				filmes.add(new Filme(rs.getInt("idfilme"),rs.getString("titulo"), rs.getString("sinopse"), rs.getInt("classificacao"), 
						   rs.getDouble("avaliacao"), rs.getInt("duracao"), rs.getDate("data_lancamento"), rs.getString("url")));
			}

			ps.close();
			rs.close();
	
		}catch(Exception e){
			
		}
		
		return filmes;
		
	}
	
	public String getNomeCategoria(int idcategoria){
		
		PreparedStatement ps = null;
		
		String c = "";
		
		try{
			
			ps = conexao.prepareStatement("select nome from categoriasfilme where categoriasfilme.idcategoriasfilme = ?");
			ps.setInt(1, idcategoria);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				c = rs.getString("nome");
			}
		}catch(Exception e){
			
		}
		
		this.categoria = c;
		
		return c;
	}
	
}
