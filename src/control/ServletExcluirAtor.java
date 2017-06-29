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
import dao.ExcluirAtorDAO;
import dao.ListarAtoresDAO;
import model.Ator;

/**
 * Servlet implementation class ServletExcluirAtor
 */
@WebServlet("/excluirAtor")
public class ServletExcluirAtor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirAtor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conexao = Conexao.getConexao();
		
		String idator = request.getParameter("idator");
		
		ExcluirAtorDAO ead = new ExcluirAtorDAO(conexao);
		
		boolean resultado = ead.excluirAtor(idator);
		
		ListarAtoresDAO dfd = new ListarAtoresDAO(conexao);
		
		ArrayList<Ator> a = dfd.getTodosAtores();
		
		if(resultado){
			request.setAttribute("atores", a);
			RequestDispatcher rd = request.getRequestDispatcher("/listarAtores");
			rd.forward(request, response);
		}else{
			request.setAttribute("mensagem", "Erro ao excluir filme, tente novamente!");
			request.setAttribute("atores", a);
			RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaEditarDiretor.jsp");
			rd.forward(request, response);
		}
		
	}

}
