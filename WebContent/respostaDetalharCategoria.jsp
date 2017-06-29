
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="model.Filme" %>
    <%@ page import="model.Usuario"%>
    <%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/respostaDetalharCategoria.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalhar Categoria</title>
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


<% ArrayList<Filme> filmes = (ArrayList<Filme>) request.getAttribute("filmes");
   String categoria = (String) request.getAttribute("categoria");
   
   HttpSession s = (HttpSession) request.getSession(true);
   Usuario u = (Usuario)s.getAttribute("admin");

if(!(u==null)){%>


		<table style="border-collapse: collapse;align: center;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);border:1px solid #4CAF50;background-color: #4CAF50;text-align: left;background-color: #4CAF50;color: white;;float:right;">
			<th style="padding:23px;">Logado em <%out.println(u.getNome());%></th>
			<th style="padding:23px;"><a href="/SistemaFilmes/logoff">Logoff</th>
		</table>
	
	<br>
<%}%>
   
   <h1><% out.println(categoria); %></h1>
   <br><br>
   
   
<%

 for(int i=0; i < filmes.size(); i++){

//> 

if(i>3){%>
	
	<% if(i==4 || i==8 || i==12) {%>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<div class="polaroid" style="margin-left: 250px;">
	<% out.println("<a href='/SistemaFilmes/detalharFilme?idfilme=" + filmes.get(i).getIdFilme() + "&mensagem='><img src=" + (request.getContextPath()) + "/images/" + filmes.get(i).getIdFilme() + ".jpg alt='Image not available'/></a>"); %>
	<div class="container">
	<% out.println("<p><a href='/SistemaFilmes/detalharFilme?idfilme=" + filmes.get(i).getIdFilme() + "&mensagem='>" + filmes.get(i).getTitulo() + "</a></p>"); %>
	
	</div>
 	</div>


 	<%}else{ %>
 	
 	<div class="polaroid" style="margin-left: 15px;">

	<% out.println("<a href='/SistemaFilmes/detalharFilme?idfilme=" + filmes.get(i).getIdFilme() + "&mensagem='><img src=" + (request.getContextPath()) + "/images/" + filmes.get(i).getIdFilme() + ".jpg alt='Image not available'/></a>"); %>
	<div class="container">
	<% out.println("<p><a href='/SistemaFilmes/detalharFilme?idfilme=" + filmes.get(i).getIdFilme() + "&mensagem='>" + filmes.get(i).getTitulo() + "</a></p>"); %>

	</div>
 
	</div>
 	
	<%} %>
<%}else{

if(i==0) {%>
<div class="polaroid" style="margin-left: 250px;">
<% out.println("<a href='/SistemaFilmes/detalharFilme?idfilme=" + filmes.get(i).getIdFilme() + "&mensagem='><img src=" + (request.getContextPath()) + "/images/" + filmes.get(i).getIdFilme() + ".jpg alt='Image not available'/></a>"); %>
<div class="container">
<% out.println("<p><a href='/SistemaFilmes/detalharFilme?idfilme=" + filmes.get(i).getIdFilme() + "&mensagem='>" + filmes.get(i).getTitulo() + "</a></p>"); %>

</div>
 
</div>

<% }else{ %>
<div class="polaroid" style="margin-left: 15px;">

<% out.println("<a href='/SistemaFilmes/detalharFilme?idfilme=" + filmes.get(i).getIdFilme() + "&mensagem='><img src=" + (request.getContextPath()) + "/images/" + filmes.get(i).getIdFilme() + ".jpg alt=Image not available/></a>"); %>
<div class="container">
<% out.println("<p><a href='/SistemaFilmes/detalharFilme?idfilme=" + filmes.get(i).getIdFilme() + "&mensagem='>" + filmes.get(i).getTitulo() + "</a></p>"); %>

</div>
 
</div>



<% }
}
} %>



</body>
</html>