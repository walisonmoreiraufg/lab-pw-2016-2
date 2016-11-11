package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBasico {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
//    //Carregar o driver.
//    Class.forName("com.mysql.jdbc.Driver");

    //Estabelecer uma conexão com o banco de dados.
    String url = "jdbc:mysql://localhost:3306/pw";
    String user = "pwuser";
    String password = "12345678";
    Connection conn = DriverManager.getConnection(url, user, password);

    //Obter sentença SQL.
    Statement stmt = conn.createStatement();
    //stmt.execute("insert into aluno (nome, matricula) values (\"João\", \"654321\")");

    //Executar SELECT.
    ResultSet rs = stmt.executeQuery("select id, matricula, nome from aluno");
    while (rs.next()) {
      System.out.println("id = " + rs.getString("id"));
      System.out.println("matricula = " + rs.getString("matricula"));
      System.out.println("nome = " + rs.getString("nome"));
    }
  }
}
