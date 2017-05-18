package br.com.projeto.negocio.entidades;

import java.sql.Date;



public class Cliente {

    private int id;																				 
    private String nome;																		
    private String cpf;																			
    private String rg;																				
    private Date dataNascimento;																				
    private String email;
    private String Telefone;
    private String Celular;

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

   
    
    
}
