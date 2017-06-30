<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="model.Filme" %>
    <%@ page import="model.Ator" %>
    <%@ page import="model.Diretor" %>
    <%@ page import="model.Usuario"%>
    <%@ page import="model.Categoria"%>
    <%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/respostaDetalharFilme.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="/scripts/snippet-javascript-console.min.js?v=1"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalhar Filme</title>
</head>
<body>

<nav role="navigation">
  <div id="menuToggle">

    <input type="checkbox" />
 
    <span></span>
    <span></span>
    <span></span>
    

    <ul id="menu">
      <a href="/SistemaFilmes/listarFilmes"><li><i class="material-icons" style="font-size:25px; margin-left:10px;">movie</i>Filmes</li></a>
      <a href="/SistemaFilmes/listarAtores"><li><i class="material-icons" style="font-size:25px; margin-left:10px;">person</i>Atores</li></a>
      <a href="/SistemaFilmes/listarDiretores"><li><i class="material-icons" style="font-size:25px; margin-left:10px;">record_voice_over</i>Diretores</li></a>
      <a href="/SistemaFilmes/listarCategorias"><li><i class="material-icons" style="font-size:25px; margin-left:10px;">book</i>Categorias</li></a>
      <a href="/SistemaFilmes/mainPage"><li><i class="material-icons" style="font-size:25px; margin-left:10px;">home</i>Página Principal</li></a>
    </ul>
  </div>
</nav>

<%  Filme f = (Filme)request.getAttribute("filme");
	ArrayList<Ator> atores = (ArrayList<Ator>) request.getAttribute("atores");
	ArrayList<Diretor> diretores = (ArrayList<Diretor>) request.getAttribute("diretores");
	ArrayList<Categoria> categorias = (ArrayList<Categoria>) request.getAttribute("categorias");
	double avaliacao = (double) request.getAttribute("avaliacao");

	HttpSession s = (HttpSession) request.getSession(true);
	Usuario u = (Usuario)s.getAttribute("admin");

	%>
	
	
	
	<%if(!(u==null)){%>


			<table style="border-collapse: collapse;align: center;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);border:1px solid #4CAF50;background-color: #4CAF50;text-align: left;background-color: #4CAF50;color: white;;float:right;">
				<th style="padding:23px;">Logado em <%out.println(u.getNome());%></th>
				<th style="padding:23px;"><a href="/SistemaFilmes/logoff">Logoff</th>
			</table>
		
		<br>
	<%}%>
	<table style="border-collapse: collapse;margin-right:30px; align: center;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);border:1px solid #4CAF50;background-color: #4CAF50;text-align: left;width:auto;background-color: #4CAF50;color: white;float:right;">
	<th><a href="criticaFilme?idfilme=<%=f.getIdFilme() %>" style="color:white;">Críticas</a></th>
	</table>
	
	<%if(!(u==null) && u.getPrivilegio()==1){ %>
	
	<br><br><br>
	
	<div class="container" style="width: 250px; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);color:white; float: right; padding: 15px; border:1px solid #c62828;background-color: #c62828; height: auto; width: 130px; text-align: center; word-wrap: break-word; text-overflow: ellipsis;">
			<a href="/SistemaFilmes/paginaEditarFilme?idfilme=<%out.println(f.getIdFilme());%>" style="color:white;">Editar Filme</a>
		</div>
	
	<%}%>
	

	

	<div class="texto" align="center" style="margin-top:50px;">
	<table border="1" cellspacing="0" cellpadding="0">
	<th><%out.println(f.getTitulo());%></th>
	</table><br><br>
	<table border="1">
	<th>Avaliação média dos usuários: <%=avaliacao %></th>
	</table><br>
	<% out.println("<img src='" + f.getPoster() + "' alt=Image not available/>"); %>

	<br><br>
	


<% if(!(u==null)){%>	
<table border="1">
<form action="avaliarFilme" method="get">
  <th><label for="avaliacao">Avaliar</label>
	<input id="nota" type="range" name="nota"  min="1" max="10" value="5" onchange="this.form.nota1.value=this.value"></input>
	<input type="number" name="nota1" min="1" max="10" value="5" oninput="this.form.nota.value=this.value" style="padding:5px 2px"/>
	<input type="hidden" name="idfilme" value="<%=f.getIdFilme()%>">
	<input type="hidden" name="usuario" value="<%=u.getIdUsuario() %>">
  	<input type="submit" style="background-color:#4CAF50; border:none;"></th>
  </form>
  </table>
  <br>
<%}%>
	
	<table border="1" cellspacing="0" cellpadding="0" style="float:left; margin-left:300px;">
	<tr><th>Sinopse</th></tr>
	<tr><td><p style="width: 500px; font-size:18px; word-wrap:break-word; white-space: normal;">
		<% out.println(f.getSinopse()); %>
	</p></td></tr>
	</table>
	
	<table border="1" cellspacing="0" cellpadding="0" style="float:left;margin-left:15px; font-size:15px;">
	<tr><th>Gênero</th></tr>
	<%for(int i=0; i<categorias.size(); i++) {%>
	

		<tr><td style="background-color:#F5F5F5"><a href="/SistemaFilmes/detalharCategoria?categoria=<%= categorias.get(i).getIdcategoria() %>"><%= categorias.get(i).getNome() %></a></td></tr>

	<%}%>
	</table>

	
	<table border="1" cellspacing="0" cellpadding="0" style="float:left; font-size:15px; margin-left:15px;">
	<tr><th>Duração</th></tr>
	<tr><td><% out.println(f.getDuracao() + " minutos"); %></td></tr>
	</table>

	<table border="1" cellspacing="0" cellpadding="0" style="float:left; font-size:15px; margin-left:15px">
	<tr><th>Avaliação da imprensa</th></tr>
	<tr><td><% out.println("Avaliação: " + f.getAvaliacao()); %></td></tr>
	</table>

	<br><br><br>
	
	<table border="1" cellspacing="0" cellpadding="0" style="float:left; margin-left:15px;  font-size:20px;">
	
	<tr><th>Atores</th></tr>
	<% for(int i=0; i<atores.size(); i++){%>
		<tr>
		<td><%out.println("<a href='/SistemaFilmes/detalharAtor?idator=" + atores.get(i).getIdAtor() + "&mensagem='>" + atores.get(i).getNome() + "</a>");%></td>
		</tr>
	<%}%>
	
	</table>
	
	
	<table border="1" cellspacing="0" cellpadding="0" style="float:left; margin-left:15px;  font-size:20px;">
	
	<tr><th>Diretores</th></tr>
	<% for(int i=0; i<diretores.size(); i++){%>
		<tr>
		<td><%out.println("<a href='/SistemaFilmes/detalharDiretor?iddiretor=" + diretores.get(i).getIdDiretor() + "&mensagem='>" + diretores.get(i).getNome() + "</a>");%></td>
		</tr>
	<%}%>
	
	</table>
	
	</div>

</body>
</html>