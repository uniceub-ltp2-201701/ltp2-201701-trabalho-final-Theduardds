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
import static java.lang.System.out;
/**
 * Servlet implementation class ServletEscreverCriticaFilme
 */
@WebServlet("/escreverCriticaFilme")
public class ServletEscreverCriticaFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEscreverCriticaFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = Conexao.getConexao();
		
		String idfilme = request.getParameter("idfilme");
		String idusuario = request.getParameter("idusuario");
		String critica = request.getParameter("critica");
		
		out.println(idfilme);
		out.println(idusuario);
		out.println(critica);
		
		CriticaFilmeDAO cfd = new CriticaFilmeDAO(conexao);
		
		boolean resultado = cfd.adicionarCritica(idfilme, idusuario, critica);
		
		DetalharFilmeDAO dad = new DetalharFilmeDAO(conexao);
		
		Filme f = dad.getFilme(idfilme);
		
		ArrayList<Critica> criticas = cfd.pegarCriticasPorFilme(idfilme);
		ArrayList<Usuario> usuarios = cfd.pegarTodosUsuarios();
		
		request.setAttribute("f", f);
		request.setAttribute("criticas", criticas);
		request.setAttribute("usuarios", usuarios);
		
		if(resultado){
			RequestDispatcher rd = request.getRequestDispatcher("/criticaFilme");
			rd.forward(request, response);
		}else{
			request.setAttribute("mensagem", "Erro ao escrever crítica, tente novamente!");
			RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaCriticaFilme.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = Conexao.getConexao();
		
		String idfilme = request.getParameter("idfilme");
		String idusuario = request.getParameter("idusuario");
		String critica = request.getParameter("critica");
		
		out.println(idfilme);
		out.println(idusuario);
		out.println(critica);
		
		CriticaFilmeDAO cfd = new CriticaFilmeDAO(conexao);
		
		boolean resultado = cfd.adicionarCritica(idfilme, idusuario, critica);
		
		DetalharFilmeDAO dad = new DetalharFilmeDAO(conexao);
		
		Filme f = dad.getFilme(idfilme);
		
		ArrayList<Critica> criticas = cfd.pegarCriticasPorFilme(idfilme);
		ArrayList<Usuario> usuarios = cfd.pegarTodosUsuarios();
		
		request.setAttribute("f", f);
		request.setAttribute("criticas", criticas);
		request.setAttribute("usuarios", usuarios);
		
		if(resultado){
			RequestDispatcher rd = request.getRequestDispatcher("/criticaFilme");
			rd.forward(request, response);
		}else{
			request.setAttribute("mensagem", "Erro ao escrever crítica, tente novamente!");
			RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaCriticaFilme.jsp");
			rd.forward(request, response);
		}
	}

}
