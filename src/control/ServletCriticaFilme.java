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
 * Servlet implementation class ServletCriticaFilme
 */
@WebServlet("/criticaFilme")
public class ServletCriticaFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCriticaFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		String idfilme = request.getParameter("idfilme");
		
		DetalharFilmeDAO dad = new DetalharFilmeDAO(conexao);
		
		Filme f = dad.getFilme(idfilme);
		
		CriticaFilmeDAO cfd = new CriticaFilmeDAO(conexao);
		ArrayList<Critica> criticas = cfd.pegarCriticasPorFilme(idfilme);
		ArrayList<Usuario> usuarios = cfd.pegarTodosUsuarios();
		
		request.setAttribute("f", f);
		request.setAttribute("criticas", criticas);
		request.setAttribute("usuarios", usuarios);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaCriticaFilme.jsp");
		rd.forward(request, response);
		
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		String idfilme = request.getParameter("idfilme");
		
		DetalharFilmeDAO dad = new DetalharFilmeDAO(conexao);
		
		Filme f = dad.getFilme(idfilme);
		
		CriticaFilmeDAO cfd = new CriticaFilmeDAO(conexao);
		ArrayList<Critica> criticas = cfd.pegarCriticasPorFilme(idfilme);
		ArrayList<Usuario> usuarios = cfd.pegarTodosUsuarios();
		
		request.setAttribute("criticas", criticas);
		request.setAttribute("usuarios", usuarios);
		request.setAttribute("f", f);
		RequestDispatcher rd = request.getRequestDispatcher("/respostaCriticaFilme.jsp");
		rd.forward(request, response);
		
	}

}
