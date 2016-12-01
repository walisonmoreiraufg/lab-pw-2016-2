package jpa;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/cadastroAlunoJpa")
public class CadastroAlunoJpaController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    String op = req.getParameter("op");
    op = (op == null ? "Iniciar" : op);
    
    Aluno aluno = new Aluno();
    aluno.setCodigo(req.getParameter("codigo"));
    aluno.setNome(req.getParameter("nome"));
    aluno.setSenha(req.getParameter("senha"));

    List<Aluno> alunos = null;
    try {
      if (op.equals("Salvar")) {
        CadastroAlunoJpaModel.salvar(aluno);
      } else if (op.equals("Excluir")) {
        CadastroAlunoJpaModel.excluir(aluno);
      }

      alunos = CadastroAlunoJpaModel.listar();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    
    req.setAttribute("alunos", alunos);

    //Chamando o JSP.
    String nextJsp = "/cadastro-aluno-jpa.jsp";
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJsp);
    dispatcher.forward(req, resp);

  }
}
