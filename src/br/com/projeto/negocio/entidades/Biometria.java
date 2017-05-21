package br.com.projeto.negocio.entidades;

public class Biometria extends Entidade {

    private int idBiometria;
    private float Bracodir;
    private float Bracoesq;
    private float Busto;
    private float Quadril;
    private float Pernadir;
    private float Pernaesq;
    private float Cintura;
    private float Abdomem;
    private float Culote;
    private float CoxaDir;
    private float Coxaesq;
    private boolean Celulite;
    private int Graucelulite;
    private boolean Gorduraloc;
    private String Localgorduraloc;
    private boolean Ptose;
    private String Localptose;
    private boolean Vibices;
    private String Localvibices;
    private int Cliente_id;

    public Biometria() {
    }

    public Biometria(int idBiometria, float Bracodir, float Bracoesq, float Busto, float Quadril, float Pernadir, float Pernaesq, float Cintura, float Abdomem, float Culote, float CoxaDir, float Coxaesq, boolean Celulite, int Graucelulite, boolean Gorduraloc, String Localgorduraloc, boolean Ptose, String Localptose, boolean Vibices, String Localvibices, int Cliente_id) {
        this.idBiometria = idBiometria;
        this.Bracodir = Bracodir;
        this.Bracoesq = Bracoesq;
        this.Busto = Busto;
        this.Quadril = Quadril;
        this.Pernadir = Pernadir;
        this.Pernaesq = Pernaesq;
        this.Cintura = Cintura;
        this.Abdomem = Abdomem;
        this.Culote = Culote;
        this.CoxaDir = CoxaDir;
        this.Coxaesq = Coxaesq;
        this.Celulite = Celulite;
        this.Graucelulite = Graucelulite;
        this.Gorduraloc = Gorduraloc;
        this.Localgorduraloc = Localgorduraloc;
        this.Ptose = Ptose;
        this.Localptose = Localptose;
        this.Vibices = Vibices;
        this.Localvibices = Localvibices;
        this.Cliente_id = Cliente_id;
    }

    public int getIdBiometria() {
        return idBiometria;
    }

    public void setIdBiometria(int idBiometria) {
        this.idBiometria = idBiometria;
    }

    public float getBracodir() {
        return Bracodir;
    }

    public void setBracodir(float Bracodir) {
        this.Bracodir = Bracodir;
    }

    public float getBracoesq() {
        return Bracoesq;
    }

    public void setBracoesq(float Bracoesq) {
        this.Bracoesq = Bracoesq;
    }

    public float getBusto() {
        return Busto;
    }

    public void setBusto(float Busto) {
        this.Busto = Busto;
    }

    public float getQuadril() {
        return Quadril;
    }

    public void setQuadril(float Quadril) {
        this.Quadril = Quadril;
    }

    public float getPernadir() {
        return Pernadir;
    }

    public void setPernadir(float Pernadir) {
        this.Pernadir = Pernadir;
    }

    public float getPernaesq() {
        return Pernaesq;
    }

    public void setPernaesq(float Pernaesq) {
        this.Pernaesq = Pernaesq;
    }

    public float getCintura() {
        return Cintura;
    }

    public void setCintura(float Cintura) {
        this.Cintura = Cintura;
    }

    public float getAbdomem() {
        return Abdomem;
    }

    public void setAbdomem(float Abdomem) {
        this.Abdomem = Abdomem;
    }

    public float getCulote() {
        return Culote;
    }

    public void setCulote(float Culote) {
        this.Culote = Culote;
    }

    public float getCoxaDir() {
        return CoxaDir;
    }

    public void setCoxaDir(float CoxaDir) {
        this.CoxaDir = CoxaDir;
    }

    public float getCoxaesq() {
        return Coxaesq;
    }

    public void setCoxaesq(float Coxaesq) {
        this.Coxaesq = Coxaesq;
    }

    public boolean isCelulite() {
        return Celulite;
    }

    public void setCelulite(boolean Celulite) {
        this.Celulite = Celulite;
    }

    public int getGraucelulite() {
        return Graucelulite;
    }

    public void setGraucelulite(int Graucelulite) {
        this.Graucelulite = Graucelulite;
    }

    public boolean isGorduraloc() {
        return Gorduraloc;
    }

    public void setGorduraloc(boolean Gorduraloc) {
        this.Gorduraloc = Gorduraloc;
    }

    public String getLocalgorduraloc() {
        return Localgorduraloc;
    }

    public void setLocalgorduraloc(String Localgorduraloc) {
        this.Localgorduraloc = Localgorduraloc;
    }

    public boolean isPtose() {
        return Ptose;
    }

    public void setPtose(boolean Ptose) {
        this.Ptose = Ptose;
    }

    public String getLocalptose() {
        return Localptose;
    }

    public void setLocalptose(String Localptose) {
        this.Localptose = Localptose;
    }

    public boolean isVibices() {
        return Vibices;
    }

    public void setVibices(boolean Vibices) {
        this.Vibices = Vibices;
    }

    public String getLocalvibices() {
        return Localvibices;
    }

    public void setLocalvibices(String Localvibices) {
        this.Localvibices = Localvibices;
    }

    public int getCliente_id() {
        return Cliente_id;
    }

    public void setCliente_id(int Cliente_id) {
        this.Cliente_id = Cliente_id;
    }

}
