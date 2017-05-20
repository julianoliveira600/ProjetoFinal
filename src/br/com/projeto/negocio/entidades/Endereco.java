package br.com.projeto.negocio.entidades;

public class Endereco {

    public int idEndereco;
    public int fk_idCidade;
    private String Rua;
    private String Bairro;
    private String CEP;
    private String Complemento;
    private int Numero;
    private int Cliente_id;
    public int fk_idFuncionario;  // ver porque teve que deixar publica

    public Endereco() {
    }

    public Endereco(int idEndereco, int fk_idCidade, String Rua, String Bairro, String CEP, String Complemento, int Numero, int Cliente_id, int fk_idFuncionario) {
        this.idEndereco = idEndereco;
        this.fk_idCidade = fk_idCidade;
        this.Rua = Rua;
        this.Bairro = Bairro;
        this.CEP = CEP;
        this.Complemento = Complemento;
        this.Numero = Numero;
        this.Cliente_id = Cliente_id;
        this.fk_idFuncionario = fk_idFuncionario;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public int getFk_idCidade() {
        return fk_idCidade;
    }

    public void setFk_idCidade(int fk_idCidade) {
        this.fk_idCidade = fk_idCidade;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public int getCliente_id() {
        return Cliente_id;
    }

    public void setCliente_id(int Cliente_id) {
        this.Cliente_id = Cliente_id;
    }

    public int getFk_idFuncionario() {
        return fk_idFuncionario;
    }

    public void setFk_idFuncionario(int fk_idFuncionario) {
        this.fk_idFuncionario = fk_idFuncionario;
    }

   
    
}
