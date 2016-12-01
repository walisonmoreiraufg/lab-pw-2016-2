package jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aluno {
  @Id
  private String codigo;
  public String getCodigo() {
    return codigo;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  private String nome;
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  private String senha;
  public String getSenha() {
    return senha;
  }
  public void setSenha(String senha) {
    this.senha = senha;
  }
  public boolean hasCodigo() {
    return codigo != null && !codigo.trim().equals("");
  }
}
