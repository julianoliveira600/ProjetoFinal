package br.com.projeto.negocio.entidades;

import br.com.projeto.persistencia.validacao.Campo;
import br.com.projeto.persistencia.validacao.Chave;
import br.com.projeto.persistencia.validacao.Tabela;

@Tabela(nome="CIDADE")
public class Cidade extends Entidade {
    
    @Campo(nome="idCidade", isId = true, tamanho = 10, requerido = true)
    private int idCidade;
    @Campo(nome="Nome", tamanho = 45, requerido = true)
    private String Nome;
    @Campo(nome="fk_idEstado", tamanho = 10, requerido = true)
    private int fk_idEstado;
    @Chave(campo="fk_idEstado", fk=true , requerido= true)
    private Estado estado;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    

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
