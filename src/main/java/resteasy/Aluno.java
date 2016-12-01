package resteasy;

public class Aluno {

  private String codigo;

  private String nome;

  private String senha;

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Aluno() {
  }

  public Aluno(String codigo, String nome, String senha) {
    this.codigo = codigo;
    this.nome = nome;
    this.senha = senha;
  }

}
