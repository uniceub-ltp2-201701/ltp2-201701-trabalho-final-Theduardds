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
import dao.DetalharAtorDAO;
import dao.ListarFilmesDAO;
import model.Ator;
import model.Filme;

/**
 * Servlet implementation class ServletPaginaEditarAtor
 */
@WebServlet("/paginaEditarAtor")
public class ServletPaginaEditarAtor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPaginaEditarAtor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conexao = Conexao.getConexao();
		
		String idator = request.getParameter("idator");
		
		DetalharAtorDAO dad = new DetalharAtorDAO(conexao);
		
		Ator a = dad.getAtor(idator);
		
		ListarFilmesDAO lfd = new ListarFilmesDAO(conexao);
		ArrayList<Filme> f = lfd.getTodosFilmes();
		
		request.setAttribute("filmes", f);
		request.setAttribute("ator", a);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaEditarAtor.jsp");
		rd.forward(request, response);
		
	}

}
