package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CadastroUsuarioJdbcModel {

  private static Connection obterConexao() throws SQLException {
    //Estabelecer uma conexão com o banco de dados.
    String url = "jdbc:mysql://localhost:3306/pw";
    String user = "pwuser";
    String password = "12345678";
    Connection conn = DriverManager
        .getConnection(url, user, password);
    return conn;
  }

  public static void salvar(Usuario usuario) throws SQLException {
    Connection conn = obterConexao();
    if (usuario.hasCodigo()) {
      alterar(conn, usuario);
    } else {
      inserir(conn, usuario);
    }
  }


  public static void excluir(Usuario usuario) throws SQLException {
    Connection conn = obterConexao();
    
    //Obter sentença SQL.
    Statement stmt = conn.createStatement();
    String sql = "delete from usuario where codigo = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, usuario.getCodigo());
    pstmt.execute();
  }

  private static void inserir(Connection conn, Usuario usuario) throws SQLException {
    //Obter sentença SQL.
    String sql = "insert into usuario (nome, senha) values (?, ?)";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, usuario.getNome());
    pstmt.setString(2, usuario.getSenha());
    pstmt.execute();
  }

  private static void alterar(Connection conn, Usuario usuario) throws SQLException {
    //Obter sentença SQL.
    Statement stmt = conn.createStatement();
    String sql = "update usuario set nome = ?, senha = ? where codigo = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, usuario.getNome());
    pstmt.setString(2, usuario.getSenha());
    pstmt.setString(3, usuario.getCodigo());
    pstmt.execute();
  }

}
