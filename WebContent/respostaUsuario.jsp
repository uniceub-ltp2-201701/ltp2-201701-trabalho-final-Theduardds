<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Usuario"%>
    <%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/respostaUsuario.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login de usuário</title>
</head>
<body style="background-image:url(<%=(request.getContextPath())%>/images/fundo.png)">

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

<%	HttpSession s = (HttpSession) request.getSession(true);
	Usuario u = (Usuario)s.getAttribute("admin");

if(!(u==null)){%>
	
	<table style="border-collapse: collapse;align: center;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);border:1px solid #4CAF50;text-align: left;background-color: #4CAF50;color: white;;float:right;">
	<th style="padding:23px;"><a href="/SistemaFilmes/logoff">Logoff</th>
	<th style="padding:23px;">Logado em <%out.println(u.getNome());%></th>
	</table>
	
	<br><br><br>
	<h2 style="text-align:center; font-size:30px;">Bem-vindo ao SistemaFilmes</h2><br>

	
<%}else{%>
 
 	<h2 style="margin-top:80px; font-size: 35px; text-align:center;">Usuário/Senha incorretos!</h2>
 	<div style="text-align:center;">
 	<a href="/SistemaFilmes/mainPage" style="background-color: #4CAF50; /* Green */ border: none; color: white; padding: 15px 32px; text-align: center; text-decoration: none; display: inline-block;
    font-size: 16px; align:center;">Voltar</a>
    </div>
<%}%>
</body>
</html>