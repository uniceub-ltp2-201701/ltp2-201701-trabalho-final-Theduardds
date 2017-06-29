package dao;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Ator;
import model.Diretor;
import model.Filme;

public class DetalharDiretorDAO {

	private Connection conexao;

	public DetalharDiretorDAO(Connection conexao){
		this.conexao = conexao;
	}

	public Diretor getDiretor(String idDiretor){

		PreparedStatement ps = null;

		Diretor a = null;

		try{

			ps = conexao.prepareStatement("select * from diretor where iddiretor = ?");
			ps.setInt(1, Integer.parseInt(idDiretor));

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				a = new Diretor(rs.getInt("iddiretor"), rs.getInt("idfilme"), rs.getString("nome"), rs.getString("biografia"), rs.getDate("datanasc"), rs.getString("url"));
			}

			ps.close();
			rs.close();

		}catch(Exception e){

		}

		return a;

	}

	public ArrayList<Filme> getTodosFilmesPorDiretor(String idDiretor){

		PreparedStatement ps = null;
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		ResultSet rs = null;

		try{

			ps = conexao.prepareStatement("select filme.idfilme, filme.titulo, filme.sinopse, filme.classificacao, filme.avaliacao, filme.duracao, filme.data_lancamento, filme.url from filme, diretor where diretor.iddiretor = ? and filme.idfilme = diretor.idfilme");
			ps.setInt(1, Integer.parseInt(idDiretor));
			
			rs = ps.executeQuery();

			while(rs.next()){
				filmes.add(new Filme(rs.getInt("idfilme"), rs.getString("titulo"), rs.getString("sinopse"), rs.getInt("classificacao"), rs.getDouble("avaliacao"), rs.getInt("duracao"), rs.getDate("data_lancamento"), rs.getString("url")));
			}

			rs.close();
			ps.close();

		}catch(Exception e){

		}

		return filmes;

	}

}
