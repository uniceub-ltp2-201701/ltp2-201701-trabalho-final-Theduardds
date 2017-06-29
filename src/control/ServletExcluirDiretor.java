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
import dao.ExcluirDiretorDAO;
import dao.ListarDiretoresDAO;
import model.Diretor;

/**
 * Servlet implementation class ServletExcluirDiretor
 */
@WebServlet("/excluirDiretor")
public class ServletExcluirDiretor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirDiretor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conexao = Conexao.getConexao();
		
		String iddiretor = request.getParameter("iddiretor");
		
		ExcluirDiretorDAO ead = new ExcluirDiretorDAO(conexao);
		
		boolean resultado = ead.excluirDiretor(iddiretor);
		
		ListarDiretoresDAO dfd = new ListarDiretoresDAO(conexao);
		
		ArrayList<Diretor> d = dfd.getTodosDiretores();
		
		if(resultado){
			request.setAttribute("diretores", d);
			RequestDispatcher rd = request.getRequestDispatcher("/listarDiretores");
			rd.forward(request, response);
		}else{
			request.setAttribute("mensagem", "Erro ao excluir filme, tente novamente!");
			request.setAttribute("atores", d);
			RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaEditarDiretor.jsp");
			rd.forward(request, response);
		}
	}

}
