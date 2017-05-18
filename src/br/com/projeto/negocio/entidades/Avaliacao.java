package br.com.projeto.negocio.entidades;

public class Avaliacao {

    private int idAvaliacao;
    private int CorPele;
    private int AparenciaPele;
    private int SuperficiePele;
    private int LesoesPele;
    private int BiotipoCultaneo;
    private int Acne;
    private int Flacidez;
    private int Desidratacao;
    private boolean Miliun;
    private boolean Copuperose;
    private boolean Telangiectasia;
    private boolean Efelidez;
    private boolean Xantelasma;
    private boolean Rugas;
    private boolean Rosacea;
    private boolean Seborreia;
    private boolean Foliculite;
    private boolean Cicatriz;
    private boolean VerrugasPintas;
    private boolean Acromia;
    private boolean Cloasma;
    private boolean Hipercromia;
    private boolean Hipocromia;
    private boolean Angioma;
    private boolean Eritema;
    private boolean Petequias;
    private boolean Cianose;
    private boolean Hematoma;
    private boolean Ceratose;
    private boolean Papulas;
    private boolean Comedao;
    private boolean Necrose;
    private boolean Nodulos;
    private boolean Bolhas;
    private boolean Pustulas;
    private boolean Vesicula;
    private boolean Crosta;
    private boolean Escara;
    private boolean Fisura;
    private boolean Ulceracao;
    private boolean Descamacao;
    private boolean Escoriacao;
    private boolean Fistula;
    private boolean Atrofia;
    private boolean hipertricose;
    private boolean Hirsutismo;
    private boolean Eczema;
    private boolean hiperqueratose;
    private boolean Psoariase;
    private int OleosidadePele;
    private int Espessura;
    private String Observacoes;
    private int Cliente_id;

    public Avaliacao() {
    }

