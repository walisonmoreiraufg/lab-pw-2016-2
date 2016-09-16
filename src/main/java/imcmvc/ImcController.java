package imcmvc;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/imc")
public class ImcController extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    //Preparação dos parâmetros.
    
    String pesoStr = req.getParameter("peso");
    float peso = pesoStr == null || pesoStr.isEmpty() ? 0 : Float.parseFloat(pesoStr);

    String alturaStr = req.getParameter("altura");
    float altura = alturaStr == null || alturaStr.isEmpty()? 0 : Float.parseFloat(alturaStr);

    String sexo = req.getParameter("sexo");

    //Chamada ao Model.
    String resultado = ImcModel.resultadoImc(peso, altura, sexo);

    //Passagem de atributos para o JSP.
    req.setAttribute("resultadoImc", resultado);

    //Chamando o JSP.
    String nextJsp = "/imcView.jsp";
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJsp);
    dispatcher.forward(req, resp);
  }
}
