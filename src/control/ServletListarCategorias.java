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
import dao.ListarCategoriasDAO;
import model.Categoria;

/**
 * Servlet implementation class ServletListarCategorias
 */
@WebServlet("/listarCategorias")
public class ServletListarCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarCategorias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		ListarCategoriasDAO ccd = new ListarCategoriasDAO(conexao);
		
		ArrayList<Categoria> categorias = ccd.getTodasCategorias();
		
		request.setAttribute("categorias", categorias);
		RequestDispatcher rd = request.getRequestDispatcher("/respostaListarCategorias.jsp");
		rd.forward(request, response);
	}

}
