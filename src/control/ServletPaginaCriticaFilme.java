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
import dao.CriticaFilmeDAO;
import dao.DetalharFilmeDAO;
import model.Critica;
import model.Filme;
import model.Usuario;

/**
 * Servlet implementation class ServletPaginaCriticaFilme
 */
@WebServlet("/paginaCriticaFilme")
public class ServletPaginaCriticaFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPaginaCriticaFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = Conexao.getConexao();
		
		String idfilme = request.getParameter("idfilme");
		
		DetalharFilmeDAO dfd = new DetalharFilmeDAO(conexao);
		
		Filme f = dfd.getFilme(idfilme);
		
		request.setAttribute("filme", f);
		RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaCriticaFilme.jsp");
		rd.forward(request, response);
		
		
	}
	
}
