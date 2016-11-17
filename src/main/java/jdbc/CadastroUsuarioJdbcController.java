package jdbc;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/cadastroUsuarioJdbc")
public class CadastroUsuarioJdbcController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    String op = req.getParameter("op");
    op = (op == null ? "Iniciar" : op);
    
    Usuario usuario = new Usuario();
    usuario.setCodigo(req.getParameter("codigo"));
    usuario.setNome(req.getParameter("nome"));
    usuario.setSenha(req.getParameter("senha"));

    List<Usuario> usuarios = null;
    try {
      if (op.equals("Salvar")) {
        CadastroUsuarioJdbcModel.salvar(usuario);
      } else if (op.equals("Excluir")) {
        CadastroUsuarioJdbcModel.excluir(usuario);
      }

      usuarios = CadastroUsuarioJdbcModel.listar();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    
    req.setAttribute("usuarios", usuarios);

    //Chamando o JSP.
    String nextJsp = "/cadastro-usuario-jdbc.jsp";
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJsp);
    dispatcher.forward(req, resp);

  }
}
