package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class EditarFilmeDAO {
	
	private Connection conexao;
	
	public EditarFilmeDAO(Connection conexao){
		this.conexao = conexao;
	}

	public boolean editarFilme(String titulo, String sinopse, int classificacao, double avaliacao, int duracao, Date data_lancamento, String url, int idfilme){
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try{
			
			ps = conexao.prepareStatement("update filmes.filme set titulo=?, sinopse=?,classificacao=?,avaliacao=?,duracao=?,data_lancamento=?, url=? where idfilme = ?");
			ps.setString(1, titulo);
			ps.setString(2, sinopse);
			ps.setInt(3, classificacao);
			ps.setDouble(4, avaliacao);
			ps.setInt(5, duracao);
			ps.setDate(6, data_lancamento);
			ps.setString(7, url);
			ps.setInt(8, idfilme);
			
			ps.executeUpdate();

			ps.close();
			resultado = true;
		}catch(Exception e){
			
		}
		
		return resultado;
	}
}
