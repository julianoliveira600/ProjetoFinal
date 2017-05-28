package br.com.projeto.negocio.entidades;

import br.com.projeto.persistencia.validacao.Campo;
import br.com.projeto.persistencia.validacao.Chave;
import br.com.projeto.persistencia.validacao.Tabela;
import java.sql.Date;

@Tabela(nome="CLIENTE")
public class Cliente extends Entidade {

    @Campo(nome="id", isId = true, tamanho = 10, requerido = true)
    private int id;
    @Campo(nome="nome", tamanho = 50, requerido = true)
    private String nome;
    @Campo(nome="cpf", tamanho = 11, requerido = true)
    private String cpf;
    @Campo(nome="rg", tamanho = 25, requerido = true)
    private String rg;
    @Campo(nome="datanascimento", tamanho = 50, requerido = false)
    private Date dataNascimento;
    @Campo(nome="email", tamanho = 50, requerido = true, formato = "[a-z0-9._-]+@[a-z.]+")
    private String email;
    @Campo(nome="telefone", tamanho = 10, requerido = true, formato = "^[0-9]{8,10}$")
    private String Telefone;
    @Campo(nome="celular", tamanho = 12, requerido = true)
    private String Celular;
    @Chave(campo="Cliente_id", requerido = true)
    private Endereco endereco;
    @Chave(campo="Cliente_id", requerido = false)
    private Biometria biometria;
    @Chave(campo="Cliente_id", requerido = false)
    private Alteracoes alteracoes;
    private Avaliacao avaliacao;

    public Cliente() {
    }

    public Cliente(int id, String nome, String cpf, String rg, Date dataNascimento, String email, String Telefone, String Celular) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.Telefone = Telefone;
        this.Celular = Celular;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Biometria getBiometria() {
        return biometria;
    }

    public void setBiometria(Biometria biometria) {
        this.biometria = biometria;
    }

    public Alteracoes getAlteracoes() {
        return alteracoes;
    }

    public void setAlteracoes(Alteracoes alteracoes) {
        this.alteracoes = alteracoes;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

}