    public Avaliacao(int idAvaliacao, int CorPele, int AparenciaPele, int SuperficiePele, int LesoesPele, int BiotipoCultaneo, int Acne, int Flacidez, int Desidratacao, boolean Miliun, boolean Copuperose, boolean Telangiectasia, boolean Efelidez, boolean Xantelasma, boolean Rugas, boolean Rosacea, boolean Seborreia, boolean Foliculite, boolean Cicatriz, boolean VerrugasPintas, boolean Acromia, boolean Cloasma, boolean Hipercromia, boolean Hipocromia, boolean Angioma, boolean Eritema, boolean Petequias, boolean Cianose, boolean Hematoma, boolean Ceratose, boolean Papulas, boolean Comedao, boolean Necrose, boolean Nodulos, boolean Bolhas, boolean Pustulas, boolean Vesicula, boolean Crosta, boolean Escara, boolean Fisura, boolean Ulceracao, boolean Descamacao, boolean Escoriacao, boolean Fistula, boolean Atrofia, boolean hipertricose, boolean Hirsutismo, boolean Eczema, boolean hiperqueratose, boolean Psoariase, int OleosidadePele, int Espessura, String Observacoes, int Cliente_id) {
        this.idAvaliacao = idAvaliacao;
        this.CorPele = CorPele;
        this.AparenciaPele = AparenciaPele;
        this.SuperficiePele = SuperficiePele;
        this.LesoesPele = LesoesPele;
        this.BiotipoCultaneo = BiotipoCultaneo;
        this.Acne = Acne;
        this.Flacidez = Flacidez;
        this.Desidratacao = Desidratacao;
        this.Miliun = Miliun;
        this.Copuperose = Copuperose;
        this.Telangiectasia = Telangiectasia;
        this.Efelidez = Efelidez;
        this.Xantelasma = Xantelasma;
        this.Rugas = Rugas;
        this.Rosacea = Rosacea;
        this.Seborreia = Seborreia;
        this.Foliculite = Foliculite;
        this.Cicatriz = Cicatriz;
        this.VerrugasPintas = VerrugasPintas;
        this.Acromia = Acromia;
        this.Cloasma = Cloasma;
        this.Hipercromia = Hipercromia;
        this.Hipocromia = Hipocromia;
        this.Angioma = Angioma;
        this.Eritema = Eritema;
        this.Petequias = Petequias;
        this.Cianose = Cianose;
        this.Hematoma = Hematoma;
        this.Ceratose = Ceratose;
        this.Papulas = Papulas;
        this.Comedao = Comedao;
        this.Necrose = Necrose;
        this.Nodulos = Nodulos;
        this.Bolhas = Bolhas;
        this.Pustulas = Pustulas;
        this.Vesicula = Vesicula;
        this.Crosta = Crosta;
        this.Escara = Escara;
        this.Fisura = Fisura;
        this.Ulceracao = Ulceracao;
        this.Descamacao = Descamacao;
        this.Escoriacao = Escoriacao;
        this.Fistula = Fistula;
        this.Atrofia = Atrofia;
        this.hipertricose = hipertricose;
        this.Hirsutismo = Hirsutismo;
        this.Eczema = Eczema;
        this.hiperqueratose = hiperqueratose;
        this.Psoariase = Psoariase;
        this.OleosidadePele = OleosidadePele;
        this.Espessura = Espessura;
        this.Observacoes = Observacoes;
        this.Cliente_id = Cliente_id;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public int getCorPele() {
        return CorPele;
    }

    public void setCorPele(int CorPele) {
        this.CorPele = CorPele;
    }

    public int getAparenciaPele() {
        return AparenciaPele;
    }

    public void setAparenciaPele(int AparenciaPele) {
        this.AparenciaPele = AparenciaPele;
    }

    public int getSuperficiePele() {
        return SuperficiePele;
    }

    public void setSuperficiePele(int SuperficiePele) {
        this.SuperficiePele = SuperficiePele;
    }

    public int getLesoesPele() {
        return LesoesPele;
    }

    public void setLesoesPele(int LesoesPele) {
        this.LesoesPele = LesoesPele;
    }

    public int getBiotipoCultaneo() {
        return BiotipoCultaneo;
    }

    public void setBiotipoCultaneo(int BiotipoCultaneo) {
        this.BiotipoCultaneo = BiotipoCultaneo;
    }

    public int getAcne() {
        return Acne;
    }

    public void setAcne(int Acne) {
        this.Acne = Acne;
    }

    public int getFlacidez() {
        return Flacidez;
    }

    public void setFlacidez(int Flacidez) {
        this.Flacidez = Flacidez;
    }

    public int getDesidratacao() {
        return Desidratacao;
    }

    public void setDesidratacao(int Desidratacao) {
        this.Desidratacao = Desidratacao;
    }

    public boolean isMiliun() {
        return Miliun;
    }

    public void setMiliun(boolean Miliun) {
        this.Miliun = Miliun;
    }

    public boolean isCopuperose() {
        return Copuperose;
    }

    public void setCopuperose(boolean Copuperose) {
        this.Copuperose = Copuperose;
    }

    public boolean isTelangiectasia() {
        return Telangiectasia;
    }

    public void setTelangiectasia(boolean Telangiectasia) {
        this.Telangiectasia = Telangiectasia;
    }

    public boolean isEfelidez() {
        return Efelidez;
    }

    public void setEfelidez(boolean Efelidez) {
        this.Efelidez = Efelidez;
    }

    public boolean isXantelasma() {
        return Xantelasma;
    }

    public void setXantelasma(boolean Xantelasma) {
        this.Xantelasma = Xantelasma;
    }

    public boolean isRugas() {
        return Rugas;
    }

    public void setRugas(boolean Rugas) {
        this.Rugas = Rugas;
    }

    public boolean isRosacea() {
        return Rosacea;
    }

    public void setRosacea(boolean Rosacea) {
        this.Rosacea = Rosacea;
    }

    public boolean isSeborreia() {
        return Seborreia;
    }

    public void setSeborreia(boolean Seborreia) {
        this.Seborreia = Seborreia;
    }

    public boolean isFoliculite() {
        return Foliculite;
    }

    public void setFoliculite(boolean Foliculite) {
        this.Foliculite = Foliculite;
    }

    public boolean isCicatriz() {
        return Cicatriz;
    }

    public void setCicatriz(boolean Cicatriz) {
        this.Cicatriz = Cicatriz;
    }

    public boolean isVerrugasPintas() {
        return VerrugasPintas;
    }

    public void setVerrugasPintas(boolean VerrugasPintas) {
        this.VerrugasPintas = VerrugasPintas;
    }

    public boolean isAcromia() {
        return Acromia;
    }

    public void setAcromia(boolean Acromia) {
        this.Acromia = Acromia;
    }

    public boolean isCloasma() {
        return Cloasma;
    }

    public void setCloasma(boolean Cloasma) {
        this.Cloasma = Cloasma;
    }

    public boolean isHipercromia() {
        return Hipercromia;
    }

    public void setHipercromia(boolean Hipercromia) {
        this.Hipercromia = Hipercromia;
    }

    public boolean isHipocromia() {
        return Hipocromia;
    }

    public void setHipocromia(boolean Hipocromia) {
        this.Hipocromia = Hipocromia;
    }

    public boolean isAngioma() {
        return Angioma;
    }

    public void setAngioma(boolean Angioma) {
        this.Angioma = Angioma;
    }

    public boolean isEritema() {
        return Eritema;
    }

    public void setEritema(boolean Eritema) {
        this.Eritema = Eritema;
    }

    public boolean isPetequias() {
        return Petequias;
    }

    public void setPetequias(boolean Petequias) {
        this.Petequias = Petequias;
    }

    public boolean isCianose() {
        return Cianose;
    }

    public void setCianose(boolean Cianose) {
        this.Cianose = Cianose;
    }

    public boolean isHematoma() {
        return Hematoma;
    }

    public void setHematoma(boolean Hematoma) {
        this.Hematoma = Hematoma;
    }

    public boolean isCeratose() {
        return Ceratose;
    }

    public void setCeratose(boolean Ceratose) {
        this.Ceratose = Ceratose;
    }

    public boolean isPapulas() {
        return Papulas;
    }

    public void setPapulas(boolean Papulas) {
        this.Papulas = Papulas;
    }

    public boolean isComedao() {
        return Comedao;
    }

    public void setComedao(boolean Comedao) {
        this.Comedao = Comedao;
    }

    public boolean isNecrose() {
        return Necrose;
    }

    public void setNecrose(boolean Necrose) {
        this.Necrose = Necrose;
    }

    public boolean isNodulos() {
        return Nodulos;
    }

    public void setNodulos(boolean Nodulos) {
        this.Nodulos = Nodulos;
    }

    public boolean isBolhas() {
        return Bolhas;
    }

    public void setBolhas(boolean Bolhas) {
        this.Bolhas = Bolhas;
    }

    public boolean isPustulas() {
        return Pustulas;
    }

    public void setPustulas(boolean Pustulas) {
        this.Pustulas = Pustulas;
    }

    public boolean isVesicula() {
        return Vesicula;
    }

    public void setVesicula(boolean Vesicula) {
        this.Vesicula = Vesicula;
    }

    public boolean isCrosta() {
        return Crosta;
    }

    public void setCrosta(boolean Crosta) {
        this.Crosta = Crosta;
    }

    public boolean isEscara() {
        return Escara;
    }

    public void setEscara(boolean Escara) {
        this.Escara = Escara;
    }

    public boolean isFisura() {
        return Fisura;
    }

    public void setFisura(boolean Fisura) {
        this.Fisura = Fisura;
    }

    public boolean isUlceracao() {
        return Ulceracao;
    }

    public void setUlceracao(boolean Ulceracao) {
        this.Ulceracao = Ulceracao;
    }

    public boolean isDescamacao() {
        return Descamacao;
    }

    public void setDescamacao(boolean Descamacao) {
        this.Descamacao = Descamacao;
    }

    public boolean isEscoriacao() {
        return Escoriacao;
    }

    public void setEscoriacao(boolean Escoriacao) {
        this.Escoriacao = Escoriacao;
    }

    public boolean isFistula() {
        return Fistula;
    }

    public void setFistula(boolean Fistula) {
        this.Fistula = Fistula;
    }

    public boolean isAtrofia() {
        return Atrofia;
    }

    public void setAtrofia(boolean Atrofia) {
        this.Atrofia = Atrofia;
    }

    public boolean isHipertricose() {
        return hipertricose;
    }

    public void setHipertricose(boolean hipertricose) {
        this.hipertricose = hipertricose;
    }

    public boolean isHirsutismo() {
        return Hirsutismo;
    }

    public void setHirsutismo(boolean Hirsutismo) {
        this.Hirsutismo = Hirsutismo;
    }

    public boolean isEczema() {
        return Eczema;
    }

    public void setEczema(boolean Eczema) {
        this.Eczema = Eczema;
    }

    public boolean isHiperqueratose() {
        return hiperqueratose;
    }

    public void setHiperqueratose(boolean hiperqueratose) {
        this.hiperqueratose = hiperqueratose;
    }

    public boolean isPsoariase() {
        return Psoariase;
    }

    public void setPsoariase(boolean Psoariase) {
        this.Psoariase = Psoariase;
    }

    public int getOleosidadePele() {
        return OleosidadePele;
    }

    public void setOleosidadePele(int OleosidadePele) {
        this.OleosidadePele = OleosidadePele;
    }

    public int getEspessura() {
        return Espessura;
    }

    public void setEspessura(int Espessura) {
        this.Espessura = Espessura;
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
