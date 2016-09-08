<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cálculo Menor/Maior</title>

</head>
<body>
  <h1>Cálculo Menor/Maior</h1>
  <form>
  Idade: <input type="text" name="idade" value="${param.idade}"><br>
  <button>Calcular</button>
  </form>
<%
String idadeStr = request.getParameter("idade");
//Se o campo "idade" não foi informado, atribui "0", senão fica como está.
idadeStr = (idadeStr == null ? "0" : idadeStr);

int idade = 0;
try {
  idade = Integer.parseInt(idadeStr);
} catch(Exception e) {
}

if (idade == 0) {
  %><b>Informe uma idade válida.</b><%
} else if (idade < 18) {
  %><b>Menor de idade.</b><%
} else {
  %><b>Maior de idade.</b><%
}
%>
</body>
</html>