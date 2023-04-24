<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="br.com.estacio.gerenciador.ConexaoBanco.AccountManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="SacarContaBanco.jsp">
	  <label for=idConta>Id da Conta:</label>
	  <input type="number" name="idConta" id="idConta">
	  <label for=valorSaque>Valor a sacar:</label>
	  <input type="number" name="valorSaque" id="valorSaque">
	  <button type="submit">Enviar</button>
	</form>
	<%
		int idConta = request.getParameter("idConta");
		double valorSaque = request.getParameter("valorSaque");
		AccountManager.sacar(idConta, valorSaque);	
	%>
</body>
</html>