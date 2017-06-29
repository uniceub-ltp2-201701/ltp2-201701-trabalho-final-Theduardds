package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Categoria;
import model.Filme;
public class ListarFilmesDAO {

	private Connection conexao;
	
	public ListarFilmesDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Filme> getTodosFilmes(){
		
		PreparedStatement ps = null;
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		try{
			
			ps = conexao.prepareStatement("select * from filme");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				filmes.add(new Filme(rs.getInt("idFilme"),rs.getString("titulo"), rs.getString("sinopse"), rs.getInt("classificacao"), 
						   rs.getDouble("avaliacao"), rs.getInt("duracao"), rs.getDate("data_lancamento"), rs.getString("url")));
			}
			
			rs.close();
			ps.close();
			
		}catch(Exception e){
			
		}
		
		return filmes;
		
	}
	
	public ArrayList<Filme> getFilmesPorPontuacao(String simbolo, String pontuacao){
		
		PreparedStatement ps = null;
		ArrayList<Filme> filmes = new ArrayList<Filme>();

		
		try{
			
			if(simbolo.equals(">")){
				ps = conexao.prepareStatement("select * from filme where filme.avaliacao > ?");
			
				ps.setInt(1, Integer.parseInt(pontuacao));
			}
			if(simbolo.equals("<")){
				ps = conexao.prepareStatement("select * from filme where avaliacao < ?");
				
				ps.setInt(1, Integer.parseInt(pontuacao));
			}
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				filmes.add(new Filme(rs.getInt("idFilme"),rs.getString("titulo"), rs.getString("sinopse"), rs.getInt("classificacao"), 
						   rs.getDouble("avaliacao"), rs.getInt("duracao"), rs.getDate("data_lancamento"), rs.getString("url")));
				
				
			}
			
			rs.close();
			ps.close();
			
		}catch(Exception e){
			
		}
		
		return filmes;
		
	}
	
}
