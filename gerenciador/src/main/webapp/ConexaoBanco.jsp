<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="br.com.estacio.gerenciador.ConexaoBanco.ConexaoMySQL"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Conexão BD</title>
</head>
<body>
	<%
		ConexaoMySQL.getConexaoMySQL();
		out.println(ConexaoMySQL.statusConection());
	%>
</body>
</html>