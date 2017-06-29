package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.RegistrarUsuarioDAO;

/**
 * Servlet implementation class ServletRegistrarUsuario
 */
@WebServlet("/registrarUsuario")
public class ServletRegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("registerUsuario");
		String senha = request.getParameter("registerSenha");
		
		Connection conexao = Conexao.getConexao();
		
		RegistrarUsuarioDAO rud = new RegistrarUsuarioDAO(conexao);
		
		boolean resultado = rud.addUsuario(nome, senha);
		
		request.setAttribute("resultado", resultado);
		RequestDispatcher rd = request.getRequestDispatcher("/respostaRegistrarUsuario.jsp");
		rd.forward(request, response);
	}

}
