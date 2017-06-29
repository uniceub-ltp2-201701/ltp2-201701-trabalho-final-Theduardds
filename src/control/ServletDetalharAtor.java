package control;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.DetalharAtorDAO;
import model.Ator;
import model.Filme;

/**
 * Servlet implementation class ServletDetalharAtor
 */
@WebServlet("/detalharAtor")
public class ServletDetalharAtor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalharAtor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		String idAtor = request.getParameter("idator");
		
		DetalharAtorDAO dad = new DetalharAtorDAO(conexao);
		
		Ator a = dad.getAtor(idAtor);
		ArrayList<Filme> f = dad.getTodosFilmesPorAtor(idAtor);
		
		
		request.setAttribute("ator", a);
		request.setAttribute("filmes", f);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaDetalharAtor.jsp");
		rd.forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		String idAtor = request.getParameter("idator");
		
		DetalharAtorDAO dad = new DetalharAtorDAO(conexao);
		
		Ator a = dad.getAtor(idAtor);
		ArrayList<Filme> f = dad.getTodosFilmesPorAtor(idAtor);
		
		
		request.setAttribute("ator", a);
		request.setAttribute("filmes", f);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaDetalharAtor.jsp");
		rd.forward(request, response);
	
	}

}
