package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Diretor;
public class ListarDiretoresDAO {
	
	private Connection conexao;
	
	public ListarDiretoresDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Diretor> getTodosDiretores(){
		PreparedStatement ps = null;
		ArrayList<Diretor> diretores = new ArrayList<Diretor>();
		
		try{
			
			ps = conexao.prepareStatement("select * from diretor");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				diretores.add(new Diretor(rs.getInt("iddiretor"), rs.getInt("idfilme"), rs.getString("nome"), rs.getString("biografia"), rs.getDate("datanasc"), rs.getString("url")));
			}
			
			
			rs.close();
			ps.close();
			
		}catch(Exception e){
			
		}

		
		return diretores;
	}

}
