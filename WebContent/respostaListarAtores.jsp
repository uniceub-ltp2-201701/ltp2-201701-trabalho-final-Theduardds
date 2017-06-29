<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Ator"%>
<%@ page import="java.sql.Date"%>
<%@ page import="model.Usuario"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/respostaListarAtores.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atores</title>
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

	



<% ArrayList<Ator> atores = (ArrayList<Ator>) request.getAttribute("atores");

HttpSession s = (HttpSession) request.getSession(true);
Usuario u = (Usuario)s.getAttribute("admin");


if(!(u==null)){%>


<table style="border-collapse: collapse;align: center;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);border:1px solid #4CAF50;background-color: #4CAF50;text-align: left;background-color: #4CAF50;color: white;;float:right;">
	<th style="padding:23px;">Logado em <%out.println(u.getNome());%></th>
	<th style="padding:23px;"><a href="/SistemaFilmes/logoff">Logoff</th>
</table>

<br>

<%}%>

<%if(!(u==null) && u.getPrivilegio()==1){ %>
	
	<br><br><br>
	
	<div class="container" style="width: 250px; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);color:white; float: right; padding: 15px; border:1px solid #c62828;background-color: #c62828; height: auto; width: 150px; text-align: center; word-wrap: break-word; text-overflow: ellipsis;">
			<a href="/SistemaFilmes/paginaAdicionarAtor" style="color:white;">Adicionar Ator</a>
		</div>
	<div style="margin-top:-60px;">
	<%}%>

<h1><i class="material-icons" style="font-size:23px;">person</i>Atores</h1>

<%
for(int i=0; i<atores.size(); i++){

// > 


if(i>3){%>

				<% if(i==4 || i==8 || i==12 || i==16 || i==20) {%>

				<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
				<div class="polaroid" style="margin-left: 250px;">
		
					<% out.println("<a href='/SistemaFilmes/detalharAtor?idator=" + atores.get(i).getIdAtor() + "'><img src='" + atores.get(i).getUrl() + "' alt='Image not available'/></a>"); %>
				<div class="container">
					<% out.println("<p><a href='/SistemaFilmes/detalharAtor?idator=" + atores.get(i).getIdAtor() + "'>" + atores.get(i).getNome() + "</a></p>"); %>

				</div>
				</div>

				<%}else{ %>
				<div class="polaroid" style="margin-left: 15px;">
		
					<% out.println("<a href='/SistemaFilmes/detalharAtor?idator=" + atores.get(i).getIdAtor() + "'><img src='" + atores.get(i).getUrl() + "' alt='Image not available'/></a>"); %>
				<div class="container">
					<% out.println("<p><a href='/SistemaFilmes/detalharAtor?idator=" + atores.get(i).getIdAtor() + "'>" + atores.get(i).getNome() + "</a></p>"); %>

				</div>
				</div>

				<%} %>
				<%}else{

if(i==0) {%>
				<div class="polaroid" style="margin-left: 250px;">
		
					<% out.println("<a href='/SistemaFilmes/detalharAtor?idator=" + atores.get(i).getIdAtor() + "'><img src='" + atores.get(i).getUrl() + "' alt='Image not available'/></a>"); %>
				<div class="container">
					<% out.println("<p><a href='/SistemaFilmes/detalharAtor?idator=" + atores.get(i).getIdAtor() + "'>" + atores.get(i).getNome() + "</a></p>"); %>

				</div>
				</div>
				<% }else{ %>
				<div class="polaroid" style="margin-left: 15px;">
		
					<% out.println("<a href='/SistemaFilmes/detalharAtor?idator=" + atores.get(i).getIdAtor() + "'><img src='" + atores.get(i).getUrl() + "' alt='Image not available'/></a>"); %>
				<div class="container">
					<% out.println("<p><a href='/SistemaFilmes/detalharAtor?idator=" + atores.get(i).getIdAtor() + "'>" + atores.get(i).getNome() + "</a></p>"); %>

				</div>
				</div>
				<% }
}
} %>
</div>
<%if(atores.isEmpty()){%>

	<h1 style="margin-left:450px; margin-top:200px; font-size:40px">Verifique se o banco de dados está aberto ou se senha do mysql está correta</h1>

<%}%>
</body>
</html>