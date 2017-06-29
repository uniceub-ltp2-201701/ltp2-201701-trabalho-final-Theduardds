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
import dao.DetalharDiretorDAO;
import dao.ListarFilmesDAO;
import model.Diretor;
import model.Filme;

/**
 * Servlet implementation class ServletPaginaEditarDiretor
 */
@WebServlet("/paginaEditarDiretor")
public class ServletPaginaEditarDiretor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPaginaEditarDiretor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conexao = Conexao.getConexao();
		
		String iddiretor = request.getParameter("iddiretor");
		
		DetalharDiretorDAO dad = new DetalharDiretorDAO(conexao);
		
		Diretor a = dad.getDiretor(iddiretor);
		
		ListarFilmesDAO lfd = new ListarFilmesDAO(conexao);
		ArrayList<Filme> f = lfd.getTodosFilmes();
		
		request.setAttribute("filmes", f);
		request.setAttribute("diretor", a);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaEditarDiretor.jsp");
		rd.forward(request, response);
		
	}

}
