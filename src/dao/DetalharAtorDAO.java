package dao;

import java.sql.Connection;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.Out;

import model.Ator;
import model.Filme;

public class DetalharAtorDAO {

	private Connection conexao;

	public DetalharAtorDAO(Connection conexao){
		this.conexao = conexao;
	}

	public Ator getAtor(String idAtor){

		PreparedStatement ps = null;

		Ator a = null;

		try{

			ps = conexao.prepareStatement("select * from ator where idator = ?");
			ps.setInt(1, Integer.parseInt(idAtor));

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				a = new Ator(rs.getInt("idator"), rs.getInt("idfilme"), rs.getString("nome"), rs.getString("biografia"), rs.getDate("datanasc"), rs.getString("url"));
			}

			ps.close();
			rs.close();

		}catch(Exception e){

		}

		return a;

	}

	public ArrayList<Filme> getTodosFilmesPorAtor(String idAtor){

		PreparedStatement ps = null;
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		ResultSet rs = null;

		try{

			ps = conexao.prepareStatement("select filme.idfilme, filme.titulo, filme.sinopse, filme.classificacao, filme.avaliacao, filme.duracao, filme.data_lancamento, filme.url from filme, ator where ator.idator = ? and filme.idfilme = ator.idfilme");
			ps.setInt(1, Integer.parseInt(idAtor));
			
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
