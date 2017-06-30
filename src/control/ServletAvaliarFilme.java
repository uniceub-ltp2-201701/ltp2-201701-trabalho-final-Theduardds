package control;

import static java.lang.System.out;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AvaliarFilmeDAO;
import dao.Conexao;
import dao.DetalharFilmeDAO;
import dao.PegarCategoriasDAO;
import model.Ator;
import model.Categoria;
import model.Diretor;
import model.Filme;

/**
 * Servlet implementation class ServletAvaliarFilme
 */
@WebServlet("/avaliarFilme")
public class ServletAvaliarFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAvaliarFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = Conexao.getConexao();
		
		String idFilme = request.getParameter("idfilme");
		String usuario = request.getParameter("usuario");
		String nota = request.getParameter("nota");

		AvaliarFilmeDAO afd = new AvaliarFilmeDAO(conexao);
		
		afd.avaliarFilme(idFilme, usuario, nota);
		
		DetalharFilmeDAO dfd = new DetalharFilmeDAO(conexao);
		PegarCategoriasDAO pcd = new PegarCategoriasDAO(conexao);
		Filme f = dfd.getFilme(idFilme);	
		ArrayList<Ator> atores = dfd.getAtorPorFilme(idFilme);
		ArrayList<Diretor> diretores = dfd.getDiretorPorFilme(idFilme);
		ArrayList<Categoria> categorias = pcd.pegarCategorias(idFilme);
		double avaliacao = afd.mediaFilme(idFilme);
		
		request.setAttribute("filme", f);
		request.setAttribute("atores", atores);
		request.setAttribute("diretores", diretores);
		request.setAttribute("categorias", categorias);
		request.setAttribute("avaliacao", avaliacao);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaDetalharFilme.jsp");
		rd.forward(request, response);
	}

}
