<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Usuario"%>
<%@ page import="model.Categoria"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/respostaListarCategorias.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categorias</title>
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

	<% ArrayList<Categoria> s = (ArrayList<Categoria>) request.getAttribute("categorias");
	
	HttpSession se = (HttpSession) request.getSession(true);
	Usuario u = (Usuario)se.getAttribute("admin");


	if(!(u==null)){%>


	<table style="border-collapse: collapse;align: center;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);border:1px solid #4CAF50;background-color: #4CAF50;text-align: left;background-color: #4CAF50;color: white;;float:right;">
		<th style="padding:23px;">Logado em <%out.println(u.getNome());%></th>
		<th style="padding:23px;"><a href="/SistemaFilmes/logoff">Logoff</th>
	</table>

	<br>

	<%}%>
		
	<h1><i class="material-icons" style="font-size:23px;">book</i>Categorias</h1>
	<%
for(int i=0; i<s.size(); i++){
	
//>	

if(i>5){%>

	<% if(i==6 || i==12 || i==20 || i==26 || i==32) {%>
	<br><br><br><br>
	<a href="/SistemaFilmes/detalharCategoria?categoria=<%out.println(s.get(i).getIdcategoria()); %>" style="color:white;">
		<div class="polaroid" style="margin-left: 250px;">
			<div class="container">
				<% out.println(s.get(i).getNome()); %>

			</div>
		</div>
	</a>

	<%}else{ %>
	<a href="/SistemaFilmes/detalharCategoria?categoria=<% out.println(s.get(i).getIdcategoria()); %>" style="color:white;">
		<div class="polaroid" style="margin-left: 15px;">

			<div class="container">
				<% out.println(s.get(i).getNome()); %>

			</div>

		</div>
	</a>
	<%} %>
	<%}else{

if(i==0) {%>
	<a href="/SistemaFilmes/detalharCategoria?categoria=<% out.println(s.get(i).getIdcategoria()); %>" style="color:white;">
		<div class="polaroid" style="margin-left: 250px;">
			<div class="container">
				<% out.println(s.get(i).getNome()); %>

			</div>

		</div>
	</a>

	<% }else{ %>
	<a href="/SistemaFilmes/detalharCategoria?categoria=<% out.println(s.get(i).getIdcategoria()); %>" style="color:white;">
		<div class="polaroid" style="margin-left: 15px;">
			<div class="container">
				<% out.println(s.get(i).getNome()); %>

			</div>

		</div>
	</a>



	<% }
}

} %>

<%if(s.isEmpty()){%>

	<h1 style="margin-left:450px; margin-top:200px; font-size:40px">Verifique se o banco de dados está aberto ou se senha do mysql está correta</h1>

<%}%>

</body>
</html>