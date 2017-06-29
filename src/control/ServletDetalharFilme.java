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
import dao.PegarCategoriasDAO;
import model.Ator;
import model.Categoria;
import model.Diretor;
import model.Filme;
import static java.lang.System.out;
/**
 * Servlet implementation class ServletDetalharFilme
 */
@WebServlet("/detalharFilme")
public class ServletDetalharFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalharFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		String idFilme = request.getParameter("idfilme");
		
		DetalharFilmeDAO dfd = new DetalharFilmeDAO(conexao);
		PegarCategoriasDAO pcd = new PegarCategoriasDAO(conexao);
		
		Filme f = dfd.getFilme(idFilme);	
		ArrayList<Ator> atores = dfd.getAtorPorFilme(idFilme);
		ArrayList<Diretor> diretores = dfd.getDiretorPorFilme(idFilme);
		ArrayList<Categoria> categorias = pcd.pegarCategorias(idFilme);
		
		request.setAttribute("filme", f);
		request.setAttribute("atores", atores);
		request.setAttribute("diretores", diretores);
		request.setAttribute("categorias", categorias);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaDetalharFilme.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		String idFilme = request.getParameter("idfilme");
		
		DetalharFilmeDAO dfd = new DetalharFilmeDAO(conexao);
		PegarCategoriasDAO pcd = new PegarCategoriasDAO(conexao);
		
		Filme f = dfd.getFilme(idFilme);	
		ArrayList<Ator> atores = dfd.getAtorPorFilme(idFilme);
		ArrayList<Diretor> diretores = dfd.getDiretorPorFilme(idFilme);
		ArrayList<Categoria> categorias = pcd.pegarCategorias(idFilme);
		
		request.setAttribute("filme", f);
		request.setAttribute("atores", atores);
		request.setAttribute("diretores", diretores);
		request.setAttribute("categorias", categorias);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaDetalharFilme.jsp");
		rd.forward(request, response);
		
	}

}
