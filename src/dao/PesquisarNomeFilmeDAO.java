package dao;

import java.sql.Connection;
import java.util.ArrayList;

import model.Filme;

public class PesquisarNomeFilmeDAO {
	
	private Connection conexao;
	
	public PesquisarNomeFilmeDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Filme> pegarFilmesPorNome(String nome){
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		return filmes;
	}

}
