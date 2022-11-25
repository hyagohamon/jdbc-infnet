package br.edu.infnet.pedido.model.entidade;

public class Usuario {
    private Long cod;
    private String nome;
    private String usuario;
    private String senha;
    public Usuario() {

    }


    public Usuario(Long cod, String nome, String usuario, String senha) {
        this.cod = cod;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario( String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
