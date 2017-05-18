package br.com.projeto.negocio.entidades;

public class Cidade {

    private int idCidade;
    private String Nome;
    private int fk_idEstado;

    public Cidade() {
    }

    public Cidade(int idCidade, String Nome, int fk_idEstado) {
        this.idCidade = idCidade;
        this.Nome = Nome;
        this.fk_idEstado = fk_idEstado;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getFk_idEstado() {
        return fk_idEstado;
    }

    public void setFk_idEstado(int fk_idEstado) {
        this.fk_idEstado = fk_idEstado;
    }

}
