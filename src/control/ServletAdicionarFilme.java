package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdicionarFilmeDAO;
import dao.Conexao;
import dao.ListarFilmesDAO;

/**
 * Servlet implementation class ServletAdicionarFilme
 */
@WebServlet("/adicionarFilme")
public class ServletAdicionarFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdicionarFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = Conexao.getConexao();

		AdicionarFilmeDAO afd = new AdicionarFilmeDAO(conexao);
		
		String titulo = request.getParameter("titulo");
		String sinopse = request.getParameter("sinopse");
		String classificacao = request.getParameter("classificacao");
		int c = Integer.parseInt(classificacao);
		String genero = request.getParameter("genero");
		String a = request.getParameter("avaliacao");
		double avaliacao = Double.parseDouble(a);
		String b = request.getParameter("duracao");
		int duracao = Integer.parseInt(b);
		String lancamento = request.getParameter("lancamento");
		String url = request.getParameter("url");

		java.sql.Date sqlDate = java.sql.Date.valueOf(lancamento);		
		
		boolean resultado = afd.adicionarFilme(titulo, sinopse, genero, c, avaliacao, duracao, sqlDate, url);
				
		if(resultado){
			RequestDispatcher rd = request.getRequestDispatcher("/listarFilmes");
			rd.forward(request, response);
		}else{
			request.setAttribute("mensagem", "Erro ao adicionar diretor, tente novamente!");
			RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaAdicionarFilme.jsp");
			rd.forward(request, response);
		}
	}

}
