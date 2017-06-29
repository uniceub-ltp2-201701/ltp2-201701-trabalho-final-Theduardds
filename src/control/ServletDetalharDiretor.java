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
import model.Diretor;
import model.Filme;

/**
 * Servlet implementation class ServletDetalharDiretor
 */
@WebServlet("/detalharDiretor")
public class ServletDetalharDiretor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalharDiretor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = Conexao.getConexao();
		
		String idDiretor = request.getParameter("iddiretor");
		
		DetalharDiretorDAO ddd = new DetalharDiretorDAO(conexao);
		
		Diretor d = ddd.getDiretor(idDiretor);
		ArrayList<Filme> f = ddd.getTodosFilmesPorDiretor(idDiretor);

		request.setAttribute("diretor", d);
		request.setAttribute("filmes", f);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaDetalharDiretor.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = Conexao.getConexao();
		
		String idDiretor = request.getParameter("iddiretor");
		
		DetalharDiretorDAO ddd = new DetalharDiretorDAO(conexao);
		
		Diretor d = ddd.getDiretor(idDiretor);
		ArrayList<Filme> f = ddd.getTodosFilmesPorDiretor(idDiretor);

		request.setAttribute("diretor", d);
		request.setAttribute("filmes", f);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaDetalharDiretor.jsp");
		rd.forward(request, response);
	}

}
