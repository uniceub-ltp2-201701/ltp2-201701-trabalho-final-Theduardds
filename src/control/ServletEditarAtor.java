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
import dao.DetalharAtorDAO;
import dao.EditarAtorDAO;
import dao.ListarFilmesDAO;
import model.Ator;
import model.Filme;
import static java.lang.System.out;
/**
 * Servlet implementation class ServletEdtarAtor
 */
@WebServlet("/editarAtor")
public class ServletEditarAtor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditarAtor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = Conexao.getConexao();

		EditarAtorDAO ead = new EditarAtorDAO(conexao);
		
		String idator = request.getParameter("idator");
		
		DetalharAtorDAO dad = new DetalharAtorDAO(conexao);
		
		Ator a = dad.getAtor(idator);
		
		String nome = request.getParameter("nome");
		
		if(nome.equals("")){
			nome = a.getNome();
		}
		
		String biografia = request.getParameter("biografia");
		
		if(biografia.equals("")){
			biografia = a.getBiografia();
		}
		
		String nascimento = request.getParameter("nascimento");
		
		java.sql.Date sqlDate = null;
		
		if(nascimento.equals("")){
			sqlDate = a.getData_nasc();
		}else{
			sqlDate = java.sql.Date.valueOf(nascimento);
		}
		
		String url = request.getParameter("url");
		
		if(url.equals("")){
			url = a.getUrl();
		}
		
		String i = request.getParameter("idfilme");
		int idfilme = Integer.parseInt(i);

		boolean resultado = ead.editarAtor(nome,biografia,sqlDate,url, Integer.parseInt(idator), idfilme);
		
		ListarFilmesDAO lfd = new ListarFilmesDAO(conexao);
		ArrayList<Filme> f = lfd.getTodosFilmes();
		
		if(resultado){
			request.setAttribute("idfilme", idator);
			request.setAttribute("ator", a);
			RequestDispatcher rd = request.getRequestDispatcher("/detalharAtor");
			rd.forward(request, response);
		}else{
			request.setAttribute("mensagem", "Erro ao editar ator, tente novamente!");
			request.setAttribute("ator", a);
			request.setAttribute("filmes", f);
			RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaEditarAtor.jsp");
			rd.forward(request, response);
		}
	}

}
