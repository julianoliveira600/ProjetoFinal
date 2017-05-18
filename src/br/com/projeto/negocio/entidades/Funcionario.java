package br.com.projeto.negocio.entidades;

import java.sql.Date;

public class Funcionario {

    private int idFuncionario;
    private String Nome;
    private String CPF;
    private String Email;
    private String Funcao;
    private Date DataNascimento;
    private String RG;
    private int Status;
    private Date DataAdmissao;
    private String Login;
    private String Senha;
    private String Telefone;
    private String Celular;

    public Funcionario() {
    }

    public Funcionario(int idFuncionario, String Nome, String CPF, String Email, String Funcao, Date DataNascimento, String RG, int Status, Date DataAdmissao, String Login, String Senha, String Telefone, String Celular) {
        this.idFuncionario = idFuncionario;
        this.Nome = Nome;
        this.CPF = CPF;
        this.Email = Email;
        this.Funcao = Funcao;
        this.DataNascimento = DataNascimento;
        this.RG = RG;
        this.Status = Status;
        this.DataAdmissao = DataAdmissao;
        this.Login = Login;
        this.Senha = Senha;
        this.Telefone = Telefone;
        this.Celular = Celular;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFuncao() {
        return Funcao;
    }

    public void setFuncao(String Funcao) {
        this.Funcao = Funcao;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public Date getDataAdmissao() {
        return DataAdmissao;
    }

    public void setDataAdmissao(Date DataAdmissao) {
        this.DataAdmissao = DataAdmissao;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
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

   
}
