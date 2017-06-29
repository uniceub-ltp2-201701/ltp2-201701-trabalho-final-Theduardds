<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Ator" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="model.Filme" %>
	<%@ page import="model.Usuario"%>
    <%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/respostaDetalharAtor.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalhar Ator</title>
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

<%  Ator a = (Ator) request.getAttribute("ator");
	ArrayList<Filme> f = (ArrayList<Filme>) request.getAttribute("filmes");
	
	HttpSession s = (HttpSession) request.getSession(true);
	Usuario u = (Usuario)s.getAttribute("admin");

if(!(u==null)){%>


		<table style="float:right;">
			<th style="padding:23px;">Logado em <%out.println(u.getNome());%></th>
			<th style="padding:23px;"><a href="/SistemaFilmes/logoff">Logoff</th>
		</table>
	
	<br>
<%}%>

	<%if(!(u==null) && u.getPrivilegio()==1){ %>
	
	<br><br><br>
	
	<div class="container" style="width: 250px; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);color:white; float: right; padding: 15px; border:1px solid #c62828;background-color: #c62828; height: auto; width: 150px; text-align: center; word-wrap: break-word; text-overflow: ellipsis;">
			<a href="/SistemaFilmes/paginaEditarAtor?idator=<%out.println(a.getIdAtor());%>" style="color:white;">Editar Ator</a>
		</div>
	
	<%}%>

	<div class="texto" align="center">
	<table border="1" style="float:left; margin-left:40%;">
	<tr><th>Nome</th></tr>
	<tr><td><%out.println(a.getNome());%></td></tr>
	</table>
	
	<% int idade = 2017 - (1900+a.getData_nasc().getYear()) ; %>
	
	<table border="1" style="font-size:18px; float:left; margin-left:15px;">
	<tr><th>Nascimento</th><th>Idade</th></tr>
	<tr><td><%out.println(a.getData_nasc()); %></td>
	<td><%out.println(idade);%> anos</td>
	</tr>	
	</table>
	<br><br><br><br>
	
	<% out.println("<img src='" + a.getUrl() + "' alt=Image not available/>"); %><br><br>
	

	<table border="1" style="float:left; margin-left:250px; font-size:18px;">
	<tr><th>Biografia</th></tr>
	<tr><td><p style="width: 600px; font-size:18px; word-wrap:break-word; white-space: normal;">
		<% out.println(a.getBiografia()); %>
	</p></td></tr>
	</table>
	
	
	<table border="1" style="float:left;margin-left:15px; font-size:18px">
	
	<tr><th>Capa</th><th>Filmes</td></tr>
	<% for(int i=0; i<f.size(); i++){
		
//>	%>

<tr>
<td><% out.println("<img src='" + f.get(i).getPoster() + "' alt=Image not available/>"); %></td>
<td width="200px"><% out.println("<a href='/SistemaFilmes/detalharFilme?idfilme=" + f.get(i).getIdFilme() + "&mensagem='>" + f.get(i).getTitulo() + "</a>"); %></td>
</tr>
<%}%>
</table>
	<br><br>
	</div>
</body>
</html>