<!DOCTYPE html>
<%@page import="jdbc.Usuario"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuário</title>
</head>
<body>
  <h1>Cadastro de Usuário</h1>
  <form name="cadastroUsuarioJdbc" method="post">
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
    List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
    for (Usuario u:usuarios) {
    %>
      <tr>
        <td><%=u.getCodigo()%></td>
        <td><%=u.getNome()%></td>
        <td><a href="cadastroUsuarioJdbc?op=Excluir&codigo=<%=u.getCodigo()%>">Excluir</a></td>
      </tr>
    <%
    }
    %>
  </table>
</body>
</html>