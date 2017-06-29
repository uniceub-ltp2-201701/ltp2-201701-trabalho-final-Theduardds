<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Filme"%>
<%@ page import="model.Usuario"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/respostaListarFilmes.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Filmes</title>
</head>
<body>

	<nav role="navigation">
	<div id="menuToggle">

		<input type="checkbox" /> <span></span> <span></span> <span></span>


		<ul id="menu">
			<a href="/SistemaFilmes/listarFilmes"><li><i class="material-icons" style="font-size:25px; margin-left:10px;">movie</i>Filmes</li></a>
      		<a href="/SistemaFilmes/listarAtores"><li><i class="material-icons" style="font-size:25px; margin-left:10px;">person</i>Atores</li></a>
      		<a href="/SistemaFilmes/listarDiretores"><li><i class="material-icons" style="font-size:25px; margin-left:10px;">record_voice_over</i>Diretores</li></a>
      		<a href="/SistemaFilmes/listarCategorias"><li><i class="material-icons" style="font-size:25px; margin-left:10px;">book</i>Categorias</li></a>
      		<a href="/SistemaFilmes/mainPage"><li><i class="material-icons" style="font-size:25px; margin-left:10px;">home</i>Página Principal</li></a>
		</ul>
	</div>
	</nav>

	

	<% ArrayList<Filme> filmes = (ArrayList<Filme>) request.getAttribute("filmes");
	
	HttpSession se = (HttpSession) request.getSession(true);
	Usuario u = (Usuario)se.getAttribute("admin");
	
	if(!(u==null)){%>


	<table style="border-collapse: collapse;align: center;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);border:1px solid #4CAF50;background-color: #4CAF50;text-align: left;background-color: #4CAF50;color: white;;float:right;">
		<th style="padding:23px;">Logado em <%out.println(u.getNome());%></th>
		<th style="padding:23px;"><a href="/SistemaFilmes/logoff">Logoff</th>
	</table>

	<br>

	<%}%>
	<form action="listarFilmesPontuacao" method="get" style="margin-right:300px;">
	     <input type="submit" value="Procurar" style="float:right; background-color: #4CAF50;color: white;padding: 5px 10px;margin: 8px 0;border: none;cursor: pointer; height:30px;">
		 <input type="text" id="pontuacao" name="pontuacao" placeholder="Pontuação..." style="width:120px; float:right; padding: 10px 20px;margin: 8px 0;display: inline-block;border: 1px solid #ccc;box-sizing: border-box;height:30px;">
		 <select id="simbolo" name="simbolo" style="float:right; margin: 8px 0;display: inline-block;border: 1px solid #ccc;height:30px; box-sizing: border-box; padding:0px 0px;">
			<option value="&lt;">&lt;</option>
		 <option value="&gt;">&gt;</option>
	</select>
	</form>
	
	<%if(!(u==null) && u.getPrivilegio()==1){ %>
	
	<br><br><br>
	
	<div class="container" style="width: 250px; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);color:white; float: right; padding: 15px; border:1px solid #c62828;background-color: #c62828; height: auto; width: 150px; text-align: center; word-wrap: break-word; text-overflow: ellipsis;">
			<a href="/SistemaFilmes/paginaAdicionarFilme" style="color:white;">Adicionar Filme</a>
		</div>
	
	<%}%>
	
		<h1><i class="material-icons" style="font-size:23px;">movie</i>Filmes</h1>	


<%
 for(int i=0; i < filmes.size(); i++){

//> 
	
if(i>3){%>

	<% if(i==4 || i==8 || i==12) {%>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<div class="polaroid" style="margin-left: 250px;">
		
		<% out.println("<a href='/SistemaFilmes/detalharFilme?idfilme=" + filmes.get(i).getIdFilme() + "'><img src='" + filmes.get(i).getPoster() + "' alt='Image not available'/></a>"); %>
		<div class="container">
			<% out.println("<p><a href='/SistemaFilmes/detalharFilme?idfilme=" + filmes.get(i).getIdFilme() + "'>" + filmes.get(i).getTitulo() + "</a></p>"); %>

		</div>
	</div>


	<%}else{ %>

	<div class="polaroid" style="margin-left: 15px;">

		<% out.println("<a href='/SistemaFilmes/detalharFilme?idfilme=" + filmes.get(i).getIdFilme() + "'><img src='" + filmes.get(i).getPoster() + "' alt='Image not available'/></a>"); %>
		<div class="container">
			<% out.println("<p><a href='/SistemaFilmes/detalharFilme?idfilme=" + filmes.get(i).getIdFilme() + "'>" + filmes.get(i).getTitulo() + "</a></p>"); %>

		</div>

	</div>

	<%} %>
	<%}else{

if(i==0) {%>
	<div class="polaroid" style="margin-left: 250px;">
		<% out.println("<a href='/SistemaFilmes/detalharFilme?idfilme=" + filmes.get(i).getIdFilme() + "'><img src='" + filmes.get(i).getPoster() + "' alt='Image not available'/></a>"); %>
		<div class="container">
			<% out.println("<p><a href='/SistemaFilmes/detalharFilme?idfilme=" + filmes.get(i).getIdFilme() + "'>" + filmes.get(i).getTitulo() + "</a></p>"); %>

		</div>

	</div>

	<% }else{ %>
	<div class="polaroid" style="margin-left: 15px;">

		<% out.println("<a href='/SistemaFilmes/detalharFilme?idfilme=" + filmes.get(i).getIdFilme() + "'><img src='" + filmes.get(i).getPoster() + "' alt=Image not available/></a>"); %>
		<div class="container">
			<% out.println("<p><a href='/SistemaFilmes/detalharFilme?idfilme=" + filmes.get(i).getIdFilme() + "'>" + filmes.get(i).getTitulo() + "</a></p>"); %>

		</div>

	</div>



	<% }
}
} %>



</body>
</html>