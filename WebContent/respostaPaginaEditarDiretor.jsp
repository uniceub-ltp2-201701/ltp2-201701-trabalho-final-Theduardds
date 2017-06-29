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
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/respostaPaginaEditarFilme.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar diretor</title>
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
   
   Diretor a = (Diretor) request.getAttribute("diretor");
   
   if(!(u==null) && u.getPrivilegio()==1){%>


	<table style="float:right;">
		<th style="padding:23px;">Logado em <%out.println(u.getNome());%></th>
		<th style="padding:23px;"><a href="/SistemaFilmes/logoff">Logoff</th>
	</table>

<br><br><br><br>
	
	<div class="container" style="width: 250px; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);color:white; float: right; padding: 15px; border:1px solid #c62828;background-color: #c62828; height: auto; width: 150px; text-align: center; word-wrap: break-word; text-overflow: ellipsis;">
			<a href="/SistemaFilmes/excluirDiretor?iddiretor=<%= a.getIdDiretor() %>" style="color:white;">Excluir Diretor</a>
		</div>

<br>

<h1 style="text-align:center;">Editar diretor</h1>
   
<div id="local">
  <form action="editarDiretor?iddiretor=<%= a.getIdDiretor() %>" style="height:auto" method="post">
    <label for="nome">Nome</label>
    <input type="text" id=""nome" name="nome" placeholder="<%= a.getNome() %>">

    <label for="biografia">Biografia</label>   <textarea name="biografia" cols="40" rows="5" placeholder="<%= a.getBiografia() %>" style="width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box; resize: vertical;"></textarea>
    
    <label for="nascimento">Data de nascimento (AAAA-MM-DD)</label><br>
    <input type="text" id="nascimento" name="nascimento" placeholder="<%= a.getData_nasc() %>" style="width:250px"><br>
    
    <label for="url">Url da imagem do ator</label><br>
    <input type="text" id="url" name="url" placeholder="<%= a.getUrl() %>"><br>
    
    <label for="idfilme">Filme do ator</label><br>
    <select id="idfilme" name="idfilme">
    
    <% 
    	ArrayList<Filme> filmes = (ArrayList<Filme>) request.getAttribute("filmes");
    
  	for(int i=0; i<filmes.size(); i++){ %>

  		<option value="<%out.print(filmes.get(i).getIdFilme());%>"><%out.print(filmes.get(i).getTitulo());%></option>
  		
	<%}%>

	</select>

    <input type="submit" value="Submit">
  </form>
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