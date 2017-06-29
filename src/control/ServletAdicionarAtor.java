package control;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdicionarAtorDAO;
import dao.Conexao;
import dao.ListarAtoresDAO;
import model.Ator;

/**
 * Servlet implementation class ServletAdicionarAtor
 */
@WebServlet("/adicionarAtor")
public class ServletAdicionarAtor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdicionarAtor() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();

		AdicionarAtorDAO atd = new AdicionarAtorDAO(conexao);
		
		String nome = request.getParameter("nome");
		String biografia = request.getParameter("biografia");
		String nasc = request.getParameter("nascimento");
		String idfilme = request.getParameter("idfilme");
		String url = request.getParameter("url");

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		java.sql.Date sqlDate = java.sql.Date.valueOf(nasc);		
			
		boolean resultado = atd.adicionarAtor(idfilme, nome, biografia, sqlDate, url);
		
		
		if(resultado){
			RequestDispatcher rd = request.getRequestDispatcher("/listarAtores");
			rd.forward(request, response);
		}else{
			request.setAttribute("mensagem", "Erro ao adicionar ator, tente novamente!");
			RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaAdicionarAtor.jsp");
			rd.forward(request, response);
		}
		
	}

}
