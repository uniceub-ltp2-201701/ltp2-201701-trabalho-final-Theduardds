package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.lang.System.out;
public class AvaliarFilmeDAO {
	
	private Connection conexao;
	
	public AvaliarFilmeDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public void avaliarFilme(String idfilme, String usuario, String nota){
		PreparedStatement ps = null;
		
		double media = this.mediaFilme(idfilme);
		double notaatual = Double.parseDouble(nota);
		notaatual = (notaatual+media)/2;

		try{
			
			ps = conexao.prepareStatement("insert into avaliacoesfilme (idfilme,idusuario,avaliacao) values (?,?,?)");
			ps.setInt(1, Integer.parseInt(idfilme));
			ps.setInt(2, Integer.parseInt(usuario));
			ps.setDouble(3, notaatual);
			
			ps.executeUpdate();
			
			ps.close();
		}catch(Exception e){
			
		}
	}

	public double mediaFilme(String idFilme){
		PreparedStatement ps = null;
		
		double media = 0;
		
		try{
			
			ps = conexao.prepareStatement("select avaliacao from avaliacoesfilme where idfilme = ?");
			ps.setInt(1, Integer.parseInt(idFilme));
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
				media = rs.getDouble("avaliacao");
				
			ps.close();
		}catch(Exception e){
			
		}
		
		return media;
	}
	
	public int quantidadePorFilme(String idfilme){
		PreparedStatement ps = null;
		
		int quantidade = 0;
		
		try{
			
			ps = conexao.prepareStatement("select count(idfilme) from avaliacoesfilme where idfilme = ?");
			ps.setInt(1, Integer.parseInt(idfilme));
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
				quantidade = rs.getInt("count(idfilme)");

			
			ps.close();
		}catch(Exception e){
			
		}
		
		
		if(quantidade==1)
			quantidade = 2;
		
		return quantidade;
	}
}
