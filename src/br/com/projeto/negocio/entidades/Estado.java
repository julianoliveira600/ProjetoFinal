package br.com.projeto.negocio.entidades;

import br.com.projeto.persistencia.validacao.Campo;
import br.com.projeto.persistencia.validacao.Tabela;

@Tabela(nome="ESTADO")
public class Estado extends Entidade {
    
    @Campo(nome="idEstado", isId = true, tamanho = 10, requerido = true)
    private int idEstado;
    @Campo(nome="Nome", tamanho = 2, requerido = true)
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
