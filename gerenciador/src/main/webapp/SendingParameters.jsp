<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="SendingParameters.jsp">
	  <label for="meuParametro">Meu Parâmetro:</label>
	  <input type="text" name="meuParametro" id="meuParametro">
	  <button type="submit">Enviar</button>
	</form>
	<%!
	public class SendingParameters {
		public void meuMetodo(String meuParametro) {
		    System.out.println("O valor do meu parâmetro é: " + meuParametro);
		    // faça algo com o parâmetro recebido
		  }
	}
	%>
	<%
	  	String meuParametro = request.getParameter("meuParametro");
	 	SendingParameters minhaClasse = new SendingParameters();
	  	minhaClasse.meuMetodo(meuParametro);
	%>
</body>
</html>