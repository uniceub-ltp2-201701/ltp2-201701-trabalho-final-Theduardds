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
import dao.ListarDiretoresDAO;
import model.Diretor;

/**
 * Servlet implementation class ServletListarAtores
 */
@WebServlet("/listarDiretores")
public class ServletListarDiretores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarDiretores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		ListarDiretoresDAO ldd = new ListarDiretoresDAO(conexao);
		
		ArrayList<Diretor> diretores = ldd.getTodosDiretores();
		
		request.setAttribute("diretores", diretores);
		RequestDispatcher rd = request.getRequestDispatcher("/respostaListarDiretores.jsp");
		rd.forward(request, response);
		
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		ListarDiretoresDAO ldd = new ListarDiretoresDAO(conexao);
		
		ArrayList<Diretor> diretores = ldd.getTodosDiretores();
		
		request.setAttribute("diretores", diretores);
		RequestDispatcher rd = request.getRequestDispatcher("/respostaListarDiretores.jsp");
		rd.forward(request, response);
		
	}



}
