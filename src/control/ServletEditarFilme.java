package control;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.DetalharFilmeDAO;
import dao.EditarFilmeDAO;
import dao.PegarCategoriasDAO;
import model.Categoria;
import model.Filme;
/**
 * Servlet implementation class ServletEditarFilme
 */
@WebServlet("/editarFilme")
public class ServletEditarFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditarFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();

		EditarFilmeDAO efd = new EditarFilmeDAO(conexao);
		
		String idfilme = request.getParameter("idfilme");
		
		DetalharFilmeDAO dfd = new DetalharFilmeDAO(conexao);
		
		Filme f = dfd.getFilme(idfilme);
		
		String titulo = request.getParameter("titulo");
		
		if(titulo.equals("")){
			titulo = f.getTitulo();
		}
		
		String sinopse = request.getParameter("sinopse");
		
		if(sinopse.equals("")){
			sinopse = f.getSinopse();
		}
		
		String c = request.getParameter("classificacao");

		int classificacao = 0;
		
		
		if(c.equals("")){
			classificacao = f.getClassificacao();
		}else{
			classificacao = Integer.parseInt(c);
		}
		
		String a = request.getParameter("avaliacao");
		double avaliacao = 0;
		
		if(a.equals("")){
			avaliacao = f.getAvaliacao();
		}else{
			avaliacao = Double.parseDouble(a);
		}
		
		String b = request.getParameter("duracao");
		int duracao = 0;
		
		if(b.equals("")){
			duracao = f.getDuracao();
		}else{
			duracao = Integer.parseInt(b);
		}
		
		String lancamento = request.getParameter("lancamento");
		
		java.sql.Date sqlDate = null;
		
		if(lancamento.equals("")){
			sqlDate = f.getData_lancamento();
		}else{
			sqlDate = java.sql.Date.valueOf(lancamento);
		}
		
		String url = request.getParameter("url");
		
		if(url.equals("")){
			url = f.getPoster();
		}

		boolean resultado = efd.editarFilme(titulo, sinopse, classificacao, avaliacao, duracao, sqlDate, url, f.getIdFilme());
		
		PegarCategoriasDAO pcd = new PegarCategoriasDAO(conexao);
		
		ArrayList<Categoria> categorias = pcd.pegarCategorias(idfilme);
		
		if(resultado){
			request.setAttribute("idfilme", idfilme);
			request.setAttribute("filme", f);
			RequestDispatcher rd = request.getRequestDispatcher("/detalharFilme");
			rd.forward(request, response);
		}else{
			request.setAttribute("mensagem", "Erro ao editar filme, tente novamente!");
			request.setAttribute("filme", f);
			request.setAttribute("categorias", categorias);
			RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaEditarFilme.jsp");
			rd.forward(request, response);
		}
	}

}
