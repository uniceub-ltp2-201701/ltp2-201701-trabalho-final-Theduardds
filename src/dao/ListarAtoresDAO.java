package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Ator;

public class ListarAtoresDAO {

	private Connection conexao;

	public ListarAtoresDAO(Connection conexao){
		this.conexao = conexao;
	}

	public ArrayList<Ator> getTodosAtores(){

		PreparedStatement ps = null;
		ArrayList<Ator> atores = new ArrayList<Ator>();

		try{

			ps = conexao.prepareStatement("select * from ator");
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				atores.add(new Ator(rs.getInt("idator"),rs.getInt("idfilme"), rs.getString("nome"), rs.getString("biografia"), rs.getDate("datanasc"), rs.getString("url")));
			}

			rs.close();
			ps.close();

		}catch(Exception e){

		}

		return atores;
	}

}
