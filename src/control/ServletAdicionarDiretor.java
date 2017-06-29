package control;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdicionarDiretorDAO;
import dao.Conexao;
import dao.ListarAtoresDAO;

/**
 * Servlet implementation class ServletAdicionarDiretor
 */
@WebServlet("/adicionarDiretor")
public class ServletAdicionarDiretor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdicionarDiretor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = Conexao.getConexao();

		AdicionarDiretorDAO atd = new AdicionarDiretorDAO(conexao);
		
		String nome = request.getParameter("nome");
		String biografia = request.getParameter("biografia");
		String nasc = request.getParameter("nascimento");
		String idfilme = request.getParameter("idfilme");
		String url = request.getParameter("url");

		java.sql.Date sqlDate = java.sql.Date.valueOf(nasc);		
			
		boolean resultado = atd.adicionarDiretor(idfilme, nome, biografia, sqlDate, url);
		
		
		if(resultado){
			RequestDispatcher rd = request.getRequestDispatcher("/listarDiretores");
			rd.forward(request, response);
		}else{
			request.setAttribute("mensagem", "Erro ao adicionar diretor, tente novamente!");
			RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaAdicionarDiretor.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
