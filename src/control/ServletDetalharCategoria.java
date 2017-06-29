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
import dao.DetalharCategoriaDAO;
import model.Filme;
import static java.lang.System.out;
/**
 * Servlet implementation class ServletDetalharCategoria
 */
@WebServlet("/detalharCategoria")
public class ServletDetalharCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalharCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		String categoria = request.getParameter("categoria");
		
		DetalharCategoriaDAO dcd = new DetalharCategoriaDAO(conexao);
		
		ArrayList<Filme> filmes = dcd.getTodosFilmesPorCategoria(categoria);
		request.setAttribute("filmes", filmes);
		request.setAttribute("categoria", dcd.categoria);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaDetalharCategoria.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		String categoria = request.getParameter("categoria");
		
		DetalharCategoriaDAO dcd = new DetalharCategoriaDAO(conexao);
		
		ArrayList<Filme> filmes = dcd.getTodosFilmesPorCategoria(categoria);
		request.setAttribute("filmes", filmes);
		request.setAttribute("categoria", dcd.categoria);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaDetalharCategoria.jsp");
		rd.forward(request, response);
		
	}

}
