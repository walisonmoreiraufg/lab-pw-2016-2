package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    String sql = "delete from usuario where codigo = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, usuario.getCodigo());
    pstmt.execute();
  }

  public static List<Usuario> listar() throws SQLException {
    Connection conn = obterConexao();
    
    Statement stmt = conn.createStatement();
    String sql = "select codigo, nome from usuario order by codigo";
    ResultSet rs = stmt.executeQuery(sql);

    List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
    while (rs.next()) {
      // Cria um usuário para o registro.
      Usuario usuario = new Usuario();
      usuario.setCodigo(rs.getString("codigo"));
      usuario.setNome(rs.getString("nome"));
      // Adiciona o usuário na lista de usuários.
      listaDeUsuarios.add(usuario);
    }
    return listaDeUsuarios;
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
    String sql = "update usuario set nome = ?, senha = ? where codigo = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, usuario.getNome());
    pstmt.setString(2, usuario.getSenha());
    pstmt.setString(3, usuario.getCodigo());
    pstmt.execute();
  }

}
