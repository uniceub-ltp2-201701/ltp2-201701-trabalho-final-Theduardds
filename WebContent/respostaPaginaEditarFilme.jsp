<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Usuario"%>
    <%@ page import="javax.servlet.http.HttpSession" %>
    <%@ page import="model.Filme" %>
    <%@ page import="model.Categoria" %>
    <%@ page import="model.Ator" %>
    <%@ page import="model.Diretor" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/respostaPaginaEditarFilme.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar filme</title>
</head>
<body>

<nav role="navigation">
  <div id="menuToggle">

    <input type="checkbox" name="menu"/>
 
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

<% HttpSession s = (HttpSession) request.getSession(true);
   Usuario u = (Usuario)s.getAttribute("admin"); 
   
   Filme f = (Filme) request.getAttribute("filme");
   ArrayList<Categoria> categorias = (ArrayList<Categoria>) request.getAttribute("categorias");
   
   if(!(u==null) && u.getPrivilegio()==1){%>


	<table style="float:right;">
		<th style="padding:23px;">Logado em <%out.println(u.getNome());%></th>
		<th style="padding:23px;"><a href="/SistemaFilmes/logoff">Logoff</th>
	</table>

<br><br><br><br>
	
	<div class="container" style="width: 250px; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);color:white; float: right; padding: 15px; border:1px solid #c62828;background-color: #c62828; height: auto; width: 150px; text-align: center; word-wrap: break-word; text-overflow: ellipsis;">
			<a href="/SistemaFilmes/excluirFilme?idfilme=<%= f.getIdFilme() %>" style="color:white;">Excluir Filme</a>
		</div>

<br>

<h1 style="text-align:center;">Editar filme</h1>
   
<div id="local">
  <form action="editarFilme?idfilme=<%out.println(f.getIdFilme());%>" style="height:auto" method="post">
    <label for="titulo">Título</label>
    <input type="text" id="titulo" name="titulo" placeholder="<%= f.getTitulo() %>">

    <label for="sinopse">Sinopse</label>   <textarea name="sinopse" cols="40" rows="5" placeholder="<%= f.getSinopse() %>" style="width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box; resize: vertical;"></textarea>
    
    <label for="classificacao">Classificação</label><br>
    <input type="text" id="classificacao" name="classificacao" placeholder="<%= f.getClassificacao() %>"style="width:180px"><br>
    
    <label for="avaliacao">Avaliação</label><br>
    <input type="text" id="avaliacao" name="avaliacao" placeholder="<%= f.getAvaliacao() %>" style="width:180px"><br>
    
    <label for="duracao">Duração</label><br>
    <input type="text" id="duracao" name="duracao" placeholder="<%= f.getDuracao() %>" style="width:180px"><br>
    
    <label for="lancamento">Data de lançamento (AAAA-MM-DD)</label><br>
    <input type="text" id="lancamento" name="lancamento" placeholder="<%= f.getData_lancamento() %>" style="width:180px"><br>
    
    <label for="url">Url do poster</label><br>
    <input type="text" id="url" name="url" placeholder="<%= f.getPoster() %>"><br>

    <input type="submit" value="Submit">
  </form>
  
  <% 
  String c = ""; 
  	if(!(categorias.isEmpty())){
  		
  		for(int i=0; i<categorias.size(); i++) {
  			c = categorias.get(i).getNome() + ", " + c;
  		}%>
  		
  		<form action="adicionarCategoria?idfilme=<%=f.getIdFilme() %>" style="height:auto" method="post">
    	<label for="genero">Gênero (Um por vez)</label>
    	<input type="text" id="genero" name="genero" placeholder="<%=c%>">
    	<input style="width:50px; height:30px;"type="submit" id="Submit" name="Submit">
    </form>
  		
  	<%}else{%>
  
  <form action="adicionarCategoria?idfilme=<%=f.getIdFilme() %>" style="height:auto" method="post">
    	<label for="genero">Gênero (Um por vez)</label>
    	<input type="text" id="genero" name="genero" placeholder="Gênero...">
    	<input style="width:100px; height:60px;" type="submit" id="Submit" name="Submit">
    </form>
    <%}%>
</div>
  	<% String m = (String) request.getAttribute("mensagem");
	if(m==null)
		m = "";
		%>
<h1 style="margin-left:850px"><%out.println(m);%></h1>

<%}else{%>
	<h1 style="margin-left:450px; margin-top:200px; font-size:40px">Página somente para administradores!</h1>
<%}%>
</body>
</html>