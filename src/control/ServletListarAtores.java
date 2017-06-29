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
import dao.ListarAtoresDAO;
import model.Ator;

/**
 * Servlet implementation class ServletListarAtores
 */
@WebServlet("/listarAtores")
public class ServletListarAtores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarAtores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		ListarAtoresDAO lad = new ListarAtoresDAO(conexao);
		
		ArrayList<Ator> atores = lad.getTodosAtores();
		
		request.setAttribute("atores", atores);
		RequestDispatcher rd = request.getRequestDispatcher("/respostaListarAtores.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		ListarAtoresDAO lad = new ListarAtoresDAO(conexao);
		
		ArrayList<Ator> atores = lad.getTodosAtores();
		
		request.setAttribute("atores", atores);
		RequestDispatcher rd = request.getRequestDispatcher("/respostaListarAtores.jsp");
		rd.forward(request, response);
		
	}

}
