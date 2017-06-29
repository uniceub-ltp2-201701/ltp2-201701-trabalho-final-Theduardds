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
import static java.lang.System.out;
import dao.Conexao;
import dao.DetalharFilmeDAO;
import dao.PegarCategoriasDAO;
import model.Categoria;
import model.Filme;

/**
 * Servlet implementation class ServletPaginaEditarFilme
 */
@WebServlet("/paginaEditarFilme")
public class ServletPaginaEditarFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPaginaEditarFilme() {
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
		
		PegarCategoriasDAO pcd = new PegarCategoriasDAO(conexao);
		ArrayList<Categoria> c = pcd.pegarCategorias(idfilme);
		
		request.setAttribute("categorias", c);
		request.setAttribute("filme", f);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaEditarFilme.jsp");
		rd.forward(request, response);
		
	}

}
