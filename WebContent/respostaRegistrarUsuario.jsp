<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/respostaRegistrarUsuario.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página principal</title>
</head>
<body style="background-image:url(<%=(request.getContextPath())%>/images/fundo.png)">

<%  
	boolean resultado = (boolean) request.getAttribute("resultado");
%>

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

<div class="login" style="margin-left:600px; margin-top:60px;width:300px; height:180px; float:left; position:fixed;">
  
  <h2 class="login-header" style="width:260px;">Log in</h2>

  <form action="usuario" class="login-container" method="post">
  	<br>
  	<p><input type="text" placeholder="Usuario" name="loginUsuario"></p>
    <p><input type="password" placeholder="Senha" name="loginSenha"></p>
    <p><input type="submit" value="Login"></p>
  </form>
</div>

<div class="register" style="margin-left:950px; margin-top:60px;width:300px; height:180px; float:left; position:fixed;">
  
  <h2 class="register-header" style="width:260px;">Register</h2>

  <form action="registrarUsuario" class="register-container" method="post">
  	<br>
  	<p><input type="text" placeholder="Usuario" name="registerUsuario"></p>
    <p><input type="password" placeholder="Senha" name="registerSenha"></p>
    <p><input type="submit" value="Register"></p>
  </form>
</div>

<% if(resultado){ %>
	<h2 style="text-align:center; margin-top:40px;">Usuário adicionado com sucesso!</h2>
<%}else{%>
	<h2 style="text-align:center; margin-top:40px;">Não foi possível adicionar o usuário</h2>
<%}%>
</body>
</html>