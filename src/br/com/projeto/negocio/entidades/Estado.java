package br.com.projeto.negocio.entidades;

public class Estado extends Entidade {

    private int idEstado;
    private String Nome;

    public Estado() {
    }

    public Estado(int idEstado, String Nome) {
        this.idEstado = idEstado;
        this.Nome = Nome;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

}
