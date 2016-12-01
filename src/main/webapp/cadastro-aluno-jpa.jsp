<!DOCTYPE html>
<%@page import="jpa.Aluno"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Aluno</title>
</head>
<body>
  <h1>Cadastro de Aluno</h1>
  <form name="cadastroAlunoJpa" method="post">
  Código: <input type="text" name="codigo"><br>
  Nome: <input type="text" name="nome"><br>
  Senha: <input type="text" name="senha"><br>
  <br>
  <input type="submit" name="op" value="Salvar">
  <input type="submit" name="op" value="Excluir">
  <br>
  <br>
  <table border="1">
    <tr>
      <td>Código</td>
      <td>Nome</td>
      <td>#</td>
    </tr>
    <%
    List<Aluno> alunos = (List<Aluno>) request.getAttribute("alunos");
    for (Aluno u:alunos) {
    %>
      <tr>
        <td><%=u.getCodigo()%></td>
        <td><%=u.getNome()%></td>
        <td><a href="cadastroAlunoJpa?op=Excluir&codigo=<%=u.getCodigo()%>">Excluir</a></td>
      </tr>
    <%
    }
    %>
  </table>
</body>
</html>