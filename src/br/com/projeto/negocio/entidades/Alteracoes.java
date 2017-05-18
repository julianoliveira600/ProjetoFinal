package br.com.projeto.negocio.entidades;

public class Alteracoes {

    private int idClienteAlteracoes;
    private boolean Cardiaca;
    private boolean Vasculares;
    private boolean Reumaticas;
    private boolean Renais;
    private boolean Glandulares;
    private boolean Ginecologicas;
    private boolean Proteses;
    private boolean Bronquite;
    private boolean Alergias;
    private boolean Usadiu;
    private boolean PressaoMembros;
    private boolean Constipacao;
    private boolean TratamentoMedico;
    private boolean UsaMedicamentos;
    private boolean Gestante;
    private boolean Marcapasso;
    private boolean Eplepsia;
    private boolean Ancologia;
    private boolean ProtecaoPele;
    private boolean Diabetes;
    private String Observacoes;
    private int Cliente_id;

    public Alteracoes() {
    }

    public Alteracoes(int idClienteAlteracoes, boolean Cardiaca, boolean Vasculares, boolean Reumaticas, boolean Renais, boolean Glandulares, boolean Ginecologicas, boolean Proteses, boolean Bronquite, boolean Alergias, boolean Usadiu, boolean PressaoMembros, boolean Constipacao, boolean TratamentoMedico, boolean UsaMedicamentos, boolean Gestante, boolean Marcapasso, boolean Eplepsia, boolean Ancologia, boolean ProtecaoPele, boolean Diabetes, String Observacoes, int Cliente_id) {
        this.idClienteAlteracoes = idClienteAlteracoes;
        this.Cardiaca = Cardiaca;
        this.Vasculares = Vasculares;
        this.Reumaticas = Reumaticas;
        this.Renais = Renais;
        this.Glandulares = Glandulares;
        this.Ginecologicas = Ginecologicas;
        this.Proteses = Proteses;
        this.Bronquite = Bronquite;
        this.Alergias = Alergias;
        this.Usadiu = Usadiu;
        this.PressaoMembros = PressaoMembros;
        this.Constipacao = Constipacao;
        this.TratamentoMedico = TratamentoMedico;
        this.UsaMedicamentos = UsaMedicamentos;
        this.Gestante = Gestante;
        this.Marcapasso = Marcapasso;
        this.Eplepsia = Eplepsia;
        this.Ancologia = Ancologia;
        this.ProtecaoPele = ProtecaoPele;
        this.Diabetes = Diabetes;
        this.Observacoes = Observacoes;
        this.Cliente_id = Cliente_id;
    }

    public int getIdClienteAlteracoes() {
        return idClienteAlteracoes;
    }

    public void setIdClienteAlteracoes(int idClienteAlteracoes) {
        this.idClienteAlteracoes = idClienteAlteracoes;
    }

    public boolean isCardiaca() {
        return Cardiaca;
    }

    public void setCardiaca(boolean Cardiaca) {
        this.Cardiaca = Cardiaca;
    }

    public boolean isVasculares() {
        return Vasculares;
    }

    public void setVasculares(boolean Vasculares) {
        this.Vasculares = Vasculares;
    }

    public boolean isReumaticas() {
        return Reumaticas;
    }

    public void setReumaticas(boolean Reumaticas) {
        this.Reumaticas = Reumaticas;
    }

    public boolean isRenais() {
        return Renais;
    }

    public void setRenais(boolean Renais) {
        this.Renais = Renais;
    }

    public boolean isGlandulares() {
        return Glandulares;
    }

    public void setGlandulares(boolean Glandulares) {
        this.Glandulares = Glandulares;
    }

    public boolean isGinecologicas() {
        return Ginecologicas;
    }

    public void setGinecologicas(boolean Ginecologicas) {
        this.Ginecologicas = Ginecologicas;
    }

    public boolean isProteses() {
        return Proteses;
    }

    public void setProteses(boolean Proteses) {
        this.Proteses = Proteses;
    }

    public boolean isBronquite() {
        return Bronquite;
    }

    public void setBronquite(boolean Bronquite) {
        this.Bronquite = Bronquite;
    }

    public boolean isAlergias() {
        return Alergias;
    }

    public void setAlergias(boolean Alergias) {
        this.Alergias = Alergias;
    }

    public boolean isUsadiu() {
        return Usadiu;
    }

    public void setUsadiu(boolean Usadiu) {
        this.Usadiu = Usadiu;
    }

    public boolean isPressaoMembros() {
        return PressaoMembros;
    }

    public void setPressaoMembros(boolean PressaoMembros) {
        this.PressaoMembros = PressaoMembros;
    }

    public boolean isConstipacao() {
        return Constipacao;
    }

    public void setConstipacao(boolean Constipacao) {
        this.Constipacao = Constipacao;
    }

    public boolean isTratamentoMedico() {
        return TratamentoMedico;
    }

    public void setTratamentoMedico(boolean TratamentoMedico) {
        this.TratamentoMedico = TratamentoMedico;
    }

    public boolean isUsaMedicamentos() {
        return UsaMedicamentos;
    }

    public void setUsaMedicamentos(boolean UsaMedicamentos) {
        this.UsaMedicamentos = UsaMedicamentos;
    }

    public boolean isGestante() {
        return Gestante;
    }

    public void setGestante(boolean Gestante) {
        this.Gestante = Gestante;
    }

    public boolean isMarcapasso() {
        return Marcapasso;
    }

    public void setMarcapasso(boolean Marcapasso) {
        this.Marcapasso = Marcapasso;
    }

    public boolean isEplepsia() {
        return Eplepsia;
    }

    public void setEplepsia(boolean Eplepsia) {
        this.Eplepsia = Eplepsia;
    }

    public boolean isAncologia() {
        return Ancologia;
    }

    public void setAncologia(boolean Ancologia) {
        this.Ancologia = Ancologia;
    }

    public boolean isProtecaoPele() {
        return ProtecaoPele;
    }

    public void setProtecaoPele(boolean ProtecaoPele) {
        this.ProtecaoPele = ProtecaoPele;
    }

    public boolean isDiabetes() {
        return Diabetes;
    }

    public void setDiabetes(boolean Diabetes) {
        this.Diabetes = Diabetes;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String Observacoes) {
        this.Observacoes = Observacoes;
    }

    public int getCliente_id() {
        return Cliente_id;
    }

    public void setCliente_id(int Cliente_id) {
        this.Cliente_id = Cliente_id;
    }

}
